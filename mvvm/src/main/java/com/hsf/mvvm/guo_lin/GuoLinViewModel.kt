package com.hsf.mvvm.guo_lin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GuoLinViewModel(countReserved: Int) : ViewModel() {
    var counter = MutableLiveData<Int>()

    init {
        counter.value = countReserved
    }

    fun plusOne() {
        val count = counter.value ?: 0
        counter.value = count + 1
    }
}