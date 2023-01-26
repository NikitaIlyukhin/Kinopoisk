package com.example.kinopoisk.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kinopoisk.R
import com.example.kinopoisk.data.model.Test.Film
import com.example.kinopoisk.data.model.entity.User
import com.example.kinopoisk.databinding.FilmListFragmentBinding
import com.example.kinopoisk.view.adapter.FilmListAdapter

class FilmListFragment : Fragment(R.layout.film_list_fragment) {

    //    private val userViewModel by activityViewModels<UserViewModel>()
    private lateinit var binding: FilmListFragmentBinding
    private lateinit var activeUser: User
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FilmListAdapter

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
        adapter = FilmListAdapter()
        recyclerView = binding.filmRecycler
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        //<-List Orders
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var list: List<Film> = listOf(
            Film("Миссия невыполнима", "США"),
            Film("Елки", "Россия"),
            Film("Паразиты", "Корея"),
            Film("Миссия невыполнима", "США"),
            Film("Елки", "Россия"),
            Film("Паразиты", "Корея")
        )
        adapter.setData(list)
    }
}