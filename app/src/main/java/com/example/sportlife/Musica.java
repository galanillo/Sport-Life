package com.example.sportlife;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Musica extends AppCompatActivity {

    private Button botonplay, botonstop, botonresume, botonpausa, botoninfo, botonvolmas, botonvolmenos, botonira;
    private float volumen = (float) 0.5;
    private float volumen2=0f;
    private MediaPlayer mp = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musica);
        mp = MediaPlayer.create(Musica.this, R.raw.cancion);
        botonplay = (Button)findViewById(R.id.empezar);
        botonstop = (Button)findViewById(R.id.buttonparar);
        botonresume = (Button)findViewById(R.id.buttoncontinuar);
        botonpausa = (Button)findViewById(R.id.buttonpausar);
        botonvolmas = (Button)findViewById(R.id.buttonvolmas);
        botonvolmenos = (Button)findViewById(R.id.buttonvolmenos);

        TextView etiquetatitulo = (TextView)findViewById(R.id.textView);




        botonplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mp.start();
                TextView etiquetatitulo = (TextView)findViewById(R.id.textView);
                final int position = mp.getAudioSessionId();
                boolean bol= mp.isPlaying();
                etiquetatitulo.setText("▶️The Final Countdown\n"+"Tipo: Rock");
                botonresume.setEnabled(true);
            }
        });


        botonstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                mp.stop();
                mp.prepareAsync();
                botonresume.setEnabled(false);


            }
        });

        botonresume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mp.start();

            }
        });

        botonpausa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                mp.pause();
            }
        });
        botonvolmas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (volumen>0.99f){
                    Toast toast = Toast.makeText(getApplicationContext(),"Tenga especial cuidado si esta utilizando auriculares, puede ser perjudicial para su salud auditiva.", Toast.LENGTH_LONG);
                    toast.show();
                }
                else{
                    volumen = (float)(volumen+0.1f);
                    mp.setVolume(volumen, volumen);

                }

            }
        });

        botonvolmenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (volumen<0.01f){
                    Toast toast = Toast.makeText(getApplicationContext(),"Volumen 0%", Toast.LENGTH_LONG);
                    toast.show();
                }
                else{
                    volumen = (float)(volumen-0.1f);
                    mp.setVolume(volumen, volumen);
                }

            }
        });



    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        mp.stop();
        mp.release();
        mp = null;
    };
}