package com.example.cameratest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.*;

//This activity will let the user choose the categories of cloth.
public class chooseCat extends AppCompatActivity {
    Button setLongPants = (Button) findViewById(R.id.setLongPants);
    Button setShortPants = (Button) findViewById(R.id.setShortPants);
    Button setLongShirts = (Button) findViewById(R.id.setShortShirts);
    Button setShortShirts = (Button) findViewById(R.id.setShortShirts);

    //create file directorys for four categories

    File longShirtDir = new File("sdcard/fashion_killer/long_shirt");
    File shortPantsDir = new File("sdcard/fashion_killer/short_pants");
    File shortShirtDir = new File("sdcard/fashion_killer/short_shirt");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosecat);

        //set short cloths

        setLongPants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create Dir
                File longPantsDir = new File("sdcard/fashion_killer/long_pants");
                moveFiles(longPantsDir, MainActivity.imageName);
                Toast.makeText(getApplicationContext(), "Long Pants is moved!", Toast.LENGTH_SHORT);
                //we need to pass this shit to save the pictures
            }
        });
        //set Jacket

        //set Pants

        //move files
    }
    public void moveFiles(File fileDir, String image) {
        //if directory does exists, create it. Otherwise open it.
            if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        //create file input &Output Stream
        try {
            FileInputStream in = new FileInputStream("sdcard/fashion_killer" + image);
            FileOutputStream out = new FileOutputStream(fileDir);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
