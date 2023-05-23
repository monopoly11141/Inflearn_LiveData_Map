package com.example.inflearn_livedata_map

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map

class MainViewModel : ViewModel() {

    private var _inputNumber = MutableLiveData(0)
    val inputNumber : LiveData<Int>
        get() = _inputNumber

    fun setInputNumber(number : Int) {
        _inputNumber.value = number
    }

    val inputNumberAdd = inputNumber.map{input -> input + input}
    val inputNumberMultiply = inputNumber.map{input -> input * input}
}