package com.example.communion_android.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.communion_android.databinding.FragmentLoginCardBinding

class LoginCardFragment: Fragment() {
    private  lateinit var binding: FragmentLoginCardBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginCardBinding.inflate(inflater, container, false)
        return binding.root



    }

}