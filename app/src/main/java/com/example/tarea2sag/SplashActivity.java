package com.example.tarea2sag;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

/**
 * La clase representa una pantalla de introducción (splash screen)
 * que se muestra al iniciar la aplicación.
 *
 * Esta pantalla permanece visible durante un breve periodo de tiempo (3 segundos)
 * antes de redirigir al usuario a la actividad principal (MainActivity).
 *
 *
 * Implementa la funcionalidad usando un Handler para establecer un retraso.
 * Una vez transcurrido el tiempo especificado, se inicia la actividad principal y
 * se cierra la actividad de splash para evitar que el usuario regrese a esta al
 * presionar el botón de retroceso.
 *
 * @author Sergio anguita
 */
public class SplashActivity extends AppCompatActivity {

    /**
     * Metodo llamado cuando se crea la actividad. Inicializa la interfaz de usuario y
     * establece un temporizador para redirigir al usuario después de un retraso.
     *
     * @param savedInstanceState Si la actividad se reinicia, este objeto contiene
     *                           el estado previamente guardado; de lo contrario, es null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Establece el diseño de la pantalla splash
        setContentView(R.layout.activity_splash);

        // Se usa un Handler para crear un retraso de 2-3 segundos
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Después del retraso, redirige a la actividad principal
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                // Finaliza la actividad de Splash para que no vuelva al presionar el botón de retroceso
                finish();
            }
        }, 3000); // 3000 milisegundos = 3 segundos
    }
}
