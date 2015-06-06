package com.example.kike.xml2;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class lista_vacunacion extends Activity {

    static final String KEY_ID_A = "id_A";
    static final String KEY_COMUNIDAD = "comunidad";
    static final String KEY_MVZ = "mvz";
    static final String KEY_TELEFONO = "telefono";
    static final String KEY_PERROS = "perros";
    static final String KEY_GATOS = "gatos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_vacunacion);

        Intent in = getIntent();

        String id_A = in.getStringExtra(KEY_ID_A);
        String comunidad = in.getStringExtra(KEY_COMUNIDAD);
        String mvz = in.getStringExtra(KEY_MVZ);
        String telefono = in.getStringExtra(KEY_TELEFONO);
        String perros = in.getStringExtra(KEY_PERROS);
        String gatos = in.getStringExtra(KEY_GATOS);

        TextView lblid_A = (TextView) findViewById(R.id.id_A);
        TextView lblcomunidad = (TextView) findViewById(R.id.comunidad);
        TextView lblmvz = (TextView ) findViewById(R.id.mvz);
        TextView lbltelefono = (TextView) findViewById(R.id.telefono);
        TextView lblperros = (TextView) findViewById(R.id.perros);
        TextView lblgatos = (TextView) findViewById(R.id.gatos);

        lblid_A.setText(Html.fromHtml("<b>Id_a:</b> " + id_A));
        lblcomunidad.setText(Html.fromHtml("<b>Comunidad:</b> " + comunidad));
        lblmvz.setText(Html.fromHtml("<b>MVZ:</b> " + mvz));
        lbltelefono.setText(Html.fromHtml("<b>Telefono:</b> " + telefono));
        lblperros.setText(Html.fromHtml("<b>Perros:</b> " + perros));
        lblgatos.setText(Html.fromHtml("<b>Gatos:</b> " + gatos));


    }
}
