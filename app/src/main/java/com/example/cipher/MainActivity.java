package com.example.cipher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void ceasar(View v){
        Intent intent = new Intent(MainActivity.this,Ceasarpg.class);
        startActivity(intent);
    }
    public void onencrypt(View v) {
        Intent intent = new Intent(MainActivity.this, Playfair.class);
        startActivity(intent);
    }


}