package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myapplication.Constant.KEI_ONE
import com.example.myapplication.Constant.KEI_TWO
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var register: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()
    }

    private fun initListeners() {
        binding.apply {
            btnNext.setOnClickListener() {
                if (editText.text.toString().isEmpty()) {
                    showToast("Empty")
                } else {
                    Intent(this@MainActivity, SecondActivity::class.java).apply {
                        putExtra(KEI_ONE, editText.text.toString())
                        register.launch(this)
                    }
                }
            }
            register = registerForActivityResult(
                ActivityResultContracts.StartActivityForResult()
            ) { result ->
                editText.setText(result.data?.getStringExtra(KEI_TWO))

            }
        }
    }
}
