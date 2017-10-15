package com.example.cameratest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends Activity {
    Button takePic;
    Button showDress;
    ImageView imageView;
    static final int CAM_REQUEST = 1;
    public static String imageName;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        takePic = (Button) findViewById(R.id.button_capture);
        imageView = (ImageView) findViewById(R.id.imageView);
        takePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getFlie();

                camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(camera_intent, CAM_REQUEST);
            }
        });

        showDress = (Button)findViewById(R.id.showDress);
        showDress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showDress = new Intent(v.getContext(), ShowDress.class);
            }
        });
    }

    private File getFlie() {
        File folder = new File("sdcard/fashion_killer");
        if (!folder.exists()) {
            folder.mkdir();
        }
        imageName = String.valueOf(System.currentTimeMillis())+".jpg";
        File image_file = new File(folder, imageName);
        return image_file;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent){
        Intent chooseCategory = new Intent(imageView.getContext(), ChooseCat.class);
        startActivity(chooseCategory);
    }




}
