package com.example.communion_android

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.communion_android.databinding.ActivityMainBinding
import com.example.communion_android.fragment.LoginCardFragment
import com.example.communion_android.protocols.LoginFragmentInterface

class MainActivity :
    AppCompatActivity(),
    LoginFragmentInterface {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPref: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initSharedPreference()
        val loginCard = LoginCardFragment()

        supportFragmentManager
            .beginTransaction()
            .replace(binding.containerLoginCard.id, loginCard)
            .commit()
    }

    private fun initSharedPreference() {
        sharedPref = this.getSharedPreferences(
            getString(R.string.preference_file_key), Context.MODE_PRIVATE)
    }

    override fun rememberButtonPressed(isCheck: Boolean) {
        var edit = sharedPref.edit()
        edit.putBoolean(getString(R.string.checkBoxPreference), isCheck)
        edit.apply()
    }

    override fun saveLogin(userLogin: String, userPassword: String) {
        var edit = sharedPref.edit()
        edit.putString(getString(R.string.userLogin), userLogin)
        edit.putString(getString(R.string.userPassword), userLogin)
        edit.commit()
    }

    override fun forgottenButtonPressed() {
        Toast.makeText(this, "forgotten Works", Toast.LENGTH_SHORT).show()
    }

    override fun createButtonPressed() {
        Toast.makeText(this, "create Works", Toast.LENGTH_SHORT).show()
    }

    override fun nextButtonPressed() {
        Toast.makeText(this, "next Works", Toast.LENGTH_SHORT).show()
    }
}