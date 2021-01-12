package com.atilsamancioglu.taxcalculator.repo

import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

class TaxCalculationRepoTest {

    private lateinit var taxCalculationRepo : TaxCalculationRepository

    @Before
    fun setup() {
        taxCalculationRepo = TaxCalculationRepository()
    }

    @After
    fun teardown() {

    }

    @Test
    fun calculateTaxTest() {
        val result = taxCalculationRepo.calculateTax(100.0,0.1)
        assertThat(result).isEqualTo(10)
    }

    @Test
    fun calculateNetIncomeTest() {
        val result = taxCalculationRepo.calculateNetIncome(100.0,0.1)
        assertThat(result).isEqualTo(90)
    }

}