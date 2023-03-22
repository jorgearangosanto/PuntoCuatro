package com.moviles.puntocuatro.ui.main

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.moviles.puntocuatro.R
import com.moviles.puntocuatro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        val view = binding.root
        setContentView(view)

        val observer = Observer<String> {
            binding.ResultextView.text = buildString {
                append(getString(R.string.mensaje))
                append(it)
            }
        }

        mainViewModel.conversion.observe(this, observer)

        val monedas = resources.getStringArray(R.array.monedas)
        val adapter = ArrayAdapter(this, R.layout.list_item, monedas)
        with(binding.autoCompleteTextView){
            setAdapter(adapter)
        }
        with(binding.autoCompleteTextView2){
            setAdapter(adapter)
        }

        binding.button.setOnClickListener {
            if (!validateEmpty()){
                if (binding.autoCompleteTextView.text.toString() == binding.autoCompleteTextView2.text.toString()){
                    mainViewModel.equalToEqual(binding.valorConvertirInputText.text.toString())
                }
                if (binding.autoCompleteTextView.text.toString() == monedas[0] && binding.autoCompleteTextView2.text.toString() == monedas[1]){
                    mainViewModel.convert(binding.valorConvertirInputText.text.toString(),0)
                }
                if (binding.autoCompleteTextView.text.toString() == monedas[0] && binding.autoCompleteTextView2.text.toString() == monedas[2]){
                    mainViewModel.convert(binding.valorConvertirInputText.text.toString(),1)
                }
                if (binding.autoCompleteTextView.text.toString() == monedas[1] && binding.autoCompleteTextView2.text.toString() == monedas[0]){
                    mainViewModel.convert(binding.valorConvertirInputText.text.toString(),2)
                }
                if (binding.autoCompleteTextView.text.toString() == monedas[1] && binding.autoCompleteTextView2.text.toString() == monedas[2]){
                    mainViewModel.convert(binding.valorConvertirInputText.text.toString(),3)
                }
                if (binding.autoCompleteTextView.text.toString() == monedas[2] && binding.autoCompleteTextView2.text.toString() == monedas[1]){
                    mainViewModel.convert(binding.valorConvertirInputText.text.toString(),4)
                }
                if (binding.autoCompleteTextView.text.toString() == monedas[2] && binding.autoCompleteTextView2.text.toString() == monedas[0]){
                    mainViewModel.convert(binding.valorConvertirInputText.text.toString(),5)
                }
            } else {
                Toast.makeText(this, getString(R.string.emptyfield), Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun validateEmpty() =
        binding.autoCompleteTextView.text.toString()
            .isEmpty() || binding.autoCompleteTextView2.text.toString()
            .isEmpty() || binding.valorConvertirInputText.text.toString().isEmpty()
}