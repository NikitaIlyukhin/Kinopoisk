package com.example.kinopoisk.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.kinopoisk.MainActivity
import com.example.kinopoisk.R
import com.example.kinopoisk.viewModel.UserViewModel

class StartFragment : Fragment(R.layout.start_fragment) {
    private val userViewModel by activityViewModels<UserViewModel>()

    companion object {
        @JvmStatic
        fun newInstance() = StartFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userViewModel.getActiveUser().observe(activity as MainActivity, Observer {
            if (it != null){
                userViewModel.goToNextFragmentWithLoad(this, FilmListFragment.newInstance(), 3)
            }
            else {
                userViewModel.goToNextFragmentWithLoad(this, LoginFragment.newInstance(), 3)
            }
        })
    }
}