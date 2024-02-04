package com.example.homprent.presentation.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homprent.R
import com.example.homprent.model.data_class.DetailsPageModel
import com.example.homprent.model.data_class.NearPlace
import com.example.homprent.presentation.DetailsActivity
import com.example.homprent.presentation.Test
import com.squareup.picasso.Picasso

class HouseListviewAdapter(near_house:List<NearPlace>,context:Context): RecyclerView.Adapter<HouseListviewAdapter.HouseViewHolder>() {
    private val nearhouse:List<NearPlace> = near_house;
    private val context:Context=context;
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HouseListviewAdapter.HouseViewHolder {
        var view:View=LayoutInflater.from(parent.context).inflate(R.layout.house_list_view,parent,false)
        return HouseViewHolder(view)
    }

    override fun onBindViewHolder(holder: HouseListviewAdapter.HouseViewHolder, position: Int) {
        holder.house_name.text=nearhouse[position].hotel_name;
        holder.house_distance.text=nearhouse[position].distance;
        holder.house_subtitle.text=nearhouse[position].sub_title
        Picasso.get().load(nearhouse[position].hotel_thum_image).into(holder.house_image)

        holder.itemView.setOnClickListener {
            val details: DetailsPageModel = DetailsPageModel(
                house_image = nearhouse[position].hotel_thum_image,
                house_name = nearhouse[position].hotel_name,
                house_details = nearhouse[position].description,
                house_subtitle = nearhouse[position].sub_title,
                bedroom = nearhouse[position].bedroom,
                bathroom = nearhouse[position].bathroom,
                owner_name = nearhouse[position].owrner.name,
                owner_phone = nearhouse[position].owrner.phone,
                gallery_list = nearhouse[position].galary,
                location = nearhouse[position].location_url,
                price = nearhouse[position].bill);
            val details_intent:Intent= Intent(context,DetailsActivity::class.java)
            details_intent.putExtra("data",details)
            context.startActivity(details_intent)
        }
    }

    override fun getItemCount(): Int {
        return  nearhouse.size
    }

    class HouseViewHolder(houseitemview:View):RecyclerView.ViewHolder(houseitemview){
        var house_image:ImageView=houseitemview.findViewById(R.id.house_image);
        var house_name:TextView=houseitemview.findViewById(R.id.house_name);
        var house_subtitle:TextView=houseitemview.findViewById(R.id.house_name_subtitle);
        var house_distance:TextView=houseitemview.findViewById(R.id.house_distance);
    }
}