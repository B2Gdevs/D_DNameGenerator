package com.bensquared.epicnamegenerator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import layout.Generate;
import layout.saved;


/**
 * Created by scrubster on 12/20/2016.
 */

public class SimpleFragmentPageAdapter extends FragmentPagerAdapter {

    private String[] tabTitle = new String[]{"Generate", "Saved Names", "Donate Please", "About"};


    public SimpleFragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch(position)
        {
            case 0: return new Generate();
            case 1: return new saved();
            case 2: return new unlockFeatures();
            case 3: return new settings();
            default: return null;
        }

    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle[position];
    }


    }
