package com.example.communion_android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.communion_android.databinding.ActivityMainBinding
import com.example.communion_android.fragment.LoginCardFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val loginCard = LoginCardFragment()

        supportFragmentManager
            .beginTransaction()
            .replace(binding.containerLoginCard.id, loginCard)
            .commit()
    }
}