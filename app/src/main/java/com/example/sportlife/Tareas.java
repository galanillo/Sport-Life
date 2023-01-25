package com.example.sportlife;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Tareas extends AppCompatActivity {

    private Button btninsert, btnactualizar, btnborrar, btnmostrar, btnsalir;
    private EditText campoelemento, campocantidad;
    private TextView etiquetamostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tareas);
        btninsert = (Button)findViewById(R.id.botonguardar);
        btnactualizar = (Button)findViewById(R.id.button1);
        btnborrar = (Button)findViewById(R.id.button2);
        btnmostrar = (Button)findViewById(R.id.button3);
        btnsalir = (Button)findViewById(R.id.button4);
        campoelemento=(EditText)findViewById(R.id.editText1);
        campocantidad=(EditText)findViewById(R.id.editText2);
        etiquetamostrar=(TextView)findViewById(R.id.textView1);
        ListaCompra listacompra=new ListaCompra(this, "ListaCompra", null, 1);
        final SQLiteDatabase bbdd = listacompra.getWritableDatabase();

        btninsert.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                ContentValues valores=new ContentValues();
                valores.put("elemento", campoelemento.getText().toString());
                valores.put("cantidad", campocantidad.getText().toString());
                bbdd.insert("ListaCompra", null, valores);
                campoelemento.setText(null);
                campocantidad.setText(null);
                etiquetamostrar.setText(null);
            }
        });

        btnactualizar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                ContentValues valores=new ContentValues();
                valores.put("cantidad", campocantidad.getText().toString());
                String where=campoelemento.getText().toString();
                bbdd.update("ListaCompra",valores, "elemento='" + where + "'", null);
                campoelemento.setText(null);
                campocantidad.setText(null);
                etiquetamostrar.setText(null);
            }
        });

        btnborrar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                bbdd.delete("ListaCompra", "elemento='" + campoelemento.getText().toString()+"'",null);
                campoelemento.setText(null);
                campocantidad.setText(null);
                etiquetamostrar.setText(null);
            }
        });

        btnmostrar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String campos[]= new String[] {"elemento","cantidad"};
                Cursor cursorbbdd = bbdd.query("ListaCompra", campos, null, null, null, null, null);

                if (cursorbbdd.moveToFirst()){
                    do{
                        String elemento = cursorbbdd.getString(0);
                        int cantidad = cursorbbdd.getInt(1);
                        etiquetamostrar.append(elemento +" "+ cantidad + "km" + "\n");
                    }while (cursorbbdd.moveToNext());
                }
                campoelemento.setText(null);
                campocantidad.setText(null);
            }
        });

        btnsalir.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                bbdd.close();
                finish();
            }
        });

    }


    }

