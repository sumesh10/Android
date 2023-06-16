package com.example.cipher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class encrypt1 extends AppCompatActivity {
    public static String alpha = "abcdefghijklmnopqrstuvwxyz";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypt1);



//        String res= "";
//        int i,pos,charpos;
//        char c;
//        for(i=0;i<str.length();i++){
//            pos=alpha.indexOf(str.charAt(i));
//            charpos=(key+pos)%26;
//            c=alpha.charAt(charpos);
//            res=res+c;
//        }




    }
    public void goback(View v){
        Button b;
        CardView cardView;
        cardView=(CardView)findViewById(R.id.c1);
        b=(Button) findViewById(R.id.back);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(encrypt1.this,Ceasarpg.class);
                startActivity(intent);
            }
        });
    }
    public void getResult(View v){
        Button result;
        EditText e1,e2;
        TextView val;
        e1=(EditText) findViewById(R.id.et1);
        e2=(EditText) findViewById(R.id.et2);
        val=(TextView) findViewById(R.id.result);
        val.setText("");
        String str=e1.getText().toString().toLowerCase();
        int key=Integer.parseInt(e2.getText().toString().trim());
        result=(Button) findViewById(R.id.get);
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res= "";
                int i,pos,charpos;
                char c;
                for(i=0;i<str.length();i++){
                    char ch=' ';
                    if(str.charAt(i)==' '){
                        res=res+' ';
                        continue;
                    }
                    pos=alpha.indexOf(str.charAt(i));
                    charpos=(key+pos)%26;
                    c=alpha.charAt(charpos);
                    res=res+c;
                }
                val.setText("Cipher text:"+res);

            }
        });
    }

}