package com.atilsamancioglu.taxcalculator.repo

interface TaxCalculationInterface {
    fun calculateTax(grossIncome: Double, taxRate: Double) : Double
    fun calculateNetIncome(grossIncome: Double, taxRate: Double) : Double
}