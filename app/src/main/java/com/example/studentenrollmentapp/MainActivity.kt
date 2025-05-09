package com.example.studentenrollmentapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a los elementos del layout
        val etCodigo = findViewById<EditText>(R.id.etCodigo)
        val etNombres = findViewById<EditText>(R.id.etNombres)
        val etCorreo = findViewById<EditText>(R.id.etCorreo)
        val etDireccion = findViewById<EditText>(R.id.etDireccion)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)

        // Lógica del botón
        btnGuardar.setOnClickListener {
            val codigo = etCodigo.text.toString().trim()
            val nombres = etNombres.text.toString().trim()
            val correo = etCorreo.text.toString().trim()
            val direccion = etDireccion.text.toString().trim()

            // Validar que no esté vacío
            if (codigo.isEmpty() || nombres.isEmpty() || correo.isEmpty() || direccion.isEmpty()) {
                Toast.makeText(this, "Por favor, complete todos los campos.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Mostrar mensaje con los datos
            val mensaje = """
                Matrícula Registrada:
                Código: $codigo
                Nombres: $nombres
                Correo: $correo
                Dirección: $direccion
            """.trimIndent()

            // Mostrar AlertDialog
            val builder = androidx.appcompat.app.AlertDialog.Builder(this)
            builder.setTitle("Datos Registrados")
            builder.setMessage(mensaje)
            builder.setPositiveButton("Aceptar") { dialog, _ ->
                dialog.dismiss()  // Cierra la ventana
            }
            builder.show()
        }
    }
}