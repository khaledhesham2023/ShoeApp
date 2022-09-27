package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel() : ViewModel() {

    // setting the shoes list (mutableLiveData to set the values from layout while live data for observation)
    private var _shoesList = MutableLiveData<MutableList<Shoe>>()
    val shoesList: LiveData<MutableList<Shoe>>
        get() = _shoesList

    // this variable takes the inputText from name input text
    val name = MutableLiveData<String>()

    // this variable takes the inputText from company input text
    val company = MutableLiveData<String>()

    // this variable takes the inputText from size input text
    val size = MutableLiveData(0.0)

    // this variable takes the inputText from description input text
    val description = MutableLiveData<String>()

    init {
        _shoesList.value = mutableListOf()
    }

    // this function is used for moving the data to viewModel
    fun saveShoe() {
        val shoe: Shoe =
            Shoe(name.value ?: "", size.value ?: 0.0, company.value ?: "", description.value ?: "")
        val list = _shoesList.value?.also {
            it.add(shoe)
        } ?: mutableListOf(shoe)
        _shoesList.value = list
    }
}

