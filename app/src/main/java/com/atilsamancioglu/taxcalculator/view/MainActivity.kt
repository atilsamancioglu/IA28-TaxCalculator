package com.atilsamancioglu.taxcalculator.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.atilsamancioglu.taxcalculator.R
import com.atilsamancioglu.taxcalculator.repo.TaxCalculationRepository
import com.atilsamancioglu.taxcalculator.viewmodel.TaxViewModel
import com.atilsamancioglu.taxcalculator.viewmodel.TaxViewModelFactory
import com.atilsamancioglu.taxcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : TaxViewModel
    private lateinit var provider : TaxViewModelFactory
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        provider = TaxViewModelFactory(TaxCalculationRepository())
        viewModel = ViewModelProvider(this,provider).get(TaxViewModel::class.java)
        binding.layoutViewModel = viewModel
        binding.lifecycleOwner = this
    }
}