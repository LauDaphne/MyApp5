package com.studium.myapp5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Intent intentBoton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.tittlePrinc);
    }

    public void crearToast(View view) {
        intentBoton= new Intent(this, ToastActivity.class);
        startActivity(intentBoton);
    }

    public void crearNotify(View view) {
        intentBoton= new Intent(this, NotificacionActivity.class);
        startActivity(intentBoton);
    }
}
