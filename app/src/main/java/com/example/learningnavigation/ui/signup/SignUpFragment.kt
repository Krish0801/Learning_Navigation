package com.example.learningnavigation.ui.signup

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.learningnavigation.R
import com.example.learningnavigation.databinding.FragmentLoginBinding
import com.example.learningnavigation.databinding.FragmentSignupBinding

class SignUpFragment : Fragment() {

    private lateinit var binding : FragmentSignupBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_signup, container, false)
        binding = FragmentSignupBinding.inflate(inflater, container, false)
        binding.signupbtn.setOnClickListener {
            if (binding.username.text.isEmpty()) {
                binding.username.error="Please Enter Username"
            }
            if(!isValidEmail(binding.email.text)){
                binding.email.error="Please Enter Email-ID"
            }
            if (!isValidPassword(binding.password.text.toString())){
                binding.password.error="Password characters should have min of '8' characters and 1 Number and 1 Capital letter and 1 Special character"
            }
            if (!isValidPassword(binding.repassword.text.toString())){
                binding.repassword.error="Password characters should have min of '8' characters and 1 Number and 1 Capital letter and 1 Special character"
            }
            if (binding.password.text != binding.repassword.text){
                binding.repassword.error="Password not Match"
            }
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

    private fun isValidPassword(password: String): Boolean {
        if (password.length < 8) return false
        if (password.filter { it.isDigit() }.firstOrNull() == null) return false
        if (password.filter { it.isLetter() }.filter { it.isUpperCase() }.firstOrNull() == null) return false
        if (password.filter { it.isLetter() }.filter { it.isLowerCase() }.firstOrNull() == null) return false
        if (password.filter { !it.isLetterOrDigit() }.firstOrNull() == null) return false

        return true
    }

}