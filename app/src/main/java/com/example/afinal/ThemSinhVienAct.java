package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ThemSinhVienAct extends AppCompatActivity {

    StudentHelper studentHelper;
    EditText edtTen, edtNamSinh, edtQue, edtNamHoc;
    Button btnthem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_sinh_vien);

        edtTen = (EditText) findViewById(R.id.addStdName);
        edtNamSinh = (EditText) findViewById(R.id.addStdYoB);
        edtQue = (EditText) findViewById(R.id.addStdAddr);
        edtNamHoc = (EditText) findViewById(R.id.addStdYear);
        btnthem = (Button) findViewById(R.id.addStd) ;

        studentHelper = new StudentHelper(this, "student.sqlite", null, 1);
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = String.valueOf(edtTen.getText());
                int yob = Integer.parseInt(String.valueOf(edtNamSinh.getText()));
                String addr = String.valueOf(edtQue.getText());
                int year = Integer.parseInt(String.valueOf(edtNamHoc.getText()));

                if (TextUtils.isEmpty(name)){
                    Toast.makeText(ThemSinhVienAct.this, "Vui long dien ten", Toast.LENGTH_SHORT).show();
                    return;
                }

                Student student = new Student(name, yob, addr, year);

//                studentHelper.queryData("CREATE TABLE IF NOT EXISTS Student(id INTEGER PRIMARY KEY AUTOINCREMENT, Name VARCHAR(50), YoB INTEGER, Addr VARCHAR(50), Year INTEGER) ");
                //studentHelper.queryData("DROP TABLE Student");
                studentHelper.queryData("INSERT INTO Student VALUES ("+""+student.id+", '"+student.name+"', "+""+student.yob+", '"+student.addr+"', "+""+student.year+")");

                Toast.makeText(ThemSinhVienAct.this, "Them sinh vien thanh cong", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ThemSinhVienAct.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }



}