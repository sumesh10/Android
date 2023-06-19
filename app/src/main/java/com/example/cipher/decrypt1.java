package com.example.cipher;

import static com.example.cipher.encrypt1.alpha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class decrypt1 extends AppCompatActivity {
    public static String alpha = "abcdefghijklmnopqrstuvwxyz";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrypt1);
    }
    public void goback(View v){
        Intent intent=new Intent(decrypt1.this,Ceasarpg.class);
        startActivity(intent);
    }
    public void getResult(View v){
        //Button result;
        EditText e1,e2;
        TextView val;
        e1=(EditText) findViewById(R.id.et1);
        e2=(EditText) findViewById(R.id.et2);
        val=(TextView) findViewById(R.id.result);
        val.setText("");
        String str=e1.getText().toString().toLowerCase();
        int key=Integer.parseInt(e2.getText().toString().trim());
        //result=(Button) findViewById(R.id.get);
        String res= "";
        int i,pos,charpos;
        char c;
        for(i=0;i<str.length();i++){
//      char ch=' ';
            if(str.charAt(i)==' '){
                res=res+' ';
                continue;
            }
            pos=alpha.indexOf(str.charAt(i));
            charpos=(pos-key)%26;
            if(charpos<0){
                charpos=alpha.length()+charpos;
            }
            c=alpha.charAt(charpos);
            res=res+c;
        }
        val.setText("Plain text:"+res);


    }
}