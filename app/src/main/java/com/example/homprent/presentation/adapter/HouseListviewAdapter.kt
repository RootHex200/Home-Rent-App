package com.example.homprent.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homprent.R

class HouseListviewAdapter(): RecyclerView.Adapter<HouseListviewAdapter.HouseViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HouseListviewAdapter.HouseViewHolder {
        var view:View=LayoutInflater.from(parent.context).inflate(R.layout.house_list_view,parent,false)
        return HouseViewHolder(view)
    }

    override fun onBindViewHolder(holder: HouseListviewAdapter.HouseViewHolder, position: Int) {
        holder.house_name.text="sabitur $position";
    }

    override fun getItemCount(): Int {
        return  5
    }

    class HouseViewHolder(houseitemview:View):RecyclerView.ViewHolder(houseitemview){
        var house_image:ImageView=houseitemview.findViewById(R.id.house_image);
        var house_name:TextView=houseitemview.findViewById(R.id.house_name);
        var house_subtitle:TextView=houseitemview.findViewById(R.id.house_name_subtitle);
        var house_distance:TextView=houseitemview.findViewById(R.id.house_distance);
    }
}