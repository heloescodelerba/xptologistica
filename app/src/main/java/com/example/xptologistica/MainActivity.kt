package com.example.xptologistica

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btCalcular = findViewById<Button>(R.id.btnCalcular)
        btCalcular.setOnClickListener {
            val valkm = findViewById<EditText>(R.id.edtkm)
            val valsalario = findViewById<EditText>(R.id.edtsal)
            val txttitulo = findViewById<TextView>(R.id.txttitulo)

            val nkm = valkm?.text.toString().toDouble()
            val nsal = valsalario?.text.toString().toDouble()

            var valortotal: Double = 0.0
            var classe: String = ""

            if (nkm <= 500) {
                valortotal = nsal+(nsal * 0.001 * nkm)
            } else if (nkm <= 1000) {
                valortotal = nsal+(nsal * 0.015 * nkm)
            } else if (nkm <= 2000) {
                valortotal = nsal+(nsal * 0.025 * nkm)
            } else if (nkm > 2000) {
                valortotal = nsal+(nsal * 0.03 * nkm)
            }

            Toast.makeText(this, "Total=$valortotal", Toast.LENGTH_SHORT).show()
            txttitulo.setText(valortotal.toString())
        }
    }
    }