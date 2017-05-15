package com.example.daniel.aplicacioncine;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Daniel on 20/03/2017.
 */

public class AdaptadorDePeliculas extends BaseAdapter {
    private Context context;

    public AdaptadorDePeliculas(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return Pelicula.ITEMS.length;
    }

    @Override
    public Pelicula getItem(int position) {
        return Pelicula.ITEMS[position];
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.grid_item, viewGroup, false);
        }

        ImageView imagenPelicula = (ImageView) view.findViewById(R.id.imagen_pelicula);
        TextView nombrePelicula = (TextView) view.findViewById(R.id.nombre_pelicula);

        final Pelicula item = getItem(position);
        Glide.with(imagenPelicula.getContext())
                .load(item.getIdDrawable())
                .into(imagenPelicula);

        nombrePelicula.setText(item.getNombre());

        return view;
    }

}