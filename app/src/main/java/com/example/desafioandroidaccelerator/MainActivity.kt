package com.example.desafioandroidaccelerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.example.desafioandroidaccelerator.data.RetrofitServiceFactory
import com.example.desafioandroidaccelerator.data.model.gifTrending
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service = RetrofitServiceFactory.makeRetrofitService()
        // Obtiene una referencia al TextView
        val txtResultado = findViewById<TextView>(R.id.txtResultado)


        lifecycleScope.launch {
            try {
                val response = service.getTrendingGifs("EKYapOaLQ1HVAp08wcwgGnAyViOx1tD2")
                println(response)
             /*   if (response != null) {
                    val gifsTrendingVariable = response.meta.status
                    // Muestra el estado de meta
                    txtResultado.text = gifsTrendingVariable.toString()
                } else {
                    // La respuesta está vacía, muestra un mensaje de error en el TextView
                    txtResultado.text = "La respuesta está vacía"
                }
                */
            } catch (e: Exception) {
                // Se produjo un error durante la solicitud, muestra un mensaje de error en el TextView
                txtResultado.text = "Error: ${e.message}"
            }
        }
    }
}