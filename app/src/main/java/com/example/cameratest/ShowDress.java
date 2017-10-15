package com.example.cameratest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.os.Environment;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.util.Random;

import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import static com.example.cameratest.R.id.imageView;

public class ShowDress extends AppCompatActivity {
    String imageName1;
    String imageName2;
    public String getRandom(String[] fileName)
    {
        Random generator = new Random();
        int randomIndex = generator.nextInt(fileName.length);
        return fileName[randomIndex];
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dress);

        //set random image name
        imageName1 = getRandom(SpinnerActivity.array1);
        imageName2 = getRandom(SpinnerActivity.array2);
        Log.i("debug", imageName1);

        File imageFile1 = new File(Environment.getExternalStorageDirectory(), imageName1);
        File imageFile2 = new File(Environment.getExternalStorageDirectory(), imageName2);

        final ImageView imageView = (ImageView) findViewById(R.id.imageView);
        final ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);

        if(imageFile1.exists()){

            Bitmap myBitmap = BitmapFactory.decodeFile(imageFile1.getAbsolutePath());

            imageView.setImageBitmap(myBitmap);
        }
        if(imageFile2.exists()){
            Bitmap myBitmap = BitmapFactory.decodeFile(imageFile1.getAbsolutePath());

            imageView2.setImageBitmap(myBitmap);
        }




        ConstraintLayout rl = (ConstraintLayout) findViewById(R.id.showDress);

        rl.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                Log.i("move", "something");
                imageView.setImageResource(R.drawable.ic_launcher);
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Toast.makeText(getApplicationContext(), "Swiped Down", Toast.LENGTH_SHORT);
                    return true;
                }
                return false;
            }
        });
    }


}
