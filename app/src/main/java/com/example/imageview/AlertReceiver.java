package com.example.imageview;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import static com.example.imageview.AppNoti.CHANNEL_1_ID;


public class AlertReceiver extends BroadcastReceiver {
    MediaPlayer mediaPlayer;
    NotificationManagerCompat notificationManager;
    @Override
    public void onReceive(Context context, Intent intent) {
        notificationManager = NotificationManagerCompat.from(context);
        mediaPlayer = MediaPlayer.create(context.getApplicationContext(), R.raw.reng);
        mediaPlayer.start();
        Toast.makeText(context, "toast", Toast.LENGTH_SHORT).show();
        nextActivity(context);

    }
    private void nextActivity(Context context) {
        Intent intent;
        intent = new Intent(context, ActivityTp.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(context,2,intent,0);


        Notification notification = new NotificationCompat.Builder(context, CHANNEL_1_ID)
                // .setTicker("hey")
                .setSmallIcon(R.drawable.walk)
                .setContentTitle("Alarm")
                .setContentText("pasho residim istgah akhare")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(pendingIntent)
                .setLights(0,2000,200)
                //.setSound(Uri.parse("android.resource://com.example.imageview/raw/reng"))
                .setAutoCancel(true)
                .build();

        notificationManager.notify(1, notification);

        //startActivity(intent);
    }
}
