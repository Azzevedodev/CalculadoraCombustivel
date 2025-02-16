package com.example.calculadoradecombustivel

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val preco = intent.getFloatExtra("PRECO_COMBUSTIVEL", 0.0f)
        val consumo = intent.getFloatExtra("CONSUMO", 0.0f)
        val distancia = intent.getIntExtra("DISTANCIA", 0)
        val total = intent.getFloatExtra("TOTAL", 0.0f)

        val preco2 = findViewById<TextView>(R.id.tv_preco2)
        val consumo2 = findViewById<TextView>(R.id.tv_consumo2)
        val km2 = findViewById<TextView>(R.id.tv_km2)
        val resultfinal = findViewById<TextView>(R.id.tv_resultfinal)

        preco2.text = preco.toString()
        consumo2.text = consumo.toString()
        km2.text = distancia.toString()
        resultfinal.text = total.toString()

        val btnNovoCalculo = findViewById<Button>(R.id.btn_novocalculo)
        btnNovoCalculo.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
}
