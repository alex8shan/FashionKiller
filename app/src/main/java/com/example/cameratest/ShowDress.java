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
import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;


public class ShowDress extends AppCompatActivity {

    static {
        if(!OpenCVLoader.initDebug()){
            Log.d("Second", "OpenCV not loaded");
        } else {
            Log.d("Second", "OpenCV loaded");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dress);

        Intent intent = getIntent();
        String filename = intent.getStringExtra("FILENAME");
        File imgFile = new  File(Environment.getExternalStorageDirectory(), filename);

        if(imgFile.exists()){

            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

            ImageView myImage = (ImageView) findViewById(R.id.imageView);

            myImage.setImageBitmap(myBitmap);
            //ProcessImage(myBitmap);

        }
        else {
            Log.d("Error", filename);
        }


    }
    public void ProcessImage(Bitmap b){

        Mat tmp = new Mat (b.getWidth(), b.getHeight(), CvType.CV_8UC1);
        Utils.bitmapToMat(b, tmp);
        Imgproc.cvtColor(tmp, tmp, Imgproc.COLOR_RGB2GRAY);
//there could be some processing
        Imgproc.cvtColor(tmp, tmp, Imgproc.COLOR_GRAY2RGB, 4);
        Utils.matToBitmap(tmp, b);
        ImageView myImage = (ImageView) findViewById(R.id.imageView);
        myImage.setImageBitmap(b);
    }
}
