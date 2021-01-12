package com.atilsamancioglu.taxcalculator.repo

class TaxCalculationRepository: TaxCalculationInterface {
    override fun calculateTax(grossIncome: Double, taxRate: Double): Double {
        return grossIncome * taxRate
    }

    override fun calculateNetIncome(grossIncome: Double, taxRate: Double): Double {
        return grossIncome - (grossIncome * taxRate)
    }

}