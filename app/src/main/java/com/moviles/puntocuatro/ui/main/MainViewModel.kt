package com.moviles.puntocuatro.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.DecimalFormat

class MainViewModel : ViewModel() {

    private val df = DecimalFormat("#.##")

    val conversion : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun equalToEqual(value: String) {
        conversion.value = value
    }

    fun convert(value: String, type: Int) {
        when(type) {
            0 -> conversion.value = df.format(value.toDouble()*0.98)
            1 -> conversion.value = df.format(value.toDouble()*4811.93)
            2 -> conversion.value = df.format(value.toDouble()*1.08)
            3 -> conversion.value = df.format(value.toDouble()*5181.58)
            4 -> conversion.value = df.format(value.toDouble()*0.00019)
            5 -> conversion.value = df.format(value.toDouble()*0.00021)
        }

    }


}