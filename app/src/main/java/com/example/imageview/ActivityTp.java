package com.example.imageview;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;

@RequiresApi(api = Build.VERSION_CODES.M)
public class ActivityTp extends AppCompatActivity {

    TimePicker timeP;
    TextView txtTp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tp);
        timeP = findViewById(R.id.timeP);
        txtTp = findViewById(R.id.txtTp);
        init();

        timeP.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hour, int min) {
                init();
            }
        });



    }

    private void init() {

        int hour = timeP.getHour();
        int min = timeP.getMinute();

        String format = "";

        if (hour >= 12){

        format = "PM";
        if(hour != 12)
        hour -= 12;

        }

        else format = "AM";

        txtTp.setText(addZero(hour) + " : " + addZero(min) + format);
    }

    String addZero(int num){
        if(num <= 9)
            return "0" + num;
            else
                return num + "";

    }

}
