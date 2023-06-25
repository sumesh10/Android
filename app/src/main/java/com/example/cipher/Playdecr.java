package com.example.cipher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Playdecr extends AppCompatActivity {
    EditText e1, e2;
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playdecr);
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        res = findViewById(R.id.res);
    }

    public void getResult(View v) {
        String s2 = e1.getText().toString();
        String key = e2.getText().toString().toUpperCase();

        String s1 = s2.replaceAll(" ", "");
        StringBuilder sb = new StringBuilder(s1);

        int originalLength = sb.length();
        for (int i = 0; i < originalLength; i += 2) {
            if (i + 1 >= sb.length() || sb.charAt(i + 1) == '0') {
                break;
            }
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                sb.insert(i + 1, 'X');
                originalLength++;
                if (sb.length() % 2 == 1) {
                    sb.append('0');
                }
            }
        }

        int len = sb.length() - (sb.length() % 2 == 1 ? 1 : 0);
        sb.setLength(len);
        s1 = sb.toString().toUpperCase();

        int m = 5, n = 5;
        char[][] mat = new char[m][n];
        char c = 'A';
        int k = 0;

        for (int a = 0; a < m; a++) {
            for (int b = 0; b < n; b++) {
                if (k < key.length()) {
                    mat[a][b] = key.charAt(k++);
                } else {
                    if (c == 'Z') {
                        break;
                    }
                    if (c == 'J') {
                        c++;
                    }
                    while (key.contains(Character.toString(c))) {
                        c++;
                    }
                    mat[a][b] = c++;
                }
            }
        }

        StringBuilder encrypted = new StringBuilder();
        for (int l = 0; l < s1.length(); l += 2) {
            String substr = s1.substring(l, l + 2);
            int el1 = substr.charAt(0);
            int el2 = substr.charAt(1);
            int row1 = 0, col1 = 0, row2 = 0, col2 = 0;

            for (int t = 0; t < 5; t++) {
                for (int u = 0; u < 5; u++) {
                    if (mat[t][u] == el1) {
                        row1 = t;
                        col1 = u;
                    }
                    if (mat[t][u] == el2) {
                        row2 = t;
                        col2 = u;
                    }
                }
            }

            if (row1 == row2) {
                col1 = (col1 - 1 + 5) % 5;
                col2 = (col2 - 1 + 5) % 5;
                encrypted.append(mat[row1][col1]).append(mat[row2][col2]);
            } else if (col1 == col2) {
                row1 = (row1 - 1 + 5) % 5;
                row2 = (row2 - 1 + 5) % 5;
                encrypted.append(mat[row1][col1]).append(mat[row2][col2]);
            } else {
                int temp = col1;
                col1 = col2;
                col2 = temp;
                encrypted.append(mat[row1][col1]).append(mat[row2][col2]);
            }
        }

        String result = encrypted.toString().replace("X", "");
        res.setText("Plain text: " + result);
    }

    public void onback(View v) {
        Intent intent = new Intent(Playdecr.this, Playfair.class);
        startActivity(intent);
    }
}
