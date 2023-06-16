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
        Button b;
        CardView cardView;
        cardView=(CardView)findViewById(R.id.c1);
        b=(Button) findViewById(R.id.back);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Ceasarpg.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void gotoencrypt(View v){
        CardView cardView;
        cardView=(CardView)findViewById(R.id.c1);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Ceasarpg.this,encrypt1.class);
                startActivity(intent);
            }
        });

    }
    public void gotodecrypt(View v){
        CardView cardView;
        cardView=(CardView)findViewById(R.id.c2);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Ceasarpg.this,decrypt1.class);
                startActivity(intent);
            }
        });
    }
}