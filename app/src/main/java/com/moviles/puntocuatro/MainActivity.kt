package com.moviles.puntocuatro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.moviles.puntocuatro.databinding.ActivityMainBinding
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val monedas = resources.getStringArray(R.array.monedas)
        val adapter = ArrayAdapter(this, R.layout.list_item, monedas)
        with(binding.autoCompleteTextView){
            setAdapter(adapter)
        }
        with(binding.autoCompleteTextView2){
            setAdapter(adapter)
        }

        val df = DecimalFormat("#.##")

        binding.button.setOnClickListener {
            if (!validateEmpty()){
                if (binding.autoCompleteTextView.text.toString() == binding.autoCompleteTextView2.text.toString()){
                    binding.ResultextView.text = buildString {
                        append(getString(R.string.mensaje))
                        append(binding.valorConvertirInputText.text.toString())
                    }
                }
                if (binding.autoCompleteTextView.text.toString() == monedas[0] && binding.autoCompleteTextView2.text.toString() == monedas[1]){
                    binding.ResultextView.text = buildString {
                        append(getString(R.string.mensaje))
                        append(df.format(binding.valorConvertirInputText.text.toString().toDouble()*0.93))
                    }
                }
                if (binding.autoCompleteTextView.text.toString() == monedas[0] && binding.autoCompleteTextView2.text.toString() == monedas[2]){
                    binding.ResultextView.text = buildString {
                        append(getString(R.string.mensaje))
                        append(df.format(binding.valorConvertirInputText.text.toString().toDouble()*4811.93))
                    }
                }
                if (binding.autoCompleteTextView.text.toString() == monedas[1] && binding.autoCompleteTextView2.text.toString() == monedas[0]){
                    binding.ResultextView.text = buildString {
                        append(getString(R.string.mensaje))
                        append(df.format(binding.valorConvertirInputText.text.toString().toDouble()*1.08))
                    }
                }
                if (binding.autoCompleteTextView.text.toString() == monedas[1] && binding.autoCompleteTextView2.text.toString() == monedas[2]){
                    binding.ResultextView.text = buildString {
                        append(getString(R.string.mensaje))
                        append(df.format(binding.valorConvertirInputText.text.toString().toDouble()*5181.58))
                    }
                }
                if (binding.autoCompleteTextView.text.toString() == monedas[2] && binding.autoCompleteTextView2.text.toString() == monedas[1]){
                    binding.ResultextView.text = buildString {
                        append(getString(R.string.mensaje))
                        append(df.format(binding.valorConvertirInputText.text.toString().toDouble()*0.00019))
                    }
                }
                if (binding.autoCompleteTextView.text.toString() == monedas[2] && binding.autoCompleteTextView2.text.toString() == monedas[0]){
                    binding.ResultextView.text = buildString {
                        append(getString(R.string.mensaje))
                        append(df.format(binding.valorConvertirInputText.text.toString().toDouble()*0.00021))
                    }
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