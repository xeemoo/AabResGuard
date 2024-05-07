package com.bytedance.android.app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bytedance.android.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvLan.text = getString(R.string.lan)
    }

}