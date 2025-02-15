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

        val btnDistancia = findViewById<TextInputEditText>(R.id.edt_distancia)
        val btnProximo3 = findViewById<Button>(R.id.btn_proximo3)
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
                val intent = Intent(this, ResultActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
