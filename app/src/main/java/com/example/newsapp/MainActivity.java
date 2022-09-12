package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
     TabLayout tabLayout;
     TabItem  mhome, mscience , mtech , menter , mhealth , msports;
     PagerAdapter pagerAdapter;
     androidx.appcompat.widget.Toolbar mtoolbar;
     String api ="a37611e4a3484864adb46d90add23a66";
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtoolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);

        mhome = findViewById(R.id.home);
        mtech =findViewById(R.id.technology);
        msports = findViewById(R.id.sports);
        mscience = findViewById(R.id.science);
        mhealth =findViewById(R.id.health);
        menter = findViewById(R.id.entertainment);
        ViewPager viewPager =findViewById(R.id.fragmentcontainer);
        tabLayout = findViewById(R.id.include);

       pagerAdapter = new PagerAdapter(getSupportFragmentManager(),6);
       viewPager.setAdapter(pagerAdapter);

       tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
           @Override
           public void onTabSelected(TabLayout.Tab tab) {
               viewPager.setCurrentItem(tab.getPosition());
               if(tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||tab.getPosition()==3||tab.getPosition()==4||tab.getPosition()==5){
                   pagerAdapter.notifyDataSetChanged();
               }
           }

           @Override
           public void onTabUnselected(TabLayout.Tab tab) {

           }

           @Override
           public void onTabReselected(TabLayout.Tab tab) {

           }
       });

       viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }
}