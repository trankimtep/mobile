package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//    StudentHelper studentHelper;
    Button btnDanhSachSinhVien, btnDanhSachLop, btnThemSinhVien, btnThemLop, btnThemSinhVienVaoLop;
    ClassHelper classHelper;
    StudentHelper studentHelper;
    Student_ClassHelper student_classHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDanhSachSinhVien = (Button) findViewById(R.id.btnDanhSachSinhVien);
        btnDanhSachLop = (Button) findViewById(R.id.btnDanhSachLop);
        btnThemSinhVien = (Button) findViewById(R.id.btnThemSinhVien);
        btnThemLop = (Button) findViewById(R.id.btnThemLop);
        btnThemSinhVienVaoLop = (Button) findViewById(R.id.btnThemSinhVienVaoLop);

        classHelper = new ClassHelper(this);
        studentHelper = new StudentHelper(this, "crtstudent.sqlite", null, 1);
        student_classHelper = new Student_ClassHelper(this, "crtstudentclass.sqlite", null, 1);

        classHelper.queryData("CREATE TABLE IF NOT EXISTS Class(id INTEGER PRIMARY KEY AUTOINCREMENT, Name VARCHAR(50), Des VARCHAR(100)) ");
        studentHelper.queryData("CREATE TABLE IF NOT EXISTS Student(id INTEGER PRIMARY KEY AUTOINCREMENT, Name VARCHAR(50), YoB INTEGER, Addr VARCHAR(50), Year INTEGER) ");
        student_classHelper.queryData("CREATE TABLE IF NOT EXISTS StudentClasses (\n" +
                "  student_id INTEGER,\n" +
                "  class_id INTEGER,\n" +
                "  semester INTEGER,\n" +
                "  credit INTEGER,\n" +
                "  FOREIGN KEY (student_id) REFERENCES Student(id),\n" +
                "  FOREIGN KEY (class_id) REFERENCES Classe(id),\n" +
                "  PRIMARY KEY (student_id, class_id)\n" +
                ");\n");

        btnDanhSachSinhVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DanhSachSinhVien.class);
                startActivity(intent);
            }
        });

        btnDanhSachLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DanhSachLop.class);
                startActivity(intent);
            }
        });

        btnThemSinhVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThemSinhVienAct.class);
                startActivity(intent);
            }
        });

        btnThemLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThemLopAct.class);
                startActivity(intent);
            }
        });

        btnThemSinhVienVaoLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThemSinhVienVaoLopAct.class);
                startActivity(intent);
            }
        });




//
//        Cursor dataStudent = studentHelper.GetData("SELECT * FROM Student");
//        while (dataStudent.moveToNext()){
//            String name = dataStudent.getString(1);
//            Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
//        }
    }



}