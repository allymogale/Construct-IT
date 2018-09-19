package com.androidtutorialpoint.androidlogin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class ScrollingActivity extends AppCompatActivity {
    List<Design> design = new ArrayList<>();
    private RecyclerView recyclerView;
    private DesignAdapter pAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        pAdapter = new DesignAdapter(design,this);

        // Create grids with 1 item in a row
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(pAdapter);

        HouseSummary();
        pAdapter.notifyDataSetChanged();

    }

    private void HouseSummary() {
        Design design = new Design("kasi",R.drawable.plan1,"R440 000");
        this.design.add(design);
        design = new Design("kasi",R.drawable.plan2,"R365 000");
        this.design.add(design);
        design = new Design("kasi",R.drawable.plan3,"R365 000");
        this.design.add(design);
        design = new Design("kasi",R.drawable.plan4,"R365 000");
        this.design.add(design);
        design = new Design("kasi",R.drawable.plan11,"R440 000");
        this.design.add(design);
        design = new Design("kasi",R.drawable.plan22,"R440 000");
        this.design.add(design);
        design = new Design("kasi",R.drawable.plan33,"R525 000");
        this.design.add(design);
        design = new Design("kasi",R.drawable.plan44,"R525 000");
        this.design.add(design);
    }
}
