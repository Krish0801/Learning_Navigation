package com.example.learningnavigation.ui.login

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.learningnavigation.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {


    // This property is only valid between onCreateView and
    // onDestroyView.
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.btnSubmit.setOnClickListener {
            if (!isValidEmail(binding.userid.text)) {
                binding.userid.error = "Invalid Email Address"
            } else if (binding.password.text!!.isEmpty()) {
                binding.password.error = "Please Enter Password"
            }
        }
        binding.btnReset.setOnClickListener {
            binding.userid.text?.clear()
            binding.password.text?.clear()
        }
        return binding.root
    }

    private fun isValidEmail(target: CharSequence?): Boolean {
        return if (TextUtils.isEmpty(target)) {
            false
        } else {
            Patterns.EMAIL_ADDRESS.matcher(target).matches()
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
    }

}