package com.example.kinopoisk.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.kinopoisk.R
import com.example.kinopoisk.databinding.FilmFragmentBinding
import com.example.kinopoisk.viewModel.UserViewModel

class FilmFragment:Fragment(R.layout.film_fragment) {
    private lateinit var binding: FilmFragmentBinding
    private val userViewModel by activityViewModels<UserViewModel>()
    companion object {
        @JvmStatic
        fun newInstance() = FilmFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FilmFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.filmName.text = userViewModel.film.value?.nameRu
    }
}