package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ThemLopAct extends AppCompatActivity {

    EditText ten, mota;
    Button btnThemLop;
    ClassHelper classHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_lop);

        ten = (EditText) findViewById(R.id.tenLop);
        mota = (EditText) findViewById(R.id.moTaLop);
        btnThemLop = (Button) findViewById(R.id.btnThemLop);
        classHelper = new ClassHelper(this);
        btnThemLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = String.valueOf(ten.getText());
                String des = String.valueOf(mota.getText());
                if (TextUtils.isEmpty(name)){
                    Toast.makeText(ThemLopAct.this, "Vui long nhap ten lop", Toast.LENGTH_SHORT).show();
                    return;
                }

//                classHelper.queryData("CREATE TABLE IF NOT EXISTS Class(id INTEGER PRIMARY KEY AUTOINCREMENT, Name VARCHAR(50), Des VARCHAR(100)) ");
                classHelper.queryData("INSERT INTO Class VALUES (null, '"+name+"', '"+des+"')");
                Toast.makeText(ThemLopAct.this, "Them lop thanh cong", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ThemLopAct.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}