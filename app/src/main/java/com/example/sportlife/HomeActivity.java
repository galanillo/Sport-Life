package com.example.sportlife;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity;


public class HomeActivity extends AppCompatActivity {

    private Button cerrar_s;
    private Button calendario;
    private Button musica;
    private Button historial;
    private Button mapa;
    private Button cronometro;
    private Button videos;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toast toastp = new Toast(getApplicationContext());
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.activity_toast,(ViewGroup) findViewById(R.id.lytLayout));
        TextView txtMsg = (TextView)layout.findViewById(R.id.txtMensaje);
        txtMsg.setText("Bienvenido a sportlife, utilice nuestro menu de opciones para llevar a cabo su vida deportiva");
        toastp.setDuration(Toast.LENGTH_LONG);
        toastp.setGravity(Gravity.CENTER|Gravity.CENTER, 0, 0);
        toastp.setView(layout);
        toastp.show();


        cerrar_s=(Button)findViewById(R.id.button_1);

        cerrar_s.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                FirebaseAuth.getInstance().signOut();
                Intent cerrar = new Intent(HomeActivity.this, LogActivity.class);
                startActivity(cerrar);
            }
        });

        calendario=(Button)findViewById(R.id.button8);

        calendario.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent calendar = new Intent(HomeActivity.this, Calendario.class);
                startActivity(calendar);
            }
        });

        musica=(Button)findViewById(R.id.button5);

        musica.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent music = new Intent(HomeActivity.this, Musica.class);
                startActivity(music);
            }
        });

        historial=(Button)findViewById(R.id.button10);

        historial.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent historial = new Intent(HomeActivity.this, Tareas.class);
                startActivity(historial);
            }
        });

        mapa=(Button)findViewById(R.id.button7);

        mapa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent map = new Intent(HomeActivity.this, Mapa.class);
                startActivity(map);
            }
        });

        cronometro=(Button)findViewById(R.id.button9);

        cronometro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent cronometer = new Intent(HomeActivity.this, Cronometro.class);
                startActivity(cronometer);
            }
        });

        videos=(Button)findViewById(R.id.button11);

        videos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent video = new Intent(HomeActivity.this, Videos.class);
                startActivity(video);
            }
        });
    }






}