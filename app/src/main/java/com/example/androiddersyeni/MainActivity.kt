package com.example.androiddersyeni

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.androiddersyeni.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonCalculate.setOnClickListener {
            calculatePrice()
        }

    }

    fun calculatePrice(){
        val price=binding.editTextCount.text.toString()
        var faiz=0.0

        if (price.isNotEmpty()){

            val secilenRadioButton=binding.radioGroup.checkedRadioButtonId

            when(secilenRadioButton){
                R.id.radioButton20 ->faiz=0.2
                R.id.radioButton15->faiz=0.15
                R.id.radioButton18->faiz=0.18
            }

            var bexsis=price.toDouble()*faiz

            val switchDurum=binding.switch1.isChecked

            if (switchDurum){
                bexsis=kotlin.math.ceil(bexsis)
            }

            binding.textViewPrice.text=bexsis.toString()

        }else{
            Toast.makeText(applicationContext,"Hesab boş ola bilnez",Toast.LENGTH_LONG).show()
        }

    }
}