package com.example.homprent.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.homprent.R
import com.squareup.picasso.Picasso

class GalleryListViewAdapter(image_data:List<String>):RecyclerView.Adapter<GalleryListViewAdapter.GalleryListViewHolder> (){
    private val imagedata:List<String> = image_data;
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
        Picasso.get().load(imagedata[position]).into(holder.gallery_image)
    }

    override fun getItemCount(): Int {
        return imagedata.size
    }

    class GalleryListViewHolder(galleryView:View):RecyclerView.ViewHolder(galleryView) {
        var gallery_image:ImageView=galleryView.findViewById(R.id.gallery_image)
    }
}

