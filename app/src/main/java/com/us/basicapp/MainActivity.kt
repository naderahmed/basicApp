package com.us.basicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.us.basicapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCall.setOnClickListener{
            makeACall("0913434343434")
        }

        binding.btnEmail.setOnClickListener{
            sendEmail("naderwashereagain@gmail.com","hello world","hello world")
        }
    }
}