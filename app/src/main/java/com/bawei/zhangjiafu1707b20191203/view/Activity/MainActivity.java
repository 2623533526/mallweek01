package com.bawei.zhangjiafu1707b20191203.view.Activity;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.widget.RadioGroup;

import com.bawei.zhangjiafu1707b20191203.R;
import com.bawei.zhangjiafu1707b20191203.base.BaseActivity;
import com.bawei.zhangjiafu1707b20191203.view.Fragment.Cart_Fragment;
import com.bawei.zhangjiafu1707b20191203.view.Fragment.Login_Fragment;
import com.bawei.zhangjiafu1707b20191203.view.Fragment.Other_Fragment;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {


    private ViewPager vp;
    private RadioGroup rg;

    @Override
    protected void initData() {
        Login_Fragment fragment_1 = new Login_Fragment();
        Other_Fragment fragment_2 = new Other_Fragment();
        Other_Fragment fragment_3 = new Other_Fragment();
        Cart_Fragment fragment_4 = new Cart_Fragment();
        Other_Fragment fragment_5 = new Other_Fragment();
        final ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(fragment_1);
        fragments.add(fragment_2);
        fragments.add(fragment_3);
        fragments.add(fragment_4);
        fragments.add(fragment_5);
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb_login:{
                        vp.setCurrentItem(0);
                    }break;
                    case R.id.rb_cart:{
                        vp.setCurrentItem(3);
                    }break;
                    case R.id.rb_find:{
                        vp.setCurrentItem(2);
                    }break;
                    case R.id.rb_classify:{
                        vp.setCurrentItem(1);
                    }break;
                    case R.id.rb_my:{
                        vp.setCurrentItem(4);
                    }break;
                }
            }
        });
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
             rg.check(rg.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void initView() {
        vp = findViewById(R.id.vp);
        rg = findViewById(R.id.rg);

    }

    @Override
    protected int layoutid() {
        return R.layout.activity_main;
    }
}
