package com.example.homprent.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homprent.R
import com.example.homprent.presentation.adapter.GalleryListViewAdapter


class DetailsActivity : AppCompatActivity(){
    lateinit var galleryImageList:RecyclerView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        galleryImageList=findViewById(R.id.gallery_recyclerview)

        galleryImageList.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        galleryImageList.adapter=GalleryListViewAdapter()

        supportFragmentManager.beginTransaction().replace(R.id.map_view_container,CustomMap()).commit()

    }
}