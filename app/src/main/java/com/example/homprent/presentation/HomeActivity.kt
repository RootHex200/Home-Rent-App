package com.example.homprent.presentation

import android.Manifest
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
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homprent.R
import com.example.homprent.databinding.ActivityMainBinding
import com.example.homprent.presentation.adapter.BestHouseListviewAdapter
import com.example.homprent.presentation.adapter.HouseListviewAdapter
import com.example.homprent.presentation.adapter.OptionButtonAdapter
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.security.Permissions
import java.util.Locale

class HomeActivity : AppCompatActivity() {
    lateinit var recyview:RecyclerView
    lateinit var houselistview:RecyclerView;
    lateinit var besthouselistview:RecyclerView;
    lateinit var locationClient:FusedLocationProviderClient;
    lateinit var currentLocation:TextView;
    lateinit var binding:ActivityMainBinding
    lateinit var changelocationbtn:ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initilization();
    }

    fun initilization(){
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        locationClient=LocationServices.getFusedLocationProviderClient(this)

        currentLocation=findViewById(R.id.current_location_name);
        houselistview=findViewById(R.id.house_list_recyclerview);
        besthouselistview=findViewById(R.id.best_house_list_view);
        var option_button:ArrayList<String> = arrayListOf("Home","Apartment","Hotel","Villa","SingleRoom");
        recyview=findViewById(R.id.recyclerview);
        recyview.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyview.adapter=OptionButtonAdapter(option_button)

        houselistview.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        houselistview.adapter=HouseListviewAdapter();

        val myLinearLayoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        besthouselistview.layoutManager=myLinearLayoutManager
        besthouselistview.adapter=BestHouseListviewAdapter();

        changelocationbtn=findViewById(R.id.current_location_change_btn)
        getLocation()
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
                        currentLocationName.text=list[0].latitude.toString()
                    }

                }

            }
        }

    }
}