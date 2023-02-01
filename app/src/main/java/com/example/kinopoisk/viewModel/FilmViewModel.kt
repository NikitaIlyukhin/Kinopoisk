package com.example.kinopoisk.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kinopoisk.data.model.rModel.Film
import com.example.kinopoisk.data.model.rModel.FilmModel
import com.example.kinopoisk.data.repository.FilmRepository
import com.example.kinopoisk.data.repository.FilmRepositoryImpl
import kotlinx.coroutines.launch
import retrofit2.Response

class FilmViewModel(private val repository: FilmRepositoryImpl = FilmRepository()):ViewModel() {

    val listFilm: MutableLiveData<Response<FilmModel>> = MutableLiveData()

    fun getFilms(){
        viewModelScope.launch {
            listFilm.value = repository.getAllFilms()
            listFilm.value!!.body().let { res -> println(res) }
        }

    }


}