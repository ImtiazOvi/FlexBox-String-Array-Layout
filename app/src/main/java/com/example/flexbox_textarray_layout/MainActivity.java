package com.example.flexbox_textarray_layout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;
    // This is the text that will be rendered in the screen.
    private String textArr[] = {"Lorem", "Ipsum", "is", "simply", "there are", "dummy", "text of the printing","and","typesetting industry"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("FlexboxLayout StringArrayExample");


        recyclerView = findViewById(R.id.recycler_view);

        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(MainActivity.this);
        layoutManager.setFlexDirection(FlexDirection.ROW_REVERSE);
        layoutManager.setJustifyContent(JustifyContent.FLEX_END);
        recyclerView.setLayoutManager(layoutManager);


//        // Set adapter object.
        adapter= new RecyclerViewAdapter(this.modelArrayList());
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<Model> modelArrayList() {
        ArrayList<Model> ret = new ArrayList<Model>();

        for (int i = 0; i < this.textArr.length; i++) {
            Model model = new Model();
            model.setText(this.textArr[i]);

            ret.add(model);
        }
        return ret;
    }
}
