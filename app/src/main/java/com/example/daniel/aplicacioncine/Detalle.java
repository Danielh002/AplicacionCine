package com.example.daniel.aplicacioncine;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ms.square.android.expandabletextview.ExpandableTextView;

import java.util.ArrayList;
import java.util.List;

public class Detalle extends AppCompatActivity {

    String cadena="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean scelerisque eros aliquam condimentum interdum. Etiam sed elit nibh. Praesent eu interdum augue. Vestibulum vel mauris euismod, fermentum massa sed, mollis justo. In mollis tortor risus, ac iaculis risus varius eu. Nunc a elit condimentum, gravida risus a, fermentum lectus. Aliquam mattis, turpis ut dignissim tristique, orci ligula consequat enim, id porttitor erat tortor eget augue.\n"+
            "\n"+"Maecenas vulputate diam";

    public static final String EXTRA_PARAM_ID = "com.programacion.peliculas2017.extra.ID";
    public static final String VIEW_NAME_HEADER_IMAGE = "imagen_compartida";
    private Pelicula itemDetallado;
    private ImageView imagenExtendida;
    TabHost tabHost;
    TextView tvNombre,tvGenero,tvActores;
    ExpandableTextView expandableTextView;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference  referenciaPelis = database.getReference(DataBaseReference.BASE_DATOS_APLICACIONES_REFERENCES).child(DataBaseReference.PELICULAS_REFERENCES);






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        usarToolbar();
        tvNombre = (TextView)findViewById(R.id.tvNombre);
        tvGenero = (TextView)findViewById(R.id.tvGenero);
        tvActores = (TextView)findViewById(R.id.tvActores);

        tabHost = (TabHost)findViewById(R.id.tabHost);
        tabHost.setup();
        TabHost.TabSpec ts1= tabHost.newTabSpec("Tab1");
        ts1.setIndicator("Hoy");
        ts1.setContent(R.id.tab1);
        tabHost.addTab(ts1);

        tabHost.setup();
        TabHost.TabSpec ts2= tabHost.newTabSpec("Tab2");
        ts2.setIndicator("Mañana");
        ts2.setContent(R.id.tab2);
        tabHost.addTab(ts2);

        tabHost.setup();
        TabHost.TabSpec ts3= tabHost.newTabSpec("Tab3");
        ts3.setIndicator("Todss");
        ts3.setContent(R.id.tab3);
        tabHost.addTab(ts3);

        expandableTextView =(ExpandableTextView)findViewById(R.id.expandable_text_view);
        // Obtener la pelicula con el identificador establecido en el fragmento Carteleras

        //itemDetallado = Pelicula.getItem(getIntent().getIntExtra(EXTRA_PARAM_ID, 0));
        imagenExtendida = (ImageView) findViewById(R.id.imagen_extendida);


        final List<Pelicula> peliculas = new ArrayList<Pelicula>();

        referenciaPelis.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot noteSnapshot: dataSnapshot.getChildren()){
                    Pelicula peli = noteSnapshot.getValue(Pelicula.class);
                    Log.i("Coche", peli.getNombre());
                    peliculas.add(peli);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("Error", databaseError.getMessage());
            }
        });

        itemDetallado = peliculas.get(getIntent().getIntExtra(EXTRA_PARAM_ID, 0));
        //cargarImagenExtendida();
        //cargarDatos();
    }

    private void cargarImagenExtendida() {
        Glide.with(imagenExtendida.getContext())
                .load(itemDetallado.getIdDrawable())
                .into(imagenExtendida);
    }

    private void cargarDatos(){
        tvNombre.setText(itemDetallado.getNombre());
        tvGenero.setText(itemDetallado.getGenero());
        tvActores.setText(itemDetallado.getActores());
        expandableTextView.setText(itemDetallado.getSinopsis());

        //expandableTextView.setText(cadena);
    }

    private void usarToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void MostrarTrailer( View v){
        Intent myIntent = new Intent(this, Trailer.class );
        myIntent.putExtra("URL","uisBaTkQAEs"); //Optional parameters
        this.startActivity(myIntent);
    }


}