package com.example.calculadoradecombustivel

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class DistanciaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_distancia)

        val preco = intent.getFloatExtra("PRECO_COMBUSTIVEL", 0.0f)
        val consumo = intent.getFloatExtra("CONSUMO",0.0f)

        val btnDistancia = findViewById<TextInputEditText>(R.id.edt_distancia)
        val btnProximo3 = findViewById<Button>(R.id.btn_calcular)
        btnProximo3.setOnClickListener {

            val distanciaStr: String = btnDistancia.text.toString()
            if (distanciaStr.isEmpty()) {
                Snackbar.make(
                    btnDistancia,
                    "Preencha o campo vazio para continuar",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {
                val distancia = distanciaStr.toFloat()

                val resultadofinal = (distancia/consumo)*preco

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("PRECO_COMBUSTIVEL", preco)
                intent.putExtra("CONSUMO", consumo)
                intent.putExtra("DISTANCIA", distancia)
                intent.putExtra("TOTAL", resultadofinal)
                startActivity(intent)
            }
        }
    }
}
