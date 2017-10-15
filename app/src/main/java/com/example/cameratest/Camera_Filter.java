package com.example.cameratest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.graphics.Matrix;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import static org.opencv.core.Core.bitwise_and;
import static org.opencv.imgproc.Imgproc.COLOR_BGR2GRAY;
import static org.opencv.imgproc.Imgproc.contourArea;
import static org.opencv.imgproc.Imgproc.drawContours;


public class Camera_Filter extends AppCompatActivity {

    static {
        if(!OpenCVLoader.initDebug()){
            Log.d("Second", "OpenCV not loaded");
        } else {
            Log.d("Second", "OpenCV loaded");
        }
    }

    public static String filename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera__filter);

        Intent intent = getIntent();
        String filename = intent.getStringExtra("FILENAME");
        File imgFile = new  File(Environment.getExternalStorageDirectory(), filename);

        if(imgFile.exists()){

            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            //myBitmap = RotateBitmap(myBitmap, 90);
            ImageView myImage = (ImageView) findViewById(R.id.imageView3);

            myImage.setImageBitmap(myBitmap);

            ProcessImage(myBitmap);

        }
        else {
            Log.d("Error", filename);
        }

        Button somebtn = (Button) findViewById(R.id.button);
        somebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Camera_Filter.this, ChooseCategory.class);
                intent.putExtra("FILENAME", Camera_Filter.filename);
                startActivity(intent);
                finish();
            }
        });


    }
    public static Bitmap RotateBitmap(Bitmap source, float angle)
    {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
    }
    public void ProcessImage(Bitmap b){

        Mat tmp = new Mat (b.getWidth(), b.getHeight(), CvType.CV_8UC1);
        Utils.bitmapToMat(b, tmp);
        Mat original = tmp.clone();
        Imgproc.cvtColor(tmp, tmp, Imgproc.COLOR_RGB2GRAY);
        Imgproc.GaussianBlur(tmp, tmp, new Size(5, 5), 0);
        Imgproc.cvtColor(tmp, tmp, Imgproc.COLOR_GRAY2RGB, 4);
        Mat src = new Mat();
        Imgproc.Canny(tmp, src, 10, 120);
        Mat kernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new  Size(5, 5));
        Imgproc.dilate(src, src, kernel);
        Imgproc.dilate(src, src, kernel);
        Imgproc.dilate(src, src, kernel);

        List<MatOfPoint> contours = new ArrayList<MatOfPoint>();
        Imgproc.findContours(src.clone(), contours, new Mat(), Imgproc.RETR_EXTERNAL,Imgproc.CHAIN_APPROX_SIMPLE);
        int maxi = 0;
        for (int i = 0; i < contours.size(); i++){
            if (contourArea(contours.get(i)) > contourArea(contours.get(maxi))) {
                maxi = i;
            }
        }
        Mat mask = new Mat( new Size( src.cols(), src.rows() ), CvType.CV_8UC1 );
        mask.setTo( new Scalar( 0.0 ) );
        drawContours(mask, contours, maxi, new Scalar(255), -1);
        original.copyTo(src, mask);

        Utils.matToBitmap(src, b);
        ImageView myImage = (ImageView) findViewById(R.id.imageView3);
        myImage.setImageBitmap(b);
    }
}
