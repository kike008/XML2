package com.example.kike.xml2;


import java.util.ArrayList;
import java.util.HashMap;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity extends ListActivity {

    // All static variables
    static final String URL = "http://iin8.szhernandez.dx.am/bbdd_enrique.xml";
    // XML node keys
    static final String KEY_CONTACTO = "vacunacion"; // parent node
    static final String KEY_ID_A = "id_a";
    static final String KEY_COMUNIDAD = "comunidad";
    static final String KEY_MVZ = "mvz";
    static final String KEY_TELEFONO = "telefono";
    static final String KEY_PERROS = "perros";
    static final String KEY_GATOS = "gatos";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<HashMap<String, String>> menuItems = new ArrayList<HashMap<String, String>>();

        XMLParser parser = new XMLParser();
        String xml = parser.getXmlFromUrl(URL); // getting XML
        Document doc = parser.getDomElement(xml); // getting DOM element

        NodeList nl = doc.getElementsByTagName(KEY_CONTACTO);

        // looping through all item nodes <item>
        for (int i = 0; i < nl.getLength(); i++) {
            // creating new HashMap
            HashMap<String, String> map = new HashMap<String, String>();
            Element e = (Element) nl.item(i);
            // adding each child node to HashMap key => value
            map.put(KEY_ID_A, parser.getValue(e, KEY_ID_A));
            map.put(KEY_COMUNIDAD, parser.getValue(e, KEY_COMUNIDAD));
            map.put(KEY_MVZ, parser.getValue(e, KEY_MVZ));
            map.put(KEY_TELEFONO, parser.getValue(e, KEY_TELEFONO));
            map.put(KEY_PERROS, parser.getValue(e, KEY_PERROS));
            map.put(KEY_GATOS, parser.getValue(e, KEY_GATOS));

            // adding HashList to ArrayList
            menuItems.add(map);
        }

        // Adding menuItems to ListView
        ListAdapter adapter = new SimpleAdapter(this, menuItems,
                R.layout.activity_lista_vacunacion, new String[] {KEY_ID_A, KEY_COMUNIDAD, KEY_MVZ, KEY_TELEFONO, KEY_PERROS, KEY_GATOS},
                new int[] { R.id.id_A,R.id.comunidad,R.id.mvz,R.id.telefono, R.id.perros,  R.id.gatos });
        setListAdapter(adapter);

        // selecting single ListView item
        ListView lv = getListView();
        // listening to single listitem click
        lv.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // getting values from selected ListItem
                String lblid_A = ((TextView) view.findViewById(R.id.id_A)).getText().toString();
                String lblcomunidad = ((TextView) view.findViewById(R.id.comunidad)).getText().toString();
                String lblmvz = ((TextView) view.findViewById(R.id.mvz)).getText().toString();
                String lbltefono = ((TextView) view.findViewById(R.id.telefono)).getText().toString();
                String lblperros = ((TextView) view.findViewById(R.id.perros)).getText().toString();
                String lblgatos = ((TextView) view.findViewById(R.id.gatos)).getText().toString();

                // Starting new intent
                Intent in = new Intent(getApplicationContext(), lista_vacunacion.class);
                in.putExtra(KEY_ID_A, lblid_A);
                in.putExtra(KEY_COMUNIDAD, lblcomunidad);
                in.putExtra(KEY_MVZ, lblmvz);
                in.putExtra(KEY_TELEFONO, lbltefono);
                in.putExtra(KEY_PERROS, lblperros);
                in.putExtra(KEY_GATOS, lblgatos);

                startActivity(in);
            }
        });
    }
}