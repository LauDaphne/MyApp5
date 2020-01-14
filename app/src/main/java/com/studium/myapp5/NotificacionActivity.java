package com.studium.myapp5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NotificacionActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "canal" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificacion);
        setTitle(R.string.tittleNotificacion);

        createNotificationChannel();

        final EditText txtTituloNotifyJv = findViewById(R.id.txtTituloNotify);
        final EditText txtMensNotifyJv = findViewById(R.id.txtMensNotify);
        final EditText txtTiempoNotifyJv = findViewById(R.id.txtTiempoNotify);
        Button bttnEnviarJv = findViewById(R.id.bttnEnviar);

        bttnEnviarJv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(v.getContext(), MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    PendingIntent pendingIntent = PendingIntent.getActivity(v.getContext(), 0, intent, 0);


                    NotificationCompat.Builder notify = new NotificationCompat.Builder(v.getContext(), CHANNEL_ID)
                            .setSmallIcon(R.drawable.ic_tag_faces_blue_24dp)
                            .setContentTitle(txtTituloNotifyJv.getText().toString())
                            .setContentText(txtMensNotifyJv.getText().toString())
                            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                            .setContentIntent(pendingIntent)
                            .setAutoCancel(true);
                try{
                    Thread.sleep(Long.parseLong(txtTiempoNotifyJv.getText().toString())*1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                 NotificationManagerCompat notificationManager = NotificationManagerCompat.from(v.getContext());

                 notificationManager.notify(1, notify.build());


            }catch (Exception e){
                    Toast.makeText(v.getContext(),"No has introducido los datos correctamente, vuelve a intentarlo", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = CHANNEL_ID;
            String description = "Canal";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
