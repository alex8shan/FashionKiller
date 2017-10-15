package com.example.cameratest;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    Button button_Capture;
    Button button_Dress;
    static final int CAM_REQUEST = 1;
    public static String imageName;
    @Override
    protected void onCreate(Bundle savedInstanceBundle){
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.activity_main);
        button_Capture = (Button) findViewById(R.id.longshirt);
        button_Dress = (Button) findViewById(R.id.button_Dress);
        button_Capture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                imageName = String.valueOf(System.currentTimeMillis()) + ".jpg";
                //create the image at the root folder
                Uri imageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), imageName));
                intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(intent, 0);
            }
        });
        button_Dress.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), SpinnerActivity.class);
                startActivity(intent);
            }
         });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == 0 && resultCode == RESULT_OK){
            Intent intent = new Intent(this, ChooseCategory.class);
            intent.putExtra("FILENAME", imageName);
            startActivity(intent);
        }
    }

}
