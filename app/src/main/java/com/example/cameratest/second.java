package com.example.cameratest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.File;

public class second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        Log.i("Some", "Message");
        String filename = intent.getStringExtra("FILENAME");
        File imgFile = new  File(Environment.getExternalStorageDirectory(), filename);

        if(imgFile.exists()){

            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

            ImageView myImage = (ImageView) findViewById(R.id.imageView);

            myImage.setImageBitmap(myBitmap);

        }
        else {
            Log.d("Error", filename);
        }


    }
}
