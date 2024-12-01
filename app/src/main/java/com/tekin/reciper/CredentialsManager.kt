package com.tekin.reciper

class CredentialsManager {
    private val userDatabase = mutableMapOf<String, String>()

    fun isValidEmail(email: String): Boolean {
        if (email.isEmpty()) return false
        val emailRegex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$".toRegex()
        return email.matches(emailRegex)
    }

    fun isValidPassword(password: String): Boolean {
        return password.isNotEmpty()
    }

    fun register(email: String, password: String): String {
        val normalizedEmail = email.lowercase()
        return if (userDatabase.containsKey(normalizedEmail)) {
            "Error: Email is already taken."
        } else {
            userDatabase[normalizedEmail] = password
            "Registration successful"
        }
    }

    fun login(email: String, password: String): Boolean {
        val normalizedEmail = email.lowercase()
        return userDatabase[normalizedEmail] == password
    }
}
