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
    Button button;
    Button button_Category;
    static final int CAM_REQUEST = 1;
    public static String imageName;
    String filename;
    @Override
    protected void onCreate(Bundle savedInstanceBundle){
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button_Capture);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                filename = "fname_" + String.valueOf(System.currentTimeMillis()) + ".jpg";
                Uri imageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), filename));
                intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(intent, 0);
            }
        });


    }

    private File getFlie(){
        File folder = new File("sdcard/camera_app");

        if(!folder.exists()){
            folder.mkdir();
        }
        imageName = String.valueOf(System.currentTimeMillis())+".jpg";
        File image_file = new File(folder, imageName);
        return image_file;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == 0 && resultCode == RESULT_OK){
            Intent intent = new Intent(this, chooseCategory.class);
            intent.putExtra("FILENAME", filename);
            startActivity(intent);
        }
    }

}
