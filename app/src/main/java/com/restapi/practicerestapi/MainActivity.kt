package com.restapi.practicerestapi

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.*
import com.naver.maps.map.util.FusedLocationSource
import com.restapi.practicerestapi.databinding.ActivityMainBinding
import io.reactivex.schedulers.Schedulers


class MainActivity : AppCompatActivity() , OnMapReadyCallback {

    lateinit var binding: ActivityMainBinding
    lateinit var naverMap : NaverMap
    lateinit var locationSource: FusedLocationSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mapView.onCreate(savedInstanceState)
        binding.mapView.getMapAsync(this)
        NaverMapSdk.getInstance(this).client=
            NaverMapSdk.NaverCloudPlatformClient(BuildConfig.NAVER_CLIENT_ID)

        getTour()
    }

    @SuppressLint("CheckResult")
    fun getTour(){
        RetrofitObject.getApiService().getInfo(10,1,
            "ETC","AppTest","A",
            15,126.981611,37.568477, 1000,"Y")
            .observeOn(Schedulers.io())
            .subscribeOn(Schedulers.io())
            .subscribe({
                Log.d("투어", it.body.toString())
            }, {
                Log.d("투어 실패", it.toString())
            })
    }

    override fun onStart() {
        super.onStart()
        binding.mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        binding.mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        binding.mapView.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding.mapView.onSaveInstanceState(outState)
    }

    override fun onStop() {
        super.onStop()
        binding.mapView.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        binding.mapView.onLowMemory()
    }

    override fun onMapReady(map: NaverMap) {
        naverMap = map
        naverMap.maxZoom = 18.0
        naverMap.minZoom = 10.0

        val cameraUpdate = CameraUpdate.scrollTo(LatLng(37.58490707916565, 126.88572629175184))
        naverMap.moveCamera(cameraUpdate)

        val uiSettings = naverMap.uiSettings
        uiSettings.isLocationButtonEnabled = true

        locationSource = FusedLocationSource(this@MainActivity, LOCATION_PERMISSION_REQUEST_CODE)
        naverMap.locationSource = locationSource
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode!=LOCATION_PERMISSION_REQUEST_CODE){
            return
        }
        if(locationSource.onRequestPermissionsResult(requestCode,permissions, grantResults)){
            if(!locationSource.isActivated){
                naverMap.locationTrackingMode = LocationTrackingMode.None
            }
            return
        }
    }

    companion object{
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1004
    }
}