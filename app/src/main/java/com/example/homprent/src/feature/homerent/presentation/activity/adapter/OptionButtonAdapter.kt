package com.example.homprent.src.feature.homerent.presentation.activity.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.provider.CalendarContract.Colors
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.homprent.R

class OptionButtonAdapter(data:ArrayList<String>):RecyclerView.Adapter<OptionButtonAdapter.ViewHolderOption>() {
    private var temposition=0;
    private var option_btn_list:ArrayList<String> =data;
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OptionButtonAdapter.ViewHolderOption {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.option_button_listview,parent,false);
        return ViewHolderOption(view)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: OptionButtonAdapter.ViewHolderOption, position: Int) {

        holder.button.text=option_btn_list[position].substring(0,1).toUpperCase()+option_btn_list[position].substring(1)
        holder.button.setOnClickListener {
            temposition=position;
            notifyDataSetChanged()
        }
        if(temposition==position){
            holder.button.setBackgroundResource(R.drawable.button_shape)
            holder.button.setTextColor(Color.parseColor("#FFFFFFFF"))

        }else{
            holder.button.setBackgroundResource(R.drawable.button_shape_white)
            holder.button.setTextColor(Color.parseColor("#a4a5a4"))
        }
    }

    override fun getItemCount(): Int {
        return  option_btn_list.size
    }

    class ViewHolderOption(Itemview: View):RecyclerView.ViewHolder(Itemview){
        var button:Button=Itemview.findViewById(R.id.option_button)
    }
}