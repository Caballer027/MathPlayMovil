package com.caballero.leo.mathplay.ui.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.caballero.leo.mathplay.R
import com.caballero.leo.mathplay.data.database.SharedPreferencesRepository
import com.caballero.leo.mathplay.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var sharedPreferencesRepository: SharedPreferencesRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferencesRepository = SharedPreferencesRepository(requireContext())

        binding.etFullName.setText(sharedPreferencesRepository.getUserFullName())
        binding.etBirthDate.setText(sharedPreferencesRepository.getUserBirthDate())
        binding.etEmail.setText(sharedPreferencesRepository.getUserEmail())
        binding.etPassword.setText(sharedPreferencesRepository.getUserPassword())
        binding.etRole.setText(getString(R.string.student_role))

        binding.btnSaveChanges.setOnClickListener {
            val fullName = binding.etFullName.text.toString().trim()
            val birthDate = binding.etBirthDate.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            sharedPreferencesRepository.saveUserFullName(fullName)
            sharedPreferencesRepository.saveUserBirthDate(birthDate)
            sharedPreferencesRepository.saveUserEmail(email)
            sharedPreferencesRepository.saveUserPassword(password)

            Toast.makeText(context, "Cambios guardados", Toast.LENGTH_SHORT).show()
        }

        binding.btnLogout.setOnClickListener {
            sharedPreferencesRepository.setUserAuthenticated(false)
            Toast.makeText(context, "Sesión cerrada", Toast.LENGTH_SHORT).show()

            val intent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }
    }
}