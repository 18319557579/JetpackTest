package com.hsf.mvvm.guo_lin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class GuoLinViewModelFactory(private val countReserved: Int) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GuoLinViewModel(countReserved) as T
    }
}