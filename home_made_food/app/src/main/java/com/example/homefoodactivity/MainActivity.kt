package com.example.homefoodactivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.homefoodactivity.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as FoodApplication).getAppComponent()?.inject(this)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        ObserveEvents()
    }

    private fun ObserveEvents() {
        // observe the view model events and handle the toast displaying and logoout here
    }

}