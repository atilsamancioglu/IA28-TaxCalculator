package com.atilsamancioglu.taxcalculator.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.atilsamancioglu.taxcalculator.repo.TaxCalculationInterface

class TaxViewModel(private val taxCalculation : TaxCalculationInterface) : ViewModel() {

    var taxRate = MutableLiveData<String>()
    var grossIncome = MutableLiveData<String>()

    private var netTax = MutableLiveData<String>()
    val netTaxValue : LiveData<String>
        get() = netTax

    private var netIncome = MutableLiveData<String>()
    val netIncomeValue : LiveData<String>
        get() = netIncome


    fun calculateTaxAndIncome() {

            val taxRateDouble = (taxRate.value?.toDouble()?.div(100))
            val grossIncomeDouble = grossIncome.value?.toDouble()

            if (taxRateDouble != null && grossIncomeDouble != null) {
                calculateNetTax(taxRateDouble,grossIncomeDouble)
                calculateNetIncome(taxRateDouble,grossIncomeDouble)
            } else {
                netTax.value = null
                netIncome.value = null
            }


    }

    fun calculateNetTax(taxRateDouble : Double, grossIncomeDouble: Double) {
        val netTaxCalculation = taxCalculation.calculateTax(grossIncomeDouble,taxRateDouble)
        netTax.value = netTaxCalculation.toString()
    }

    fun calculateNetIncome(taxRateDouble : Double, grossIncomeDouble: Double) {
        val netIncomeCalculation = taxCalculation.calculateNetIncome(grossIncomeDouble, taxRateDouble)
        netIncome.value = netIncomeCalculation.toString()
    }

}