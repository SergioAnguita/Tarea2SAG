package com.example.tarea2sag;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase es la actividad principal de la aplicación.
 *
 * Esta actividad muestra un RecyclerView con una lista de personajes y utiliza un
 * DrawerLayout y un NavigationView para proporcionar una navegación intuitiva en la aplicación.
 *
 * También incluye un menú con opciones adicionales y un mensaje de bienvenida en un Snackbar.
 *
 * @author Sergio Anguita
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Contenedor para el menú de navegación "Drawer".
     */
    DrawerLayout drawerLayout;
    /**
     * Vista de navegación lateral que contiene los elementos del menú.
     */
    NavigationView navigationView;
    /**
     * Preferencias compartidas para gestionar configuraciones de usuario.
     */
    SharedPreferences sharedPreferences;
    /**
     * RecyclerView utilizado para mostrar la lista de personajes.
     */
    RecyclerView rv;
    /**
     * Lista de objetos que representa a los personajes.
     */
    List<Person> persons;

    /**
     * Metodo de inicialización principal para la actividad.
     *
     * @param savedInstanceState Estado guardado de la actividad.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configura el DrawerLayout
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        // Configura el NavigationView
        navigationView.setNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_inicio) {
                // Vuelve a la MainActivity
                drawerLayout.closeDrawers();
            } else if (item.getItemId() == R.id.nav_ajustes) {
                // Abrir la actividad de ajustes
                openSettings();
                drawerLayout.closeDrawers();
            }
            return true;
        });

        // Configura la barra de herramientas
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        rv = findViewById(R.id.rv);
        initializeData();
        View rootView = findViewById(android.R.id.content);

        // Muestra el mensaje de bienvenida
        Snackbar.make(rootView, R.string.bienvenida, Snackbar.LENGTH_LONG).show();

        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        RVAdapter adapter = new RVAdapter(persons);
        rv.setAdapter(adapter);
    }

    /**
     * Abre la actividad de ajustes.
     */
    private void openSettings() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    /**
     * Crea el menú de opciones.
     *
     * @param menu Objeto del menú.
     * @return true si el menú se creó correctamente.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflar el menú
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * Maneja la selección de opciones en el menú.
     *
     * @param item Elemento del menu seleccionado.
     * @return true si la accion fue manejada correctamente.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Gestionar las opciones del menú
        if (item.getItemId() == R.id.menu_acerca_de) {
            // Mostrar el dialog "Acerca de..."
            mostrarAcercaDe();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Muestra un diálogo "Acerca de..." con información de la aplicación.
     */
    private void mostrarAcercaDe() {
        // Crear un AlertDialog para "Acerca de..."
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.dialog);
        builder.setTitle(R.string.texto_acerca);
        builder.setMessage(R.string.dialog_acerca);
        builder.setIcon(R.mipmap.ic_launcher); // Cambia por el ícono de tu aplicación
        builder.setPositiveButton(R.string.aceptar, (dialog, which) -> dialog.dismiss());
        builder.create().show();
    }

    /**
     * Inicializa la lista de personajes con los datos aportados.
     */
    private void initializeData() {
        persons = new ArrayList<>();
        persons.add(new Person(R.drawable.luigi, getString(R.string.nombre_luigi),
                getString(R.string.descripcion_luigi), getString(R.string.habilidades_luigi)));
        persons.add(new Person(R.drawable.mario, getString(R.string.nombre_mario),
                getString(R.string.descripcion_mario), getString(R.string.habilidades_mario)));
        persons.add(new Person(R.drawable.peach, getString(R.string.nombre_peach),
                getString(R.string.descripcion_peach), getString(R.string.habilidades_peach)));
        persons.add(new Person(R.drawable.toad, getString(R.string.nombre_toad),
                getString(R.string.descripcion_toad), getString(R.string.habilidades_toad)));
    }
}