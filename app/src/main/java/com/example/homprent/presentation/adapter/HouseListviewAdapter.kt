package com.example.homprent.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homprent.R
import com.example.homprent.model.data_class.NearPlace
import com.squareup.picasso.Picasso

class HouseListviewAdapter(near_house:List<NearPlace>): RecyclerView.Adapter<HouseListviewAdapter.HouseViewHolder>() {
    private val nearhouse:List<NearPlace> = near_house;
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