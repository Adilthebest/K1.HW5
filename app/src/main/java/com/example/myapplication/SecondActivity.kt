package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.Constant.KEI_ONE
import com.example.myapplication.Constant.KEI_TWO
import com.example.myapplication.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {


    private lateinit var binding:ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textResult.setText(intent.getStringExtra(KEI_ONE))

        binding.btnTwo.setOnClickListener {
            setResult(
                RESULT_OK, Intent().putExtra(KEI_TWO, binding.textResult.text.toString())
            )
            finish()


        }
    }
}
