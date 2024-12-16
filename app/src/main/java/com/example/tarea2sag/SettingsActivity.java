package com.example.tarea2sag;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

/**
 * La clase permite a los usuarios personalizar la configuración de la aplicación.
 *
 * Incluye la funcionalidad para cambiar el idioma de la aplicación
 * entre español e inglés utilizando un Switch y almacenar esta preferencia
 * en SharedPreferences.
 *
 * Cuando el usuario cambia el idioma, la aplicación se reinicia para reflejar
 * el cambio en la configuración regional.
 *
 * @author Sergio Anguita
 */
public class SettingsActivity extends AppCompatActivity {

    /**
     * Permite al usuario cambiar de idioma
     */
    private Switch languageSwitch;

    /**
     * Este objeto se utiliza para almacenar las preferencias del usuario
     */
    private SharedPreferences sharedPreferences;

    /**
     * Metodo llamado cuando se crea la actividad. Inicializa la interfaz de usuario,
     * carga las preferencias guardadas y configura el listener para el cambio de idioma.
     *
     * @param savedInstanceState Si la actividad se reinicia, este objeto contiene
     *                           el estado previamente guardado; de lo contrario, es null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        languageSwitch = findViewById(R.id.language_switch);

        // Recuperamos las preferencias almacenadas
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isEnglish = sharedPreferences.getBoolean("language", false);
        // False = Español, True = Inglés

        // Establecer el estado del switch
        languageSwitch.setChecked(isEnglish);

        languageSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Guardamos el idioma
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("language", isChecked);
            editor.apply();

            // Cambia el idioma
            changeLanguage(isChecked ? "en" : "es");

            // Muestra el mensaje de que el idioma ha sido cambiado
            String message = isChecked ? getString(R.string.language_change) : getString(R.string.language_change_es);
            Toast.makeText(SettingsActivity.this, message, Toast.LENGTH_SHORT).show();
        });
    }


    /**
     * Cambia el idioma de la aplicación y reinicia la actividad principal para reflejar el cambio.
     *
     * @param languageCode Código del idioma al que se cambiará ("en" es inglés, "es" es español).
     */
    private void changeLanguage(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        android.content.res.Configuration config = getResources().getConfiguration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());

        // Reiniciar la actividad para hacer el cambio
        Intent refresh = new Intent(SettingsActivity.this, MainActivity.class);
        startActivity(refresh);
        finish();
    }
}
