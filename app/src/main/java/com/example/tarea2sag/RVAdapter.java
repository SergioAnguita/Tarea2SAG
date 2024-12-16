package com.example.tarea2sag;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * La clase es un adaptador personalizado para un RecyclerView,
 * que muestra una lista de objetos Person en tarjetas CardView.
 *
 * Este adaptador utiliza la vista de tarjeta para mostrar información de un personaje
 * (nombre, imagen) y permite interactuar con cada tarjeta para mostrar más detalles
 * en una nueva actividad .
 *
 * @author Sergio Anguita
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {

    /**
     * Lista de objetos que se mostrarán en el RecyclerView.
     */
    List<Person> persons;

    /**
     * Constructor de la clase.
     *
     * @param persons Lista de objetos Person que serán utilizados por el adaptador.
     */
    RVAdapter(List<Person> persons) {
        this.persons = persons;
    }


    /**
     * Clase interna que representa el ViewHolder para cada elemento del RecyclerView.
     */
    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        /**
         * Vista que contiene los elementos del personaje.
         */
        CardView cv;
        /**
         * Imagen del personaje.
         */
        ImageView imagen;
        /**
         * Nombre del personaje.
         */
        TextView nombre;


        /**
         * Constructor del ViewHolder, enlaza las vistas del diseño con los atributos.
         *
         * @param itemView Vista correspondiente al elemento del RecyclerView.
         */
        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            imagen = (ImageView) itemView.findViewById(R.id.imagen_cardview);
            nombre = (TextView) itemView.findViewById(R.id.nombre_cardview);
        }
    }

    /**
     * Devuelve el número total de elementos en la lista.
     *
     * @return Cantidad de elementos en la lista.
     */
    @Override
    public int getItemCount() {

        return persons.size();
    }

    /**
     * Crea nuevas vistas para el RecyclerView.
     *
     * @param viewGroup Grupo de vistas al que se agregará la nueva vista.
     * @param i Posición del elemento en la lista.
     * @return Un nuevo PersonViewHolder que contiene la vista creada.
     */
    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        //Inflamos cada tarjeta
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.personaje_cardview, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    /**
     * Enlaza los datos de un objeto Person con las vistas del ViewHolder.
     *
     * @param personViewHolder ViewHolder que se actualizará con los datos del objeto.
     * @param i Posición del objeto Person en la lista.
     */
    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        Person currentPerson = persons.get(i);
        personViewHolder.nombre.setText(currentPerson.getNombre());
        personViewHolder.imagen.setImageResource(currentPerson.getImagen());

        // Configura el listener para abrir la nueva actividad
        personViewHolder.cv.setOnClickListener(view -> {
            // Crear un Intent para abrir la nueva actividad
            Intent intent = new Intent(view.getContext(), DetallePersonajeActivity.class);

            // Pasar los datos del personaje a la nueva actividad
            intent.putExtra("nombre", currentPerson.getNombre());
            intent.putExtra("imagen", currentPerson.getImagen());
            intent.putExtra("descripcion", currentPerson.getDescripcion());
            intent.putExtra("habilidad", currentPerson.getHabilidad());

            //Mostramos un mensaje con el personaje seleccionado
            String mensaje = view.getContext().getString(R.string.personaje_seleccionado) + " " + currentPerson.getNombre();
            Toast.makeText(view.getContext(), mensaje, Toast.LENGTH_SHORT).show(); // Muestra el Toast

            // Iniciar la actividad
            view.getContext().startActivity(intent);
        });
    }

    /**
     * Se llama cuando el adaptador se adjunta a un RecyclerView.
     *
     * @param recyclerView RecyclerView al que se adjunta este adaptador.
     */
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}