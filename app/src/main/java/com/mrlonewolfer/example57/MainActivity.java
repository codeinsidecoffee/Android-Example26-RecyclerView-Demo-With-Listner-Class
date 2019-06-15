package com.mrlonewolfer.example57;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TextView;


import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    Toolbar toolbar;
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        viewPager =findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout=findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setTabIcons();

    }


    private void setTabIcons() {
        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab,null);
        tabOne.setText("One");
        tabOne.setCompoundDrawablesRelativeWithIntrinsicBounds(0,R.drawable.ic_action_one,0,0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab,null);
        tabTwo.setText("Two");
        tabTwo.setCompoundDrawablesRelativeWithIntrinsicBounds(0,R.drawable.ic_action_two,0,0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab,null);
        tabThree.setText("Three");
        tabThree.setCompoundDrawablesRelativeWithIntrinsicBounds(0,R.drawable.ic_action_three,0,0);
        tabLayout.getTabAt(2).setCustomView(tabThree);


    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter viewPagerAdapter= new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFrag(new FirstFragment(),"ONE");
        viewPagerAdapter.addFrag(new SecondFragment(),"Two");
        viewPagerAdapter.addFrag(new ThirdFragment(),"Three");
        viewPager.setAdapter(viewPagerAdapter);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {
       private final List<Fragment> mFragmentList=new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragmentName, String fragmentTitle) {
        mFragmentList.add(fragmentName);
        mFragmentTitleList.add(fragmentTitle);

        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
