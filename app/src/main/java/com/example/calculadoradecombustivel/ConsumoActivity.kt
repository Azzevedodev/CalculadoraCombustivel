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

class ConsumoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_consumo)


        val preco = intent.getFloatExtra("PRECO_COMBUSTIVEL", 0.0f)

        val btnConsumo = findViewById<TextInputEditText>(R.id.edt_consumo)
        val btnProximo2 = findViewById<Button>(R.id.btn_proximo2)
        btnProximo2.setOnClickListener {

            val consumoStr: String = btnConsumo.text.toString()
            if (consumoStr.isEmpty()) {
                Snackbar.make(
                    btnConsumo,
                    "Preencha o campo vazio para continuar",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {

                val Consumo = consumoStr.toFloat()
                val intent = Intent(this, DistanciaActivity::class.java)
                intent.putExtra("PRECO_COMBUSTIVEL", preco)
                intent.putExtra("CONSUMO", Consumo)
                startActivity(intent)
            }


        }

    }
}

