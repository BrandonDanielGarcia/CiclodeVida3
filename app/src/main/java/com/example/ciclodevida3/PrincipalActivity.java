package com.example.ciclodevida3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import com.example.ciclodevida3.Datos.Datos;
import com.example.ciclodevida3.Modelo.VistaModelo;

import java.util.ArrayList;
import java.util.List;

public class PrincipalActivity extends AppCompatActivity {

    EditText tnombre, tedad;

    Button btnagregar;
    GridView gridLayout;
    ArrayList<String> nombres = new ArrayList<>();
    VistaModelo vistaModelo;
    List<Datos> listadatos = new ArrayList<>();

    private Observer<List<Datos>> observar = new Observer<List<Datos>>() {
        @Override
        public void onChanged(List<Datos> datosList) {
            listadatos = datosList;
            nombres.clear();
            nombres.add("NOMBRE");
            nombres.add("EDAD");
            for(Datos dato : listadatos){
                // recorro la lista
                nombres.add(dato.getNombre());
                nombres.add(Integer.toString(dato.getEdad()));
            }
            cargarGrid();
        }
    };

    public void cargarGrid(){
        ArrayAdapter<String> adaptador;
        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,nombres);
        gridLayout.setAdapter(adaptador);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        tnombre = findViewById(R.id.txtnombre);
        tedad = findViewById(R.id.txtedad);

        btnagregar = findViewById(R.id.btnagregar);

        vistaModelo = new ViewModelProvider(this).get(VistaModelo.class);
        vistaModelo.getListaDatos().observe(this,observar);
        gridLayout = (GridView) findViewById(R.id.gridView1);

        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Datos datos = new Datos(tnombre.getText().toString(),Integer.valueOf(tedad.getText().toString()));
                vistaModelo.Agregar(datos);
            }
        });
    }
}