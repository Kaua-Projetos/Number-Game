package com.stack.mariobrossnumero

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.stack.mariobrossnumero.databinding.ActivityPaginaInicialBinding
import pl.droidsonroids.gif.GifDrawable

class PaginaInicial : AppCompatActivity() {
    private lateinit var binding : ActivityPaginaInicialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaginaInicialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        binding.btPlayinicial.setOnClickListener { view ->
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.btSair.setOnClickListener { view ->
            finish()
        }


    }
}