package com.example.android.weekendproject1;

import android.support.annotation.LayoutRes;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class DrawerMenu extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout drawerLayout;
    private ListView listView;

    protected void onCreateDrawer() {

       // setContentView(R.layout.activity_drawer_menu);
        drawerLayout = (DrawerLayout) findViewById(R.id.loDrawerLayout);
        listView = (ListView) findViewById(R.id.lvMenus);
        listView.setOnClickListener(this);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        onCreateDrawer();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case 1:
                break;
        }
    }
}

