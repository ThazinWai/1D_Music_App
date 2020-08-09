package com.example.learnjp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class TabLayoutAvtivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_avtivity);


        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        viewPager=findViewById(R.id.viewpagerId);
        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new OneFragment(),"Playlist");
        adapter.addFragment(new TwoFragment(),"My Favourites");
        adapter.addFragment(new ThreeFragment(),"All Songs");

        viewPager.setAdapter(adapter);

        tabLayout=findViewById(R.id.tablayoutId);
        tabLayout.setupWithViewPager(viewPager);


    }
}
