package com.example.homprent.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.homprent.R
import com.example.homprent.model.data_class.DetailsPageModel

class Test : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        val house_data: DetailsPageModel = intent.getParcelableExtra("data")!!
        Log.d("TestAppactivity",house_data.toString())
    }
}