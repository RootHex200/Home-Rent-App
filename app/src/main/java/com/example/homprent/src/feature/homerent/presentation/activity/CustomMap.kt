package com.example.homprent.src.feature.homerent.presentation.activity

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homprent.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class CustomMap(lat:Double,lng:Double,name:String) : Fragment() {
    private val lat:Double=lat;
    private val lng:Double=lng;
    private val name:String=name;
    private val callback = OnMapReadyCallback { googleMap ->
        Log.d("GoogleMapLogger","Google Logger is here")
        val sydney = LatLng(lat, lng)
        googleMap.addMarker(MarkerOptions().position(sydney).title(name.toString()))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,16f))


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_custom_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}