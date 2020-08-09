package com.example.learnjp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class SecondActivity extends AppCompatActivity {


    Toolbar toolbar;
    ViewPager viewPager;
    SlideShowAdapter adapter;
    CircleIndicator indicator;

    Handler handler;
    Runnable runnable;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        viewPager=(ViewPager)findViewById(R.id.viewpager_id);

        indicator=(CircleIndicator) findViewById(R.id.circleindicator_id);

        adapter=new SlideShowAdapter(this);

        viewPager.setAdapter(adapter);

        indicator.setViewPager(viewPager);


        handler=new Handler();

        runnable=new Runnable() {
            @Override
            public void run() {

                int i=viewPager.getCurrentItem();

                if(i==adapter.image.length-1){
                    i=0;
                    viewPager.setCurrentItem(i,true);

                }

                else {
                    i++;
                    viewPager.setCurrentItem(i,true);
                }
            }
        };


        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                handler.post(runnable);
            }
        },1000,1000);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
