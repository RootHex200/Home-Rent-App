package com.example.homprent.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homprent.R
import org.w3c.dom.Text

class BestHouseListviewAdapter():RecyclerView.Adapter<BestHouseListviewAdapter.BestHouseViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BestHouseListviewAdapter.BestHouseViewHolder {
        var besthouseview:View=LayoutInflater.from(parent.context).inflate(R.layout.best_house_list_view,parent,false);
        return BestHouseViewHolder(besthouseview);
    }

    override fun onBindViewHolder(
        holder: BestHouseListviewAdapter.BestHouseViewHolder,
        position: Int
    ) {
        holder.best_house_bedroom.text=2.toString()
    }

    override fun getItemCount(): Int {
        return  5;
    }

    class BestHouseViewHolder(besthouseitem:View):RecyclerView.ViewHolder(besthouseitem){
        var best_house_name:TextView=besthouseitem.findViewById(R.id.best_house_name);
        var best_house_image:ImageView=besthouseitem.findViewById(R.id.best_house_image);
        var best_house_price:TextView=besthouseitem.findViewById(R.id.best_house_bill);
        var best_house_bedroom:TextView=besthouseitem.findViewById(R.id.best_house_bedroom);
        var best_house_bathroom:TextView=besthouseitem.findViewById(R.id.best_house_bathroom);
    }
}