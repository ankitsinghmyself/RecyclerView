package com.ankit.recyclerview2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Context mContext = MainActivity.this;

    private int[] images = {R.drawable.python,R.drawable.android,R.drawable.java};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView list = findViewById(R.id.langList);
        list.setLayoutManager(new GridLayoutManager(this,2));

        String[] lan = {"Python", "Android","Java"};
        list.setAdapter(new Adpter(images,lan));

    }
}
