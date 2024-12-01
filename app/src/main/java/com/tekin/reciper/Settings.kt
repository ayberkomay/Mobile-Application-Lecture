package com.tekin.reciper

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.tekin.reciper.CredentialsManagerTest
import com.google.android.material.textfield.TextInputLayout
import com.tekin.reciper.databinding.FragmentSettingsBinding

class Settings : Fragment(R.layout.fragment_settings) {

    private lateinit var binding: FragmentSettingsBinding
    private val credentialsManager = CredentialsManager()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSettingsBinding.bind(view)

        credentialsManager.register("test@te.st", "1234")

        binding.buttonSignin.setOnClickListener {
            val email = binding.textMail.text.toString().trim()
            val password = binding.textPassword.text.toString().trim()

            val emailLayout = binding.textMailLayout
            val passwordLayout = binding.textPasswordLayout

            when {
                !credentialsManager.isValidEmail(email) -> {
                    emailLayout.error = "Invalid email format."
                }
                !credentialsManager.isValidPassword(password) -> {
                    passwordLayout.error = "Password cannot be empty."
                }
                credentialsManager.login(email, password) -> {
                    startActivity(Intent(requireContext(), MainActivity::class.java))
                }
                else -> {
                    emailLayout.error = "Invalid credentials."
                }
            }
        }

        binding.buttonRegisterSender.setOnClickListener {
            binding.layoutRegister.visibility = View.VISIBLE
            binding.layoutSignedOut.visibility = View.GONE
        }

        binding.buttonRegister.setOnClickListener {
            val email = binding.textRegisterMail.text.toString().trim()
            val password = binding.textRegisterPassword.text.toString().trim()

            val message = credentialsManager.register(email, password)
            if (message == "Registration successful") {
                binding.layoutRegister.visibility = View.GONE
                binding.layoutSignedOut.visibility = View.VISIBLE
            } else {
                binding.textRegisterMailLayout.error = message
            }
        }
    }
}
