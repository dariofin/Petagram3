package com.dariofinelli.petagram3;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.dariofinelli.petagram3.adapter.PageAdapter;
import com.dariofinelli.petagram3.fragment.MainFragment;
import com.dariofinelli.petagram3.fragment.PetData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar actionbBar;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionbBar = (Toolbar) findViewById(R.id.miActionBar);
        agregarFAB();

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();

        if (actionbBar != null) {
            setSupportActionBar(actionbBar);
        }

    }

    private ArrayList<Fragment> addFragments() {

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new MainFragment());
        fragments.add(new PetData());
        return fragments;

    }

    public void setUpViewPager() {

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), addFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_pets);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_pet_data);
    }

    public void agregarFAB() {

        FloatingActionButton flButton = (FloatingActionButton) findViewById(R.id.flButton);
        flButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.favoritePets:
                Intent intent = new Intent(this, FavoritePets.class);
                startActivity(intent);
                break;
            case R.id.mContact:
                Intent intentContact = new Intent(this, com.dariofinelli.petagram3.ContactInfo.class);
                startActivity(intentContact);
                break;
            case R.id.mAbout:
                Intent intentAbout = new Intent(this, AboutOf.class);
                startActivity(intentAbout);
                break;
        }
        return super.onOptionsItemSelected(item);

    }

}
