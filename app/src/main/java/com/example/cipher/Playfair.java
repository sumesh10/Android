package com.example.cipher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Playfair extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playfair);

    }
    public void onencrypt(View v) {
        Intent intent = new Intent(Playfair.this, Playencr.class);
        startActivity(intent);
    }
    public void ondecrypt(View v) {
        Intent intent = new Intent(Playfair.this, Playdecr.class);
        startActivity(intent);
    }
    public void goback(View v){
        Intent intent=new Intent(Playfair.this,MainActivity.class);
        startActivity(intent);
    }
}