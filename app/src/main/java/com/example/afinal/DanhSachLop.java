package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DanhSachLop extends AppCompatActivity {
    private ListView listView;
    private Context context;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_lop);

        listView = (ListView) findViewById(R.id.dsLop) ;
        context = this;

//        ClassHelper classHelper = new ClassHelper(MainActivity.class, "ctrclass.sqlite", null, 1);
        ClassHelper classHelper = new ClassHelper(this);
        Cursor dataClass = classHelper.GetData("SELECT * FROM Class");

        ArrayList<String> clasList = new ArrayList<>();

        while (dataClass.moveToNext()){
            int id = Integer.parseInt(dataClass.getString(0));
            String name = dataClass.getString(1);
            String des = dataClass.getString(2);
            Clas clas = new Clas(id,name,des);
            clasList.add(clas.toString());
        }
        adapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, clasList);
        listView.setAdapter(adapter);
    }
}