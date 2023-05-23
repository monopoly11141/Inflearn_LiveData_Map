package com.example.inflearn_livedata_map

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.inflearn_livedata_map.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val viewModel : MainViewModel by viewModels()

        binding.btnCalculate.setOnClickListener {
            val inputValue = binding.etInput.text.toString().toInt()
            viewModel.setInputNumber(inputValue)
        }

        viewModel.inputNumberAdd.observe(this, Observer {value ->
            binding.tvAddOutput.text = value.toString()
        })

        viewModel.inputNumberMultiply.observe(this, Observer {value ->
            binding.tvMultiplyOutput.text = value.toString()
        })
    }
}