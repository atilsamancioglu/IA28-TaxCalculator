package com.atilsamancioglu.taxcalculator.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.atilsamancioglu.taxcalculator.repo.TaxCalculationInterface

class TaxViewModelFactory(private val taxCalculation: TaxCalculationInterface) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TaxViewModel(taxCalculation) as T
    }
}