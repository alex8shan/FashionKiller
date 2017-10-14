package com.example.cameratest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//This activity will let the user choose the categories of cloth.
public class chooseCat extends AppCompatActivity {
    Button setShirt;
    Button setJacket;
    Button setPants;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosecat);

        //set shirt

        //Something here is wrong!!

        setShirt = (Button) findViewById(R.id.setShirt);
        setShirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imagePrefix = "Shirt";
                Toast.makeText(getApplicationContext(), "Shirt is saved!", Toast.LENGTH_SHORT);
                //we need to pass this shit to save the pictures
            }
        });
        //set Jacket

        //set Pants
    }

}
