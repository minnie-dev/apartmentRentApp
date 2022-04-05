package com.housepriceapp.houseprice

import android.annotation.SuppressLint
import android.content.res.AssetManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.housepriceapp.houseprice.data.Item
import com.housepriceapp.houseprice.data.RetrofitObject
import com.housepriceapp.houseprice.databinding.ActivityMainBinding
import com.housepriceapp.houseprice.room.LegalDongCode
import com.housepriceapp.houseprice.room.LegalDongDB
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.io.InputStream

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var codeAdapter: LegalDongCodeAdapter

    var legalDongCodeList: List<LegalDongCode>? = null
    var houseInfoList: List<Item>? = null
    lateinit var legalDB: LegalDongDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        legalDB = LegalDongDB.getInstance(this)!!

        // db에 저장되어있는 법정동 코드 리스트에 추가
        setLegalDongList()
    }

    @SuppressLint("CheckResult")
    fun setLegalDongList() {
        legalDB.legalDongDao().getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                if (it.isEmpty()) {
                    legalCodeDB()
                }

                if (legalDongCodeList == null) {
                    legalDongCodeList = it

                    codeAdapter = LegalDongCodeAdapter(legalDongCodeList!!)

                    binding.recyclerView.apply {
                        adapter = codeAdapter
                        layoutManager = LinearLayoutManager(this@MainActivity)
                    }

                    // recyclerview item click
                    codeAdapter.setItemClickListener(object :
                        LegalDongCodeAdapter.OnItemClickEventListener {
                        override fun onItemClick(name: String, position: Int) {
                            val legaldongInfo = legalDB.legalDongDao().getNameSearch(name)
                            getRent(legaldongInfo.code)
                        }
                    })

                }
            }
    }

    /* 법정동 코드 DB 저장 */
    @SuppressLint("CheckResult")
    fun legalCodeDB() {
        val assetManager: AssetManager = resources.assets
        val inputStream: InputStream = assetManager.open("legaldongCode.txt")

        inputStream.bufferedReader().readLines().forEachIndexed { idx, list ->
            val legaldong = list.split("\t")
            legalDB.legalDongDao().insert(LegalDongCode(idx, legaldong[1], legaldong[0].toInt()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { println("db save") }
        }
    }

    /*서버에서 아파트 전월세 데이터 받아오기*/
    @SuppressLint("CheckResult")
    fun getRent(code: Int) {
        RetrofitObject.getApiService().getInfo(code, 202201, "xml")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                houseInfoList = it.body.items.item
                val listFragment = HouseInfoFragment(houseInfoList!!)
                supportFragmentManager.beginTransaction()
                    .replace(binding.fragmentContainer.id, listFragment)
                    .commit()
                binding.recyclerView.visibility = View.GONE
                Log.d("success", it.body.toString())
            }, {
                Log.d("fail", it.toString())
            })
    }

}