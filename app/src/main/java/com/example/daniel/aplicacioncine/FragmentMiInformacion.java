package com.example.daniel.aplicacioncine;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.SharedPreferencesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentMiInformacion.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class FragmentMiInformacion extends Fragment {

    private OnFragmentInteractionListener mListener;

    private EditText etEdad,etProfesion, etGeneroPelicula1, etGeneroPelicula2;
    private Button boton;
    private RadioButton rdboton1,rdboton2;
    Activity activity;

    public FragmentMiInformacion() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_mi_informacion, container, false);
        etEdad = (EditText)view.findViewById(R.id.etEdad);
        etProfesion = (EditText)view.findViewById(R.id.etProfesion);
        etGeneroPelicula1=(EditText)view.findViewById(R.id.etGeneroPelicula1);
        etGeneroPelicula2=(EditText)view.findViewById(R.id.etGeneroPelicula2);
        boton=(Button)view.findViewById(R.id.button);
        rdboton1=(RadioButton)view.findViewById(R.id.radioButton1);
        rdboton2=(RadioButton)view.findViewById(R.id.radioButton2);

        activity = getActivity();
        SharedPreferences prefe= activity.getSharedPreferences("datos",Context.MODE_PRIVATE);
        etEdad.setText(prefe.getString("edad",""));
        etProfesion.setText(prefe.getString("profesion",""));
        etGeneroPelicula1.setText(prefe.getString("genero1",""));
        etGeneroPelicula2.setText(prefe.getString("genero2",""));

        if ( prefe.getString("masculino","").equals("true")) {
            rdboton1.setChecked(true);
        }
        else{
                rdboton2.setChecked(true);
        }

        boton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                activity = getActivity();
                SharedPreferences preferencias= activity.getSharedPreferences("datos",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=preferencias.edit();
                editor.putString("edad",etEdad.getText().toString());
                editor.putString("profesion",etProfesion.getText().toString());
                editor.putString("genero1",etGeneroPelicula1.getText().toString());
                editor.putString("genero2",etGeneroPelicula2.getText().toString());
                if( rdboton1.isChecked()) {
                    editor.putString("masculino", "true");
                    editor.putString("femenino", "false");
                }
                else{
                        editor.putString("masculino","true");
                        editor.putString("femenino","false");
                }
                Toast.makeText( activity, "Se guardaron los datos correctamente",Toast.LENGTH_SHORT).show();
                editor.commit();
            }
        });

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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
