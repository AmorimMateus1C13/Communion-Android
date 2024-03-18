package com.example.communion_android.protocols

interface LoginFragmentInterface {
    fun rememberButtonPressed(isCheck: Boolean)
    fun saveLogin(userLogin: String, userPassword: String)

    fun forgottenButtonPressed()

    fun createButtonPressed()

    fun nextButtonPressed()

}