package com.example.kinopoisk.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kinopoisk.R
import com.example.kinopoisk.data.model.Test.Film
import com.example.kinopoisk.data.model.entity.User
import com.example.kinopoisk.databinding.FilmListFragmentBinding
import com.example.kinopoisk.view.adapter.FilmAdapter


class FilmListFragment : Fragment(R.layout.film_list_fragment) {

    //    private val userViewModel by activityViewModels<UserViewModel>()
    private lateinit var binding: FilmListFragmentBinding
    private lateinit var activeUser: User
    private lateinit var adapter: FilmAdapter

    companion object {
        @JvmStatic
        fun newInstance() = FilmListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FilmListFragmentBinding.inflate(inflater)
        //List Orders->
        adapter = FilmAdapter()
        with(binding){
            filmRecycler.layoutManager = GridLayoutManager(requireContext(),2)
            filmRecycler.adapter = adapter
        }
        //<-List Orders
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var list: List<Film> = listOf(
            Film("Миссия невыполнима", "США"),
            Film("Елки", "Россия"),
            Film("Паразиты", "Корея"),
            Film("Миссия невыполним", "США"),
            Film("Елк", "Россия"),
            Film("Паразит", "Корея")
        )
        adapter.submitList(list)
    }
}