package com.example.homprent.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.homprent.R

class GalleryListViewAdapter():RecyclerView.Adapter<GalleryListViewAdapter.GalleryListViewHolder> (){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GalleryListViewAdapter.GalleryListViewHolder {
        val view:View=LayoutInflater.from(parent.context).inflate(R.layout.gallery_list_view,parent,false)
        return GalleryListViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: GalleryListViewAdapter.GalleryListViewHolder,
        position: Int
    ) {
        holder.gallery_image.setImageResource(R.drawable.house4)
    }

    override fun getItemCount(): Int {
        return 5
    }

    class GalleryListViewHolder(galleryView:View):RecyclerView.ViewHolder(galleryView) {
        var gallery_image:ImageView=galleryView.findViewById(R.id.gallery_image)
    }
}

