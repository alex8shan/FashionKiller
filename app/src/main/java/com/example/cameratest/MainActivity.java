package com.example.cameratest;

import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.provider.MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE;
import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

    String filename;
    @Override
    protected void onCreate(Bundle savedInstanceBundle){
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        filename = "fname_" + String.valueOf(System.currentTimeMillis()) + ".jpg";
        Uri imageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), filename));
        intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, imageUri);
        startActivityForResult(intent, 0);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == 0 && resultCode == RESULT_OK){
            Intent intent = new Intent(this, second.class);
            intent.putExtra("FILENAME", filename);
            startActivity(intent);
        }
    }

}
