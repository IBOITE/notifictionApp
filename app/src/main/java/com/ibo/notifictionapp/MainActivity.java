package com.ibo.notifictionapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.btndd);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationManager notificationManager;
                int id=1;

                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
                    CharSequence name="channel_name";
                    String discription="channel_discription";
                    int imortance=NotificationManager.IMPORTANCE_DEFAULT;
                    NotificationChannel channel=new NotificationChannel("channel_id",name,imortance);
                    channel.setDescription(discription);
                    notificationManager=getSystemService(NotificationManager.class);
                    notificationManager.createNotificationChannel(channel);


                    NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this,channel.getId()).setAutoCancel(true).setDefaults(id).setContentTitle("my title").setContentText("my text")
                            .setSmallIcon(R.drawable.ic_launcher_foreground);
//                            .setVibrate(new long[]{1000,500,1000}).setLargeIcon().setSmallIcon().setSound()
                    notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                    notificationManager.notify(id,builder.build());
                    id++;

                }
            }
        });
    }
}