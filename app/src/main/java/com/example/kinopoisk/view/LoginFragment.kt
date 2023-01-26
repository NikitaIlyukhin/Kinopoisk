package com.example.kinopoisk.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.kinopoisk.MainActivity
import com.example.kinopoisk.R
import com.example.kinopoisk.databinding.LoginFragmentBinding
import com.example.kinopoisk.viewModel.UserViewModel

class LoginFragment : Fragment(R.layout.login_fragment) {
    private lateinit var binding: LoginFragmentBinding
    private val userViewModel by activityViewModels<UserViewModel>()
    private lateinit var phone: String
    private lateinit var password: String
    private var remember: Boolean = false

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LoginFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Changed Text Input
        binding.editTextPhone.addTextChangedListener {
            binding.passwordLayout.error = null
            binding.phoneLayout.error = null
        }
        binding.editTextPassword.addTextChangedListener { binding.passwordLayout.error = null }

        //Registration-->
        binding.registrationBtn.setOnClickListener {
            phone = binding.editTextPhone.text.toString()
            password = binding.editTextPassword.text.toString()
            remember = binding.rememberSw.isChecked

            if (!remember) userViewModel.forgotActiveUser()
            if (phone != "") {
                userViewModel.getUserByPhone(phone).observe(activity as MainActivity, Observer {
                    if (it != null)
                        binding.phoneLayout.error = getString(R.string.error_registration)
                    else {
                        userViewModel.createUser(phone, password, remember)
                    }
                })
            }
        }

        //Login -->
        binding.loginBtn.setOnClickListener {
            phone = binding.editTextPhone.text.toString()
            password = binding.editTextPassword.text.toString()
            remember = binding.rememberSw.isChecked

            if (!remember) userViewModel.forgotActiveUser()
            if (phone == "") {
                binding.phoneLayout.error = getString(R.string.error_login)
            } else {
                userViewModel.getUserByPhone(phone).observe(activity as MainActivity, Observer {
                    if (it != null) {
                        if (it.password != password)
                            binding.passwordLayout.error = getString(R.string.error_password)
                        else {

                            userViewModel.goToNextFragment(this, StartFragment.newInstance())
                        }
                    } else binding.phoneLayout.error = getString(R.string.error_login)
                })
            }
        }

    }
}