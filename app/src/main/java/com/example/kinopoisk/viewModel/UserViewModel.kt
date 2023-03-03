package com.example.kinopoisk.viewModel

import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import com.example.kinopoisk.R
import com.example.kinopoisk.data.model.entity.User
import com.example.kinopoisk.data.model.rModel.Film
import com.example.kinopoisk.data.model.rModel.FilmExtend
import com.example.kinopoisk.data.model.rModel.FilmModel
import com.example.kinopoisk.data.repository.UserRepositoryImpl
import com.example.kinopoisk.data.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import retrofit2.Response

class UserViewModel(private val repository: UserRepository = UserRepositoryImpl()) : ViewModel() {
    var user: LiveData<User> = MutableLiveData<User>()
    val filmExtend: MutableLiveData<Response<FilmExtend>> = MutableLiveData()
    val film: MutableLiveData<Film> = MutableLiveData()
    val list: MutableLiveData<FilmModel> = MutableLiveData()

    fun createUser(phone: String, password: String, activeFlg: Boolean) {
        repository.createUser(User(phone, password, activeFlg))
    }

    fun getUserByPhone(phone: String): LiveData<User> {
        user = repository.getUserByPhone(phone)
        return user
    }

    fun goToNextFragment(fragment: Fragment, nextFragment: Fragment) {
        fragment.parentFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragment_container_view, nextFragment)
            .commit()
    }

    fun goToNextFragmentWithLoad(fragment: Fragment, nextFragment: Fragment, loadSec: Long = 0) {
        CoroutineScope(Dispatchers.Default).launch {
            delay(loadSec * 1000)
            fragment.parentFragmentManager
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragment_container_view, nextFragment)
                .commit()
        }
    }

    fun forgotActiveUser() {
        repository.forgotActiveUser()
    }

    fun getActiveUser(): LiveData<User> {
        user = repository.getActiveUser()
        return user
    }

    fun getFilms(page:Int=1) {
            viewModelScope.launch {
                try {
                    list.value = repository.getAllFilms(page).body()
                    repository.saveListFilm(list.value!!.films, page)
                }
                catch (e:Exception){
                    list.value = FilmModel(repository.getFilmByBD(page).first(),page)
                }
            }
    }

    fun setFilms(currentFilm: Film) {
        film.value = currentFilm
    }

    fun getFilm(id:Long){
        viewModelScope.launch {
            try {
                filmExtend.value = repository.getFilm(id)
            }
            catch (e:Exception){
                println("getFilm: $e")
            }

        }
    }



}