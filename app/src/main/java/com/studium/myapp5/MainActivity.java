package com.studium.myapp5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.tittlePrinc);
    }

    public void crearToast(View view) {

    }

    public void crearNotify(View view) {
    }
}
