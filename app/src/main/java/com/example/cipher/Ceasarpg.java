package com.example.cipher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ceasarpg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ceasarpg);
    }
    public void back(View v){
        Intent intent=new Intent(Ceasarpg.this,MainActivity.class);
        startActivity(intent);
    }
    public void gotoencrypt(View v){
        Intent intent=new Intent(Ceasarpg.this,encrypt1.class);
        startActivity(intent);

    }
    public void gotodecrypt(View v){
        Intent intent=new Intent(Ceasarpg.this,decrypt1.class);
        startActivity(intent);
    }
}