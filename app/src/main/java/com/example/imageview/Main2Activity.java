package com.example.imageview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;
import android.media.MediaPlayer;

import static com.example.imageview.AppNoti.CHANNEL_1_ID;
import static com.example.imageview.AppNoti.CHANNEL_2_ID;




public class Main2Activity extends AppCompatActivity {


    CheckBox checkBox1,checkBox2,checkBox3;
    ToggleButton tglBtn;
    String val = "";
    RelativeLayout rltvlayout;
    Button btnTimeP;
    NotificationManagerCompat notificationManager;
    MediaPlayer mediaPlayer;
    boolean state = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        notificationManager = NotificationManagerCompat.from(this);

        rltvlayout = findViewById(R.id.bgd);
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        tglBtn = findViewById(R.id.tglBtn);
        btnTimeP = findViewById(R.id.btnTimeP);

       // checkBox1.setChecked(true);

        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.reng);




        tglBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked == true)
                    mediaPlayer.start();
                    rltvlayout.setBackgroundColor(Color.DKGRAY);
                    //state = true;


                if (isChecked == false)
                    mediaPlayer.pause();
                    rltvlayout.setBackgroundColor(Color.WHITE);

                   // state = false;


            }
        });

        btnTimeP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextActivity();
            }
        });

    }

    private void nextActivity() {
        Intent intent;
        intent = new Intent(this, ActivityTp.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(Main2Activity.this,0,intent,0);


        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
               // .setTicker("hey")
                .setSmallIcon(R.drawable.ic_beach_access_black_24dp)
                .setContentTitle("bezan berim")
                .setContentText("Activity jadid")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(pendingIntent)
                //.setSound(Uri.parse("android.resource://com.example.imageview/raw/reng"))
                .setAutoCancel(true)


                .build();



        notificationManager.notify(1, notification);

       //startActivity(intent);
    }

    public void pressCheckBox(View v){

        int id = v.getId();

        if(id == R.id.checkBox1) {

           // mediaPlayer.start();
           // theRest();
            rltvlayout.setBackgroundColor(Color.BLUE);

        } else if(id == R.id.checkBox2) {
           // mediaPlayer.pause();
           // theRest();
            rltvlayout.setBackgroundColor(Color.MAGENTA);

        }else if(id == R.id.checkBox3) {
           // theRest();
            rltvlayout.setBackgroundColor(Color.GRAY);
        }



    }

   /* private void theRest() {

            if( checkBox1.isChecked())
                val = "checkBox1 is checked";

                Toast.makeText(this, val, Toast.LENGTH_SHORT).show();

           
            if( checkBox2.isChecked())
                val = "checkBox2 is checked";

                Toast.makeText(this, val, Toast.LENGTH_SHORT).show();

            if(checkBox3.isChecked())
                val = "checkBox3 is checked";


                Toast.makeText(this, val, Toast.LENGTH_SHORT).show();

        rltvlayout.setBackgroundColor(Color.WHITE);

    }*/
}
