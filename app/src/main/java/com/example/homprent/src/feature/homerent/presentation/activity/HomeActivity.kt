package com.example.homprent.src.feature.homerent.presentation.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homprent.R
import com.example.homprent.databinding.ActivityMainBinding
import com.example.homprent.src.core.common.HotelListViewModelFactory
import com.example.homprent.src.feature.homerent.data.data_source.RemoteDataSourceImpl
import com.example.homprent.src.feature.homerent.data.repository.HotelRepositoryImpl
import com.example.homprent.src.feature.homerent.domain.usecase.HotelUseCases
import com.example.homprent.src.feature.homerent.presentation.activity.adapter.BestHouseListviewAdapter
import com.example.homprent.src.feature.homerent.presentation.activity.adapter.HouseListviewAdapter
import com.example.homprent.src.feature.homerent.presentation.activity.adapter.OptionButtonAdapter
import com.example.homprent.src.feature.homerent.presentation.viewmodel.HotelListViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.util.Locale

class HomeActivity : AppCompatActivity() {
    lateinit var recyview:RecyclerView
    lateinit var houselistview:RecyclerView;
    lateinit var besthouselistview:RecyclerView;
    lateinit var locationClient:FusedLocationProviderClient;
    lateinit var currentLocation:TextView;
    lateinit var binding:ActivityMainBinding
    lateinit var changelocationbtn:ImageButton
    lateinit var progressbar:ProgressBar;
    lateinit var hotelViewModel:HotelListViewModel;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initilization();
    }

    fun initilization(){
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        locationClient=LocationServices.getFusedLocationProviderClient(this)

        progressbar=findViewById(R.id.progressbar)
        currentLocation=findViewById(R.id.current_location_name);
        houselistview=findViewById(R.id.house_list_recyclerview);
        besthouselistview=findViewById(R.id.best_house_list_view);
        var option_button:ArrayList<String> = arrayListOf("Home","Apartment","Hotel","Villa","SingleRoom");
        recyview=findViewById(R.id.recyclerview);
        recyview.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyview.adapter= OptionButtonAdapter(option_button)

        houselistview.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);


        val myLinearLayoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        besthouselistview.layoutManager=myLinearLayoutManager
        changelocationbtn=findViewById(R.id.current_location_change_btn)

        val usecases:HotelUseCases =  HotelUseCases(HotelRepositoryImpl(RemoteDataSourceImpl()))

        hotelViewModel =ViewModelProviders.of(this,HotelListViewModelFactory(usecases)).get(HotelListViewModel::class.java)
        getLocation()

        hotelViewModel.isLoading.observe(this) { value ->
            if (value) {
                progressbar.visibility = ProgressBar.VISIBLE
            } else {
                progressbar.visibility = ProgressBar.INVISIBLE
            }
        }

        hotelViewModel.nearHotelList.observe(this
        ) { value -> houselistview.adapter = HouseListviewAdapter(value, this@HomeActivity); }

        hotelViewModel.bestHotelList.observe(this
        ) { value ->
            besthouselistview.adapter = BestHouseListviewAdapter(value, this@HomeActivity);
        }
    }

    fun isEnableLocation():Boolean{
        val locationmanager:LocationManager=getSystemService(Context.LOCATION_SERVICE) as LocationManager;
        return locationmanager.isProviderEnabled(LocationManager.GPS_PROVIDER)||locationmanager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    }

    private fun checkPermissions():Boolean {
        return (ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_COARSE_LOCATION)==PackageManager.PERMISSION_GRANTED
                &&
                ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED)
    }

    private fun requestPermission(){
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION,android.Manifest.permission.ACCESS_COARSE_LOCATION),2)
    }

    @SuppressLint("MissingSuperCall")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        if(requestCode==2){
            Log.d("permission_location",permissions.toString())
            if(grantResults.isNotEmpty()&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                getLocation()
            }
        }
    }


    @SuppressLint("MissingPermission")
    private fun getLocation(){

        if(!checkPermissions()){
            requestPermission()
        }
        if(!isEnableLocation()){
            Toast.makeText(this,"Please Turn On Location",Toast.LENGTH_SHORT).show();
            val intent:Intent= Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intent)
        }
        if(isEnableLocation()&&checkPermissions()){
            locationClient.lastLocation.addOnCompleteListener(this){ task->
                val location:Location?=task.result;
                if(location!=null){
                    Log.d("latitude",location.latitude.toString());
                    val geocoder=Geocoder(this,Locale.getDefault());
                    val list: List<Address> =
                        geocoder.getFromLocation(location.latitude,location.longitude,1)!!;
                    Log.d("location",list.toString())
                    binding.apply {
                        currentLocationName.text=list[0].locality.toString()
                        hotelViewModel.getHotelListData(list[0].locality.toString().toLowerCase())

                    }

                }

            }
        }

    }

}

