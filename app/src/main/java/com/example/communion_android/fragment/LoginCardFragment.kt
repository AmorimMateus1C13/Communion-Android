package com.example.communion_android.fragment

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.communion_android.R
import com.example.communion_android.databinding.FragmentLoginCardBinding
import com.example.communion_android.protocols.LoginFragmentInterface

class LoginCardFragment: Fragment() {
    private  lateinit var binding: FragmentLoginCardBinding
    private lateinit var loginFragmentInterface: LoginFragmentInterface

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginFragmentInterface = requireActivity() as LoginFragmentInterface
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadSharedPreferences()
        whenRememberMeChangeValue()
        whenForgottenButtonPressed()
        whenCreateButtonPressed()
        whenNextButtonPressed()
        binding.loginAlert.isVisible = false
    }

    private fun loadSharedPreferences() {
        val sharedPref = requireActivity().getSharedPreferences(
            getString(R.string.preference_file_key), Context.MODE_PRIVATE)
        binding.rememberBtn.isChecked =  sharedPref.getBoolean(getString(R.string.checkBoxPreference), false)
    }
    private fun whenRememberMeChangeValue() {
        binding.rememberBtn.setOnCheckedChangeListener{ _, isChecked ->
            loginFragmentInterface.rememberButtonPressed(isChecked)
        }
    }

    private fun whenForgottenButtonPressed() {
        binding.forgottenBtn.setOnClickListener {
            loginFragmentInterface.forgottenButtonPressed()
        }
    }

    private fun whenCreateButtonPressed() {
        binding.createBtn.setOnClickListener {
            loginFragmentInterface.createButtonPressed()
        }
    }

    private fun whenNextButtonPressed() {
        binding.nextBtn.setOnClickListener {
           validateTextFields()

        }
    }

    private fun validateTextFields(){
        if (binding.loginInput.text.isNotEmpty() &&
            binding.passwordInput.text.isNotEmpty()) {
            validateRememberMeButton()
        } else {
            binding.loginInput.setBackgroundResource(R.drawable.alert_field)
            binding.passwordInput.setBackgroundResource(R.drawable.alert_field)
            binding.loginAlert.isVisible = true
            binding.loginAlert.text = getString(R.string.alertEmptyFields)
        }
    }

    private fun validateRememberMeButton() {
        if(binding.rememberBtn.isChecked) {
            loginFragmentInterface.saveLogin(binding.loginInput.text.toString(), binding.passwordInput.text.toString())
        }
        loginFragmentInterface.nextButtonPressed()
    }


    }


