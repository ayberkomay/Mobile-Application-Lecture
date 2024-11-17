package com.tekin.reciper

import org.junit.Assert.*
import org.junit.Test

class CredentialsManagerTest {

    private val credentialsManager = CredentialsManager()

    @Test
    fun testEmptyEmailReturnsFalse() {
        val result = credentialsManager.isValidEmail("")
        assertFalse(result)
    }

    @Test
    fun testInvalidEmailFormatReturnsFalse() {
        val result = credentialsManager.isValidEmail("invalid-email")
        assertFalse(result)
    }

    @Test
    fun testValidEmailReturnsTrue() {
        val result = credentialsManager.isValidEmail("test@example.com")
        assertTrue(result)
    }

    @Test
    fun testEmptyPasswordReturnsFalse() {
        val result = credentialsManager.isValidPassword("")
        assertFalse(result)
    }

    @Test
    fun testNonEmptyPasswordReturnsTrue() {
        val result = credentialsManager.isValidPassword("password123")
        assertTrue(result)
    }
}
