package com.example.sportlife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

public class Calendario extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        final String[] datos = new String[31];
        final TextView label = (TextView) findViewById(R.id.dia);
        final TextView dia1 = (TextView) findViewById(R.id.dia1);
        final GridView grid;
        final Button registrar = (Button) findViewById(R.id.botonregistrar);
        final Button eliminar = (Button) findViewById(R.id.botoneliminar);
        final EditText tarea = (EditText) findViewById(R.id.edittarea);
        final EditText dia = (EditText) findViewById(R.id.editdia);

        for (int i = 1; i <= 31; i++)
            datos[i - 1] = "Dia " + i;

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);
        grid = (GridView) findViewById(R.id.gridView1);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int posicion, long id) {
                label.setText("Has seleccionado el dia: " + datos[posicion]);
            }
        });


        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tvValue = dia.getText().toString();
                int num = Integer.parseInt(tvValue);
                if (num <= 31) {
                    dia1.setText("Tarea: " + tarea.getText() + ". El dia: " + dia.getText() + ".");
                }else{
                    dia1.setText("Tarea: " + tarea.getText() + ". El dia: (ERROR 32: No es una fecha válida)");
                }
            }
        });


        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dia1.setText("");
            }
        });
    }
}




