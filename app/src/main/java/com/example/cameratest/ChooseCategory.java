package com.example.cameratest;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class ChooseCategory extends AppCompatActivity {

    Button shortShirt;
    Button longShirt;
    Button shorts;
    Button pants;
    FileOutputStream fos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_category);
        shortShirt = (Button) findViewById(R.id.shortshirt);
        longShirt = (Button) findViewById(R.id.longshirt);
        shorts = (Button) findViewById(R.id.shorts);
        pants = (Button) findViewById(R.id.pants);
        shortShirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    fos = new FileOutputStream(new File(Environment.getExternalStorageDirectory(), "1.txt"),true);
                    fos.write((MainActivity.imageName + "\n").getBytes("UTF-8"));
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //destroy the activity
                finish();
            }
        });

        longShirt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try {
                    fos = new FileOutputStream(new File(Environment.getExternalStorageDirectory(), "2.txt"),true);
                    fos.write((MainActivity.imageName + "\n").getBytes("UTF-8"));
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //destroy the activity
                finish();
            }
        });

        shorts.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try {
                    fos = new FileOutputStream(new File(Environment.getExternalStorageDirectory(), "3.txt"),true);
                    fos.write((MainActivity.imageName + "\n").getBytes("UTF-8"));
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //destroy the activity
                finish();
            }
        });

        pants.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try {
                    fos = new FileOutputStream(new File(Environment.getExternalStorageDirectory(), "4.txt"),true);
                    fos.write((MainActivity.imageName + "\n").getBytes("UTF-8"));
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //destroy the activity
                finish();
            }
        });

    }



}
