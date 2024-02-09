package com.example.homprent.src.feature.homerent.presentation.activity

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homprent.R
import com.example.homprent.src.feature.homerent.data.model.DetailsPageModel
import com.example.homprent.src.feature.homerent.presentation.activity.adapter.GalleryListViewAdapter
import com.squareup.picasso.Picasso


class DetailsActivity() : AppCompatActivity(){
    lateinit var galleryImageList:RecyclerView;
    lateinit var house_bill:TextView;
    lateinit var rent_btn:Button;
    lateinit var owner_phone:CardView;
    lateinit var owner_name:TextView;
    lateinit var house_name:TextView;
    lateinit var house_subtitle:TextView;
    lateinit var house_bedroom:TextView;
    lateinit var house_bathroom:TextView;
    lateinit var house_image:ImageView;
    lateinit var house_description:TextView
    lateinit var owner_message:CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        initialization();
    }

    private fun initialization(){
        Log.d("DetailsActivity.show","data is here")
        val house_data: DetailsPageModel = intent.getParcelableExtra("data")!!
        galleryImageList=findViewById(R.id.gallery_recyclerview)

        val location=house_data.location.split(",")
        val lat=location[0].toDouble()
        val lng=location[1].toDouble()

        supportFragmentManager.beginTransaction().replace(R.id.map_view_container,CustomMap(lat,lng,house_data.house_name.toString())).commit()


        house_name=findViewById(R.id.house_name);
        house_description=findViewById(R.id.house_details);
        house_image=findViewById(R.id.details_image);
        house_bathroom=findViewById(R.id.house_bathroom);
        house_bedroom=findViewById(R.id.house_bedroom);

        house_description=findViewById(R.id.house_details);
        owner_name=findViewById(R.id.owner_name);
        owner_phone=findViewById(R.id.call_owner);

        house_bill=findViewById(R.id.house_bill);
        rent_btn=findViewById(R.id.rent_now_btn);

        house_subtitle=findViewById(R.id.house_name_subtitle)
//
//
//        //set value
//
        house_name.text=house_data.house_name;
        house_subtitle.text=house_data.house_subtitle;
        house_bathroom.text=house_data.bathroom;
        house_bedroom.text=house_data.bedroom;
        Picasso.get().load(house_data.house_image).into(house_image)

        house_description.text=house_data.house_details;

        owner_name.text=house_data.owner_name;

        owner_phone.setOnClickListener{
            //navigate to call
            val phoneIntent:Intent= Intent(Intent.ACTION_CALL, Uri.parse("tel:" + house_data.owner_phone.toString()))
            startActivity(phoneIntent)
        }


        galleryImageList.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        galleryImageList.adapter= GalleryListViewAdapter(house_data.gallery_list)
        house_bill.text=house_data.price
//
    }
}