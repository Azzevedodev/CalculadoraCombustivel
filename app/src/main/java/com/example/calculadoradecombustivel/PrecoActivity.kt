package com.example.calculadoradecombustivel

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import org.w3c.dom.Text

class PrecoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_preco)



        val btnPreco = findViewById<TextInputEditText>(R.id.edt_preco)
        val btnProximo1 = findViewById<Button>(R.id.btn_proximo1)
        btnProximo1.setOnClickListener {

            val precoStr: String = btnPreco.text.toString()

            if (precoStr.isEmpty()){
                Snackbar.make(btnPreco,
                    "Preencha o campo vazio para continuar",
                    Snackbar.LENGTH_LONG).show()

            } else {
                val preco = precoStr.toFloat()
                val intent = Intent(this, ConsumoActivity::class.java)
                startActivity(intent)
            }
        }

    }
}
