package com.dev.sectionedrv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvMain = (RecyclerView) findViewById(R.id.rv_main);
        SimpleSectionedListAdapter adapter = new SectionedListAdapter(createList());
        rvMain.setLayoutManager(new LinearLayoutManager(this));
        rvMain.setAdapter(adapter);
    }

    private List<SectionedData> createList() {
        List<SectionedData> list = new ArrayList<>();

        list.add(new SectionedData("Family", createModelList()));
        list.add(new SectionedData("Friends", createModelList2()));
        list.add(new SectionedData("Others", createModelList3()));
        return list;
    }

    private List<Model> createModelList3() {
        List<Model> list = new ArrayList<>();
        list.add(new Model("Aniket Choudhary", 35, ""));
        list.add(new Model("Pankaj Sharma", 22, ""));
        list.add(new Model("Sachin Mathur", 21, ""));
        return list;
    }

    private List<Model> createModelList2() {
        List<Model> list = new ArrayList<>();
        list.add(new Model("Mitesh Kumar Savita Mitesh Kumar Savita", 25, ""));
        list.add(new Model("Rajat Paliwal", 31, ""));
        return list;
    }

    private List<Model> createModelList() {
        List<Model> list = new ArrayList<>();
        list.add(new Model("Gaurav Jain", 30, ""));
        list.add(new Model("Ankit Jain", 28, ""));
        list.add(new Model("Rajat Jain", 25, ""));
        return list;
    }
}
