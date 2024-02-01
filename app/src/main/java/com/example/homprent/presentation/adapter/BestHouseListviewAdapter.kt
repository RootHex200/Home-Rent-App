package com.example.homprent.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homprent.R
import com.example.homprent.model.data_class.BestPlace
import com.example.homprent.model.data_class.NearPlace
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class BestHouseListviewAdapter(best_house:List<BestPlace>):RecyclerView.Adapter<BestHouseListviewAdapter.BestHouseViewHolder>() {
    private val besthouse:List<BestPlace> = best_house;
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
        holder.best_house_name.text=besthouse[position].hotel_name;
        holder.best_house_price.text=besthouse[position].bill;
        holder.best_house_bedroom.text=besthouse[position].bedroom;
        holder.best_house_bathroom.text=besthouse[position].bathroom;
        Picasso.get().load(besthouse[position].hotel_thum_image).into(holder.best_house_image);

    }

    override fun getItemCount(): Int {
        return  besthouse.size;
    }

    class BestHouseViewHolder(besthouseitem:View):RecyclerView.ViewHolder(besthouseitem){
        var best_house_name:TextView=besthouseitem.findViewById(R.id.best_house_name);
        var best_house_image:ImageView=besthouseitem.findViewById(R.id.best_house_image);
        var best_house_price:TextView=besthouseitem.findViewById(R.id.best_house_bill);
        var best_house_bedroom:TextView=besthouseitem.findViewById(R.id.best_house_bedroom);
        var best_house_bathroom:TextView=besthouseitem.findViewById(R.id.best_house_bathroom);
    }
}