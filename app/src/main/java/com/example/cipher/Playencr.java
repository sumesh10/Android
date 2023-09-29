package com.example.cipher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Playencr extends AppCompatActivity {
    EditText e1,e2;
    TextView res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playencr);
        e1=(EditText) findViewById(R.id.e1);
        e2=(EditText) findViewById(R.id.e2);
        res=(TextView) findViewById(R.id.res);
    }
    public void getResult(View v){
        String s2=e1.getText().toString();
        String key=e2.getText().toString();
        key=key.toUpperCase();

        String s1="";
        int i,p=0;
        for(i=0;i<s2.length();i++){
            if(s2.charAt(i)==' '){
                continue;
            }
            else{
                s1=s1+s2.charAt(i);
            }
        }
        StringBuilder sb = new StringBuilder(s1);
        int originalLength = sb.length();
        for (i = 0; i < originalLength; i = i + 2) {
            if (i + 1 >= sb.length()) {
                break;
            }
            if (sb.charAt(i + 1) == '0') {
                break;
            }
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                sb.insert(i + 1, 'X');
                originalLength++;
                if (sb.length() % 2 == 1) {
                    sb.insert(originalLength, '0');
                    p++;
                }
            }
        }
        int len = sb.length() - p;
        sb.setLength(len);
        s1 = String.valueOf(sb);
        if (s1.length() % 2 != 0) {
            s1 += 'x';
        }
        s1=s1.toUpperCase();
        // System.out.println(s1 + " length is " );
//        System.out.println(s1);
        int a,b;
        int m=5,n=5;
        char[][] mat=new char[m][n];

        char c='A';
        int k=0;
        for(a=0;a<m;a++){
            for(b=0;b<n;b++){
                if(k<key.length()){
                    mat[a][b]=key.charAt(k++);
                }
                else{
                    if(c=='Z'){
                        break;
                    }
                    if(c=='J')
                    {
                        c++;
                    }
                    while((key.contains(Character.toString(c)))==true){
                        c++;
                    }

                    mat[a][b]=c;
                    c++;

                }
            }

        }

//        for(a=0;a<m;a++) {
//            for (b = 0; b < n; b++) {
//                System.out.print(mat[a][b] + " ");
//
//            }
//            System.out.println();
//        }
        String encrypted="";
        for (int l = 0; l < s1.length(); l = l + 2) {
            String substr = s1.substring(l, l + 2);
            int el1 = substr.charAt(0);
            int el2 = substr.charAt(1);
            int row1 = 0, col1 = 0, row2 = 0, col2 = 0;
            System.out.println((char) el1 + " " + (char) el2);
            for (int t = 0; t < 5; t++) {
                for (int u = 0; u < 5; u++) {
                    if (mat[t][u] == el1) {
                        row1 = t;
                        col1 = u;
                    }
                }
            }
            for (int q = 0; q < 5; q++) {
                for (int w = 0; w < 5; w++) {
                    if (mat[q][w] == el2) {
                        row2 = q;
                        col2 = w;
                    }
                }
            }
            System.out.println(row1 + "," + col1 + "   " + row2 + "," + col2);
            if (row1 == row2) {
                col1=(col1+1)%5;
                col2=(col2+1)%5;
            }
            if (col1 == col2) {
                row1=(row1+1)%5;
                row2=(row2+1)%5;
            }
            else if(row1!=row2 &&col1!=col2){
                int temp=col1;
                col1=col2;
                col2=temp;


            }
            encrypted=encrypted+mat[row1][col1]+mat[row2][col2];


        }
        System.out.println(encrypted);
        res.setText("Cipher text: "+encrypted);

    }
    public void onback(View v){
        Intent intent=new Intent(Playencr.this,Playfair.class);
        startActivity(intent);
    }
}