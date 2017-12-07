package com.example.acer.labquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText edit_user;
    EditText edit_pass;
    Button btn_out;
    Button btn_log;
    ImageView img1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_user = findViewById(R.id.edit_user);
        edit_pass = findViewById(R.id.edit_pass);
        btn_out = findViewById(R.id.btn_out);
        btn_log = findViewById(R.id.btn_log);
        img1 = findViewById(R.id.img1);

        edit_user.setOnKeyListener(new EditText.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                String user = preferences.getString("username","");
                String pass = preferences.getString("password","");

                String sUsername = edit_user.getText().toString();

                if(!user.isEmpty()) {
                    if (sUsername.equals(user)) {
                        edit_pass.setText(pass);
                        edit_pass.setBackgroundColor(Color.YELLOW);
                    }
                    else if (!(sUsername.equals(user))){
                        edit_pass.setText("");
                        edit_pass.setBackgroundColor(Color.TRANSPARENT);
                    }
                }

                return false;
            }
        });

        edit_pass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    String user = preferences.getString("username","");
                    String pass = preferences.getString("password","");

                    String sUsername = edit_user.getText().toString();

                    if(!user.isEmpty()) {
                        if (sUsername.equals(user)) {
                            edit_pass.setText(pass);
                            edit_pass.setBackgroundColor(Color.YELLOW);
                        }
                        else if (!(sUsername.equals(user))){
                            edit_pass.setText("");
                            edit_pass.setBackgroundColor(Color.TRANSPARENT);
                        }
                    }

                }
            }
        });
    }

    public void rememberMe (View view){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", edit_user.getText().toString());
        editor.putString("password", edit_pass.getText().toString());
        editor.commit();
        Toast.makeText(this, "Preference Saved!", Toast.LENGTH_SHORT).show();

    }

    public void login (View view){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }


}
