package com.example.acer.labquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity2 extends AppCompatActivity {

    TextView txt_wel;
    TextView txt_usr;
    Button btn_out;
    FileOutputStream fos;
    FileInputStream fis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    txt_wel = findViewById(R.id.txt_wel);
    txt_usr = findViewById(R.id.txt_usr);
    btn_out = findViewById(R.id.btn_out);

}
    public void btn_out (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }
}
