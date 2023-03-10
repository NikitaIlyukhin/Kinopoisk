package com.example.kinopoisk.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kinopoisk.R
import com.example.kinopoisk.data.model.rModel.Film
import com.example.kinopoisk.data.model.entity.User
import com.example.kinopoisk.data.model.restModel.FilmModel
import com.example.kinopoisk.databinding.FilmListFragmentBinding
import com.example.kinopoisk.view.adapter.FilmAdapter
import com.example.kinopoisk.viewModel.UserViewModel
import retrofit2.Response


class FilmListFragment : Fragment(R.layout.film_list_fragment) {

    private val userViewModel by activityViewModels<UserViewModel>()
    private lateinit var binding: FilmListFragmentBinding
    private lateinit var activeUser: User
    private lateinit var adapter: FilmAdapter
    private var page: Int = 1
//    private val filmViewModel by  activityViewModels<FilmViewModel>()

    companion object {
        @JvmStatic
        fun newInstance() = FilmListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FilmListFragmentBinding.inflate(inflater)
        //List Orders->
        adapter = FilmAdapter { item -> doClick(item) }
        with(binding) {
            filmRecycler.layoutManager = GridLayoutManager(requireContext(), 2)
            filmRecycler.adapter = adapter
        }
        //<-List Orders
        return binding.root
    }

    fun doClick(film: Film) {
        userViewModel.setFilms(film)
//        userViewModel.getFilm(film.filmId)
        userViewModel.goToNextFragment(this, FilmFragment.newInstance())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setFilms(page)
        binding.page.text = page.toString()


        binding.backBtn.isVisible = page != 1
        binding.nextBtn.isVisible = page < 5
        binding.page.addTextChangedListener {
            binding.backBtn.isVisible = page != 1
            binding.nextBtn.isVisible = page < 5
        }

        binding.backBtn.setOnClickListener {
            println("??????????")
            page--
            binding.page.text = page.toString()
            setFilms(page)
        }
        binding.nextBtn.setOnClickListener {
            println("????????????")
            page++
            binding.page.text = page.toString()
            setFilms(page)
        }
    }

    fun setFilms(page: Int) {
        userViewModel.getFilms(page)
        userViewModel.list.observe(viewLifecycleOwner) {
            adapter.submitList(it.films)
        }
    }


}