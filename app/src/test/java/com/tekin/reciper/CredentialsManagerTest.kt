package com.tekin.reciper

import org.junit.Assert.*
import org.junit.Test

class CredentialsManagerTest {

    private val credentialsManager = CredentialsManager()

    // Old tests
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

    // New tests
    @Test
    fun testValidRegistration() {
        val result = credentialsManager.register("test@te.st", "1234")
        assertEquals("Registration successful", result)
    }

    @Test
    fun testDuplicateRegistration() {
        credentialsManager.register("test@te.st", "1234")
        val result = credentialsManager.register("TEST@te.st", "5678")
        assertEquals("Error: Email is already taken.", result)
    }

    @Test
    fun testSuccessfulLogin() {
        credentialsManager.register("test@te.st", "1234")
        val result = credentialsManager.login("test@te.st", "1234")
        assertTrue(result)
    }

    @Test
    fun testFailedLogin() {
        credentialsManager.register("test@te.st", "1234")
        val result = credentialsManager.login("wrong@te.st", "1234")
        assertFalse(result)
    }
}
