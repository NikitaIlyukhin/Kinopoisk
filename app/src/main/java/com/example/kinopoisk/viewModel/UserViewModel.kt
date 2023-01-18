package com.example.kinopoisk.viewModel

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.kinopoisk.R
import com.example.kinopoisk.data.model.entity.User
import com.example.kinopoisk.data.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class UserViewModel():ViewModel() {

    fun createUser(phone:String,password:String,activeFlg:Boolean) {
        UserRepository.createUser(User(phone,password,activeFlg))
    }

    fun getUserByPhone(phone:String): LiveData<User> {
        return UserRepository.getUserByPhone(phone)
    }

    fun goToNextFragment(fragment: Fragment, nextFragment: Fragment) {
        fragment.parentFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragment_container_view,nextFragment)
            .commit()
    }

    fun goToNextFragmentWithLoad(fragment: Fragment, nextFragment: Fragment, loadSec:Long=0) {
        CoroutineScope(Dispatchers.Default).launch {
            delay(loadSec*1000)
            fragment.parentFragmentManager
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragment_container_view,nextFragment)
                .commit()
        }
    }

    fun forgotActiveUser(){
        UserRepository.forgotActiveUser()
    }




}