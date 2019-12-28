package com.example.imageview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;



import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    TextView txtCounter;
    Button btnNext,btnPrevious,btnNewAct;



    int ids[] = {
            R.drawable.e1,
            R.drawable.e2,
            R.drawable.e3,
            R.drawable.e4,
            R.drawable.e5,
            R.drawable.e6

    };

    int Counter = 0;
    int Length;



    //@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        txtCounter = findViewById(R.id.txtCounter);
        btnNext = findViewById(R.id.btnNext);
        btnPrevious = findViewById(R.id.btnPrevious);
        btnNewAct = findViewById(R.id.btnNewAct);



        btnNewAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newAct();

                }
        });

        Length = ids.length;
        check();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Counter++;
                check();


            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Counter--;
                check();



            }
        });






       // Bitmap bmp = BitmapFactory.decodeResource(this.getResources(),R.drawable.e1);
        // imageView.setImageBitmap(bmp);

        //imageView.setImageResource(R.drawable.e1);

       // imageView.setImageDrawable(getDrawable(R.drawable.e1));

       // Uri uri = Uri.parse("android.resource://com.example.imageview/drawable/e1");
      //  imageView.setImageURI(uri);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        switch (id) {
            case R.id.item_x:{
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,0);

            }
            break;
            case R.id.item_y:{
                Intent intent;
                intent = new Intent(this, ActivityTp.class);
                startActivity(intent);
            }
            break;
        }


                return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bitmap bmp = (Bitmap) data.getExtras().get("data");
        imageView.setImageBitmap(bmp);

    }

    public void newAct() {
        Intent i = new Intent(MainActivity.this, Main2Activity.class);



        startActivity(i);


    }

    public void check() {
        if(Counter >= Length )
            Counter=0;
        else
        if(Counter < 0)
            Counter = Length-1;

        imageView.setImageResource(ids[Counter]);

        txtCounter.setText(Counter+1 + " / " + Length);

    }


}
