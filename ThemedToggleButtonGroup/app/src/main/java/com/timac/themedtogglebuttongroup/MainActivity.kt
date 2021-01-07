package com.timac.themedtogglebuttongroup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.timac.themedtogglebuttongroup.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.singleSelection.setOnSelectListener {
            when(it){
                binding.btn1 -> Toast.makeText(this, "5:30PM", Toast.LENGTH_SHORT).show()
                binding.btn2 -> Toast.makeText(this, "7:30PM", Toast.LENGTH_SHORT).show()
                binding.btn3 -> Toast.makeText(this, "8:00PM", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnSubmit.setOnClickListener {
            val selectedButtons = binding.multipleSelection.selectedButtons
            val btnNames = mutableListOf<String>()
            for (i in selectedButtons){
                btnNames.add(i.text)
            }
            Toast.makeText(this, btnNames.toString(), Toast.LENGTH_LONG).show()
        }

    }
}