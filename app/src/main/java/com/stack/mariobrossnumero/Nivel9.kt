package com.stack.mariobrossnumero

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.stack.mariobrossnumero.databinding.ActivityMainBinding
import com.stack.mariobrossnumero.databinding.ActivityNivel9Binding
import java.util.Random

class Nivel9 : AppCompatActivity() {
    private lateinit var binding : ActivityNivel9Binding


    private var numberRandom = 0
    private var progresso = 0
    private var dicas = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNivel9Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btNext.visibility = View.GONE

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        numberRandom = Random().nextInt(91)
        binding.btReset.setOnClickListener{ view ->
            progresso = 0
            mensagem(view, "Valores resetados!", "#1FB825")
        }

        binding.btNext.setOnClickListener { view ->
            val intent = Intent(this, Nivel10::class.java)
            startActivity(intent)
        }

        binding.btPlay.setOnClickListener { view ->
            val userText = binding.numeroDigitado.text.toString().toInt()

            if (userText == numberRandom){

                mensagem(view,"Meus parabéns, você acertou!", "#1FB825")
                progresso -= 120
                binding.LinearProgress.setProgress(progresso, true)
                binding.btPlay.visibility = View.GONE
                binding.btReset.visibility = View.GONE
                binding.btNext.visibility = View.VISIBLE
            }else{
                userText != numberRandom
                mensagem(view,"Você errou, tente novamente", "#FF0000")
                progresso+= 10
                binding.LinearProgress.setProgress(progresso, true)
                dicas += 1
            }
            if (progresso >100){

                val intent = Intent(this, GameOver::class.java)
                startActivity(intent)
            }
            if (dicas > 1){

                if (userText > numberRandom){

                    mensagem(view,"Dica: O valor está para baixo", "#90D0E313")
                }
                if (userText < numberRandom){

                    mensagem(view,"Dica: O valor está para cima", "#90D0E313")

                }

            }

        }

    }
    private fun mensagem(view: View, mensagem : String, cor : String){

        val snackbar = Snackbar.make(view, mensagem, Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.parseColor(cor))
        snackbar.setTextColor(Color.parseColor("#FFFFFF"))
        snackbar.show()

    }
}