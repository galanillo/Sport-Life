package com.example.sportlife;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //TODO: Implementar algo antes de el login o quitar activity

        Intent i = new Intent(this, LogActivity.class);

    }

}
