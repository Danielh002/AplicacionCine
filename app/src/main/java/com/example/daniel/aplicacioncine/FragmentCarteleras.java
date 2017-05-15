package com.example.daniel.aplicacioncine;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;


public class FragmentCarteleras extends Fragment implements AdapterView.OnItemClickListener {
    private GridView gridView;
    private AdaptadorDePeliculas adaptador;
    Activity activity;

    private OnFragmentInteractionListener mListener;

    public FragmentCarteleras() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_carteleras, container, false);
        this.getActivity().getApplicationContext();
        gridView = (GridView)view.findViewById(R.id.grid);
        adaptador = new AdaptadorDePeliculas(this.getActivity());
        gridView.setAdapter(adaptador);
        gridView.setOnItemClickListener(this);
        Context context = getActivity().getApplicationContext();
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        activity = getActivity();
        Pelicula item = (Pelicula) parent.getItemAtPosition(position);

        Intent intent = new Intent(activity, Detalle.class);
        intent.putExtra(Detalle.EXTRA_PARAM_ID, item.getId());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            ActivityOptionsCompat activityOptions =
                    ActivityOptionsCompat.makeSceneTransitionAnimation(
                            this.getActivity(),
                            new Pair<View, String>(view.findViewById(R.id.imagen_pelicula),
                                    Detalle.VIEW_NAME_HEADER_IMAGE)
                    );

            ActivityCompat.startActivity(activity, intent, activityOptions.toBundle());
        } else
            startActivity(intent);
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}


