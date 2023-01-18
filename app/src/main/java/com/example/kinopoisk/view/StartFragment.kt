package com.example.kinopoisk.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.kinopoisk.R
import com.example.kinopoisk.viewModel.UserViewModel

class StartFragment:Fragment(R.layout.start_fragment) {
    private val userViewModel by activityViewModels<UserViewModel>()

    companion object{
        @JvmStatic
        fun newInstance() = StartFragment()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userViewModel.goToNextFragmentWithLoad(this,LoginFragment.newInstance(),3)
    }
}