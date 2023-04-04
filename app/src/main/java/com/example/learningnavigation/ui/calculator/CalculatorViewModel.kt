package com.example.learningnavigation.ui.calculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    // Observer Pattern -> Which let's you know the recent/updated value as it changes
    private val _text = MutableLiveData<String>().apply {
        value = ""
    }
    val text: LiveData<String> = _text


    var firstValue: Double = 0.0
    var secondValue: Double = 0.0
    var currentAction:  String = ""


    fun sum() = firstValue + secondValue
    fun sub() = firstValue.minus(secondValue)
    fun div() = firstValue / secondValue
    fun mul() = firstValue * secondValue

}