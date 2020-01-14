package com.studium.myapp5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        setTitle(R.string.tittleToast);

        final EditText txtToastJv = findViewById(R.id.txtToast);
        final EditText desplVertJv = findViewById(R.id.txtDespVert);
        final EditText desplHorJv = findViewById(R.id.txtDespHor);
        final RadioGroup alingHorJv = findViewById(R.id.alingHorizontal);
        final RadioGroup alingVerJv = findViewById(R.id.alingVertical);
        Button bttnMostrarJv = findViewById(R.id.bttnMostrar);

        bttnMostrarJv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                int alingVer = 0 ;
                int alingHor = 0;

                try{
                    switch (alingVerJv.indexOfChild(findViewById(alingVerJv.getCheckedRadioButtonId()))){
                        case 0:
                            alingVer = Gravity.TOP;
                            break;
                        case 1:
                            alingVer = Gravity.CENTER;
                            break;
                        case 2:
                            alingVer = Gravity.BOTTOM;
                            break;
                    }

                    switch (alingHorJv.indexOfChild(findViewById(alingHorJv.getCheckedRadioButtonId()))){
                        case 0:
                            alingHor = Gravity.LEFT;
                            break;
                        case 1:
                            alingHor = Gravity.CENTER;
                            break;
                        case 2:
                            alingHor = Gravity.RIGHT;
                            break;
                    }

                    Toast toastUsuario = Toast.makeText(v.getContext(),txtToastJv.getText().toString(),Toast.LENGTH_LONG);
                    toastUsuario.setGravity(alingVer|alingHor,Integer.parseInt(desplHorJv.getText().toString()),Integer.parseInt(desplVertJv.getText().toString()));
                    toastUsuario.show();
                }catch (Exception e){
                    Toast.makeText(v.getContext(),"No has introducido los datos correctamente, vuelve a intentarlo", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
