package com.example.androiddevchallenge

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.PetDataSource
import com.example.androiddevchallenge.data.PetInfo

class PetHomePageViewModel : ViewModel() {
    private val _petInfos = MutableLiveData<List<PetInfo>>()
    val petInfos: LiveData<List<PetInfo>>
        get() = _petInfos

    init {
        _petInfos.value = PetDataSource.petInfos
    }
}