package com.example.homprent.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.homprent.R
import com.example.homprent.presentation.adapter.BestHouseListviewAdapter
import com.example.homprent.presentation.adapter.HouseListviewAdapter
import com.example.homprent.presentation.adapter.OptionButtonAdapter

class HomeActivity : AppCompatActivity() {
    lateinit var recyview:RecyclerView
    lateinit var houselistview:RecyclerView;
    lateinit var besthouselistview:RecyclerView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initilization();
    }

    fun initilization(){
        houselistview=findViewById(R.id.house_list_recyclerview);
        besthouselistview=findViewById(R.id.best_house_list_view);
        var option_button:ArrayList<String> = arrayListOf("Home","Apartment","Hotel","Villa","SingleRoom");
        recyview=findViewById(R.id.recyclerview);
        recyview.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyview.adapter=OptionButtonAdapter(option_button)

        houselistview.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        houselistview.adapter=HouseListviewAdapter();

        val myLinearLayoutManager = object : LinearLayoutManager(this) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        besthouselistview.layoutManager=myLinearLayoutManager
        besthouselistview.adapter=BestHouseListviewAdapter();
    }

}