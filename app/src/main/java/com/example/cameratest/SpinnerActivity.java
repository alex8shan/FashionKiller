package com.example.cameratest;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpinnerActivity extends AppCompatActivity {

    Button confirm;
    Spinner spinner1;
    Spinner spinner2;
    static String [] array1;
    static String [] array2;
    FileInputStream fis;
    Scanner input;
    String imageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        confirm = (Button) findViewById(R.id.confirm);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(spinner1.getSelectedItem().equals(spinner2.getSelectedItem()))
                {
                    //WARN THE USER TO RESELECT!!!
                } else if(spinner1.getSelectedItem().equals(null)||spinner2.getSelectedItem().equals(null)){
                    //WARN THE USER TO RESELECT!!!
                } else {
                    //LET THE PARTY BEGIN!!!!!!
                    if(spinner1.getSelectedItem().equals("short shirts")){
                        //get 1.txt
                        try {
                            input = new Scanner(new FileInputStream(new File(Environment.getExternalStorageDirectory(), "1.txt"))) ;
                            int lineCount = 0;
                            while(input.hasNextLine())
                            {
                                imageName = input.nextLine();
                                lineCount++;
                            }
                            array1 = new String [lineCount];
                            lineCount = 0;
                            //reset Scanner
                            input.reset();
                            while(input.hasNextLine())
                            {
                                array1[lineCount] = input.nextLine();
                                lineCount++;
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if(spinner1.getSelectedItem().equals("long shirts")){
                        //get 2.txt
                        try {
                            input = new Scanner(new FileInputStream(new File(Environment.getExternalStorageDirectory(), "2.txt"))) ;
                            int lineCount = 0;
                            while(input.hasNextLine())
                            {
                                imageName = input.nextLine();
                                lineCount++;
                            }
                            array1 = new String [lineCount];
                            lineCount = 0;
                            //reset Scanner
                            input.reset();
                            while(input.hasNextLine())
                            {
                                array1[lineCount] = input.nextLine();
                                lineCount++;
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if(spinner1.getSelectedItem().equals("shorts")){
                        //get 3.txt
                        try {
                            input = new Scanner(new FileInputStream(new File(Environment.getExternalStorageDirectory(), "3.txt"))) ;
                            int lineCount = 0;
                            while(input.hasNextLine())
                            {
                                imageName = input.nextLine();
                                lineCount++;
                            }
                            array1 = new String [lineCount];
                            lineCount = 0;
                            //reset Scanner
                            input.reset();
                            while(input.hasNextLine())
                            {
                                array1[lineCount] = input.nextLine();
                                lineCount++;
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if(spinner1.getSelectedItem().equals("pants")){
                        //get 4.txt
                        try {
                            input = new Scanner(new FileInputStream(new File(Environment.getExternalStorageDirectory(), "4.txt"))) ;
                            int lineCount = 0;
                            while(input.hasNextLine())
                            {
                                imageName = input.nextLine();
                                lineCount++;
                            }
                            array1 = new String [lineCount];
                            lineCount = 0;
                            //reset Scanner
                            input.reset();
                            while(input.hasNextLine())
                            {
                                array1[lineCount] = input.nextLine();
                                lineCount++;
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    //TIME FOR SPINNER 2

                    if(spinner2.getSelectedItem().equals("short shirts")){
                        //get 1.txt
                        try {
                            input = new Scanner(new FileInputStream(new File(Environment.getExternalStorageDirectory(), "1.txt"))) ;
                            int lineCount = 0;
                            while(input.hasNextLine())
                            {
                                imageName = input.nextLine();
                                lineCount++;
                            }
                            array2 = new String [lineCount];
                            lineCount = 0;
                            //reset Scanner
                            input.reset();
                            while(input.hasNextLine())
                            {
                                array2[lineCount] = input.nextLine();
                                lineCount++;
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if(spinner2.getSelectedItem().equals("long shirts")){
                        //get 2.txt
                        try {
                            input = new Scanner(new FileInputStream(new File(Environment.getExternalStorageDirectory(), "2.txt"))) ;
                            int lineCount = 0;
                            while(input.hasNextLine())
                            {
                                imageName = input.nextLine();
                                lineCount++;
                            }
                            array2 = new String [lineCount];
                            lineCount = 0;
                            //reset Scanner
                            input.reset();
                            while(input.hasNextLine())
                            {
                                array2[lineCount] = input.nextLine();
                                lineCount++;
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if(spinner2.getSelectedItem().equals("shorts")){
                        //get 3.txt
                        try {
                            input = new Scanner(new FileInputStream(new File(Environment.getExternalStorageDirectory(), "3.txt"))) ;
                            int lineCount = 0;
                            while(input.hasNextLine())
                            {
                                imageName = input.nextLine();
                                lineCount++;
                            }
                            array2 = new String [lineCount];
                            lineCount = 0;
                            //reset Scanner
                            input.reset();
                            while(input.hasNextLine())
                            {
                                array2[lineCount] = input.nextLine();
                                lineCount++;
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if(spinner2.getSelectedItem().equals("pants")){
                        //get 4.txt
                        try {
                            input = new Scanner(new FileInputStream(new File(Environment.getExternalStorageDirectory(), "4.txt"))) ;
                            int lineCount = 0;
                            while(input.hasNextLine())
                            {
                                imageName = input.nextLine();
                                lineCount++;
                            }
                            array2 = new String [lineCount];
                            lineCount = 0;
                            //reset Scanner
                            input.reset();
                            while(input.hasNextLine())
                            {
                                array2[lineCount] = input.nextLine();
                                lineCount++;
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    //intention that jumps to showDress
                    Intent showDress = new Intent(v.getContext(), ShowDress.class);
                    startActivity(showDress);
                }
            }
        });
    }
}
