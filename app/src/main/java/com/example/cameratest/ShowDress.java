package com.example.cameratest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.os.Environment;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.util.List;
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
    public String getRandom(List<String> fileName)
    {
        Random generator = new Random();
        int randomIndex = generator.nextInt(fileName.size());
        return fileName.get(randomIndex);
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
            Bitmap myBitmap = BitmapFactory.decodeFile(imageFile2.getAbsolutePath());

            imageView2.setImageBitmap(myBitmap);
        }



        imageView.setOnTouchListener(new OnSwipeTouchListener(ShowDress.this) {
            public void onSwipeTop() {
                Toast.makeText(ShowDress.this, "top", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeRight() {
                imageName1 = getRandom(SpinnerActivity.array1);

                File imageFile1 = new File(Environment.getExternalStorageDirectory(), imageName1);

                final ImageView imageView = (ImageView) findViewById(R.id.imageView);

                if(imageFile1.exists()){

                    Bitmap myBitmap = BitmapFactory.decodeFile(imageFile1.getAbsolutePath());

                    imageView.setImageBitmap(myBitmap);
                };
            }
            public void onSwipeLeft() {
                imageName1 = getRandom(SpinnerActivity.array1);

                File imageFile1 = new File(Environment.getExternalStorageDirectory(), imageName1);

                final ImageView imageView = (ImageView) findViewById(R.id.imageView);

                if(imageFile1.exists()){

                    Bitmap myBitmap = BitmapFactory.decodeFile(imageFile1.getAbsolutePath());

                    imageView.setImageBitmap(myBitmap);
                }

            }
            public void onSwipeBottom() {
                Toast.makeText(ShowDress.this, "bottom", Toast.LENGTH_SHORT).show();
            }

        });

        imageView2.setOnTouchListener(new OnSwipeTouchListener(ShowDress.this) {
            public void onSwipeTop() {
                Toast.makeText(ShowDress.this, "top", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeRight() {
                imageName2 = getRandom(SpinnerActivity.array2);

                File imageFile2 = new File(Environment.getExternalStorageDirectory(), imageName2);

                final ImageView imageView = (ImageView) findViewById(R.id.imageView2);

                if(imageFile2.exists()){

                    Bitmap myBitmap = BitmapFactory.decodeFile(imageFile2.getAbsolutePath());

                    imageView.setImageBitmap(myBitmap);
                };
            }
            public void onSwipeLeft() {
                imageName2 = getRandom(SpinnerActivity.array2);

                File imageFile1 = new File(Environment.getExternalStorageDirectory(), imageName2);

                final ImageView imageView = (ImageView) findViewById(R.id.imageView2);

                if(imageFile1.exists()){

                    Bitmap myBitmap = BitmapFactory.decodeFile(imageFile1.getAbsolutePath());

                    imageView.setImageBitmap(myBitmap);
                }

            }
            public void onSwipeBottom() {
                Toast.makeText(ShowDress.this, "bottom", Toast.LENGTH_SHORT).show();
            }

        });
    }


}
