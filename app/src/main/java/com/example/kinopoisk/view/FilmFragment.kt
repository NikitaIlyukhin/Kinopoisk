package com.example.kinopoisk.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.kinopoisk.R
import com.example.kinopoisk.data.model.rModel.Country
import com.example.kinopoisk.data.model.rModel.Film
import com.example.kinopoisk.data.model.rModel.FilmExtend
import com.example.kinopoisk.data.model.rModel.Genre
import com.example.kinopoisk.databinding.FilmFragmentBinding
import com.example.kinopoisk.viewModel.UserViewModel
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.math.round
import kotlin.collections.List as List

class FilmFragment : Fragment(R.layout.film_fragment) {
    private lateinit var binding: FilmFragmentBinding
    private lateinit var film: Film
    private lateinit var filmExtend: FilmExtend
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
        film = userViewModel.film.value!!

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (film != null) {
            with(binding) {
                Picasso.get().load(film.posterUrl).into(mainPoster)
                filmName.text = film.nameRu
                filmNameEng.text = film.nameEn
                time.text = film.filmLength
                userViewModel.getFilm(film.filmId.toLong())
                userViewModel.filmExtend.observe(viewLifecycleOwner) { resp ->
                    resp.body()?.let {
                        description.text = it.description
                        owner.text = getGenre(it.genres)
                        countrys.text = getCountry(it.countries)
                        setRating(it.ratingKinopoisk)
                    }
                }
            }
        }
    }


    fun getGenre(list: List<Genre>): String {
        var res: String = ""
        list.map { res = "${res}, ${it.genre}" }
        if (res.isNotEmpty())
           res = res.substring(2)
        return res
    }

    fun getCountry(list: List<Country>): String {
        var res: String = ""
        list.map { res = "${res}, ${it.country}" }
        if (res.isNotEmpty())
            res = res.substring(2)
        return res
    }
    fun setRating(rate:Double){
        var rate100 = round((rate*10)).toInt()
        for (i in 0 .. rate100 step 10){
            when (i){
                10 ->binding.star1.setImageResource(R.drawable.ic_baseline_star_half_24)
                20->binding.star1.setImageResource(R.drawable.ic_baseline_star_24)
                30 ->binding.star2.setImageResource(R.drawable.ic_baseline_star_half_24)
                40->binding.star2.setImageResource(R.drawable.ic_baseline_star_24)
                50 ->binding.star3.setImageResource(R.drawable.ic_baseline_star_half_24)
                60->binding.star3.setImageResource(R.drawable.ic_baseline_star_24)
                70 ->binding.star4.setImageResource(R.drawable.ic_baseline_star_half_24)
                80->binding.star4.setImageResource(R.drawable.ic_baseline_star_24)
                90->binding.star5.setImageResource(R.drawable.ic_baseline_star_24)
            }
        }
        when(rate100){
            in 81..91 -> binding.star5.setImageResource(R.drawable.ic_baseline_star_half_24)
        }
    }
}