package com.example.tarea2sag;


import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Clase que representa la actividad para mostrar los detalles de un personaje.
 *
 * Esta actividad recibe los datos de un personaje a través de un Intent y los muestra en una vista.
 */
public class DetallePersonajeActivity extends AppCompatActivity {

    /**
     * Metodo que se llama cuando se crea la actividad.
     *
     * @param savedInstanceState Si la actividad se reinicia, este Bundle contiene el estado guardado.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_personaje);

        // Referencias a los elementos de la vista
        TextView nombrePersonaje = findViewById(R.id.nombrePersonaje);
        ImageView imagenPersonaje = findViewById(R.id.imagenPersonaje);
        TextView descripcionPersonaje = findViewById(R.id.descripcionPersonaje);
        TextView habilidadesPersonaje = findViewById(R.id.habilidadesPersonaje);
        Button volverAListado = findViewById(R.id.volverAListado);

        // Obtiene los datos del Intent
        String nombre = getIntent().getStringExtra("nombre");
        int imagen = getIntent().getIntExtra("imagen", 0);
        String descripcion = getIntent().getStringExtra("descripcion");
        String habilidad = getIntent().getStringExtra("habilidad");

        // Establece los datos en los elementos de la vista
        nombrePersonaje.setText(nombre);
        imagenPersonaje.setImageResource(imagen);
        descripcionPersonaje.setText(descripcion);
        habilidadesPersonaje.setText(habilidad);

        // Configura el botón para volver
        volverAListado.setOnClickListener(view -> finish());
    }
}
