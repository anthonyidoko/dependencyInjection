package com.example.week9bclasswork.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.week9bclasswork.data.UserDataClass
import com.example.week9bclasswork.repository.RetroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(private val repository: RetroRepository):ViewModel() {
    private val _liveDataList = MutableLiveData<UserDataClass>()
    val liveData :LiveData<UserDataClass> = _liveDataList

    fun loadUsers(){
        repository.makeApiCall(_liveDataList)
    }

}