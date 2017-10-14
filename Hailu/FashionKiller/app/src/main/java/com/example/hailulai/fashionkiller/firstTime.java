package com.example.hailulai.fashionkiller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class firstTime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_time);
    }
    public void btnClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
