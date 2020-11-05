package com.dariofinelli.petagram3.adapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class PageAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragmentArray;

    public PageAdapter(FragmentManager fm, ArrayList<Fragment> fragmentArray) {
        super(fm);
        this.fragmentArray = fragmentArray;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentArray.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArray.size();
    }
}
