package com.example.yo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.yo.databinding.ActivityGuessBinding
import kotlin.random.Random

private lateinit var binding: ActivityGuessBinding

class GuessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val randnum = Random.nextInt(1, intent.getIntExtra("maxNum",0))
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guess)
        binding = ActivityGuessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.menuBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.checkBtn.setOnClickListener {
            val num = binding.guessAnsw.text.toString().toInt()
            if(num>randnum) {
                binding.hint.setText("Liczba mniejsza od wypisanej")
            }
            if(num<randnum){
                binding.hint.setText("Liczba wieksza od wypisanej")
            }
            if(num==randnum){
                binding.hint.setText("Udało się")

            }
        }
    }

}