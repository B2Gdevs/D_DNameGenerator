package com.bensquared.epicnamegenerator;


import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout1);
        toolbar = (Toolbar) findViewById(R.id.app_bar);

        Typeface appBarFont = Typeface.createFromAsset(getAssets(), "IMMORTAL.ttf");
        TextView toolBarTitle = (TextView) findViewById(R.id.textViewToolBar);
        toolBarTitle.setTypeface(appBarFont);

        ViewPager viewPager = (ViewPager) findViewById(R.id.Viewpager);


        setSupportActionBar(toolbar);

        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(new SimpleFragmentPageAdapter(getSupportFragmentManager()));

        changeTabsFont(appBarFont);
        viewPager.setOffscreenPageLimit(4);


    }

    private void changeTabsFont(Typeface appBarFont) {

        ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
            int tabChildsCount = vgTab.getChildCount();
            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    ((TextView) tabViewChild).setTypeface(appBarFont);
                    ((TextView) tabViewChild).setTextSize(9);
                }
            }
        }


    }
}
