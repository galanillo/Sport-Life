package com.example.sportlife;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogActivity extends AppCompatActivity {
    EditText rEmail, rPasswd;
    Button btLogin;
    TextView rForgotPasswd;
    FirebaseAuth fAuth;
    ProgressBar lProgBar;
    CheckBox rememberUser;

    //TODO: Integrar google sing in
    private static final int RC_SIGN_IN = 100;
    private static final String TAG = "GOOGLE_SIGN_IN_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //for changing status bar icon colors
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        setContentView(R.layout.activity_login);

        rEmail = (EditText) findViewById(R.id.editTextEmail);
        rPasswd = (EditText) findViewById(R.id.editTextPassword);
        btLogin  = (Button) findViewById(R.id.cirLoginButton);
        rForgotPasswd = (TextView) findViewById(R.id.textForgotPassw);
        lProgBar = (ProgressBar) findViewById(R.id.progressBarLogin);
        rememberUser = (CheckBox) findViewById(R.id.rememberUserCheck);

        fAuth = FirebaseAuth.getInstance();

        SharedPreferences preferencias = getSharedPreferences("datos", MODE_PRIVATE);
        String email = preferencias.getString("email", "");
        String pass = preferencias.getString("password", "");

        rEmail.setText(email);
        rPasswd.setText((pass));


        rForgotPasswd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText resetMail = new EditText(view.getContext());
                AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(view.getContext());
                passwordResetDialog.setTitle(getResources().getString(R.string.pass_reset_title));
                passwordResetDialog.setMessage(getResources().getString(R.string.pass_reset_msg));
                passwordResetDialog.setView(resetMail);

                passwordResetDialog.setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String mail = resetMail.getText().toString();
                        fAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(LogActivity.this, getResources().getString(R.string.reset_link_send), Toast.LENGTH_LONG).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(LogActivity.this, getResources().getString(R.string.reset_link_fail) + e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                });
                passwordResetDialog.setNegativeButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // cierra el dialogo
                    }
                });

                // TODO: Agregar icono y mas cosas al Dialog
                passwordResetDialog.create().show();
            }
        });

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = rEmail.getText().toString().trim();
                String pass = rPasswd.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    rEmail.setError(getResources().getString(R.string.error_email_required));
                    return;
                }

                if (TextUtils.isEmpty(pass)) {
                    rPasswd.setError(getResources().getString(R.string.error_pass_required));
                    return;
                }

                if (pass.length() < 6) {
                    rPasswd.setError(getResources().getString(R.string.error_pass_too_short));
                    return;
                }

                lProgBar.setVisibility(View.VISIBLE);

                fAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            // TODO: Modificar Toast por uno personalizado acorde al UI.
                            Toast.makeText(LogActivity.this, getResources().getString(R.string.login_ok), Toast.LENGTH_SHORT).show();

                            SharedPreferences preferencias = getSharedPreferences("datos", MODE_PRIVATE);
                            SharedPreferences.Editor editor = preferencias.edit();
                            if(rememberUser.isChecked()){
                                // Preferencia nombre "datos"
                                // Guarda preferencias con estas etiquetas
                                editor.putString("password", pass);
                                editor.putString("email", email);
                                editor.commit();
                            }
                            else{
                                editor.putString("password", "");
                                editor.putString("email", "");
                                editor.commit();
                            }

                            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        }
                        else{
                            Toast.makeText(LogActivity.this, getResources().getString(R.string.login_not_ok) + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });
    }

    public void onLoginClick(View View){
        startActivity(new Intent(LogActivity.this, RegActivity.class));
        //overridePendingTransition(R.anim.slide_in_right,R.anim.stay);
    }
}