package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ThemSinhVienVaoLopAct extends AppCompatActivity {

    EditText maSV, maLop, kyHoc, tinChi;
    Button btnThemSinhVienVaoLop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_sinh_vien_vao_lop);

        maSV = (EditText) findViewById(R.id.regisStdId);
        maLop = (EditText) findViewById(R.id.regisClassId);
        kyHoc = (EditText) findViewById(R.id.regisSimester);
        tinChi = (EditText) findViewById(R.id.regisCredit);
        btnThemSinhVienVaoLop = (Button) findViewById(R.id.register);

        Student_ClassHelper student_classHelper = new Student_ClassHelper(ThemSinhVienVaoLopAct.this, "stdclas.sqlite", null, 1);

        btnThemSinhVienVaoLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stdId = String.valueOf(maSV.getText());
                String classid = String.valueOf(maLop.getText());
                String simester = String.valueOf(kyHoc.getText());
                String credit = String.valueOf(tinChi.getText());

                if(TextUtils.isEmpty(stdId) || TextUtils.isEmpty(classid)){
                    Toast.makeText(ThemSinhVienVaoLopAct.this, "Vui long dien du thong tin", Toast.LENGTH_SHORT).show();
                    return;
                }

//                student_classHelper.queryData("CREATE TABLE IF NOT EXISTS StudentClasses (\n" +
//                        "  student_id INTEGER,\n" +
//                        "  class_id INTEGER,\n" +
//                        "  semester INTEGER,\n" +
//                        "  credit INTEGER,\n" +
//                        "  FOREIGN KEY (student_id) REFERENCES Student(id),\n" +
//                        "  FOREIGN KEY (class_id) REFERENCES Classe(id),\n" +
//                        "  PRIMARY KEY (student_id, class_id)\n" +
//                        ");\n");

                student_classHelper.queryData("INSERT INTO StudentClasses (student_id, class_id, semester, credit) " +
                        "VALUES ('" + stdId + "', '" + classid + "', '" + simester + "', '" + credit + "')");

                Toast.makeText(ThemSinhVienVaoLopAct.this, "Them lop thanh cong", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ThemSinhVienVaoLopAct.this, MainActivity.class);
                startActivity(intent);

            }
        });

    }
}