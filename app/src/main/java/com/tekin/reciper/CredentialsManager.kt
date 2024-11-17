package com.tekin.reciper

class CredentialsManager {

    fun isValidEmail(email: String): Boolean {
        if (email.isEmpty()) return false
        val emailRegex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$".toRegex()
        return email.matches(emailRegex)
    }

    fun isValidPassword(password: String): Boolean {
        return password.isNotEmpty()
    }
}
