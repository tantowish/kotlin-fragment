package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragments.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding:ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val username = intent.getStringExtra("usn")
        with(binding){
            tvUsername.text = username
        }
    }
}