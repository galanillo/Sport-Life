package com.example.sportlife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Historial extends AppCompatActivity {

    private Button botoninsert, botondelete, botonmostrar;
    private EditText campoelemento, campocantidad, camponombre;
    private TextView etiquetamostrar;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);
        botoninsert = (Button)findViewById(R.id.botonguardar);
        botondelete = (Button)findViewById(R.id.button2);
        botonmostrar = (Button)findViewById(R.id.button3);
        campoelemento=(EditText)findViewById(R.id.editText1);
        campocantidad=(EditText)findViewById(R.id.editText2);
        camponombre=(EditText)findViewById(R.id.editText3);
        etiquetamostrar=(TextView)findViewById(R.id.textView1);




       /*BBDDHistorial rutas=new BBDDHistorial(this, "Rutas", null, 1);
         final SQLiteDatabase bbdd = rutas.getWritableDatabase();






        /*  botoninsert.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                ContentValues valores=new ContentValues();
                valores.put("nombre", camponombre.getText().toString());
                valores.put("tiempo", campoelemento.getText().toString());
                valores.put("km", campocantidad.getText().toString());

                bbdd.insert("Rutas", null, valores);
                campoelemento.setText(null);
                campocantidad.setText(null);
                camponombre.setText(null);
                etiquetamostrar.setText(null);
            }
        });   //////

        botoninsert.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                    ContentValues valores = new ContentValues();
                    valores.put("nombre", camponombre.getText().toString());
                    valores.put("tiempo", campoelemento.getText().toString());
                    valores.put("km", campocantidad.getText().toString());

                    bbdd.insert("Rutas", null, (valores));

                    bbdd.close();

                    campocantidad.setText("");
                    camponombre.setText("");
                    campoelemento.setText("");
            }
        });


        botondelete.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                bbdd.delete("Rutas", "tiempo='" + campoelemento.getText().toString()+"'",null);
                campoelemento.setText(null);
                campocantidad.setText(null);
                camponombre.setText(null);
                etiquetamostrar.setText(null);
            }
        });

        botonmostrar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                String campos[]= new String[] {"tiempo","km","nombre"};
                Cursor cursorbbdd = bbdd.query("Rutas", campos, null, null, null, null, null);

                if (cursorbbdd.moveToFirst()){
                    do{
                        String tiempo = cursorbbdd.getString(0);
                        int km = cursorbbdd.getInt(1);
                        String nombre = cursorbbdd.getString(2);
                        etiquetamostrar.append("Ruta "+nombre+": "+tiempo +" "+ km+"\n");
                    }while (cursorbbdd.moveToNext());
                }
                camponombre.setText(null);
                campoelemento.setText(null);
                campocantidad.setText(null);
            }
        }); */


    }
}