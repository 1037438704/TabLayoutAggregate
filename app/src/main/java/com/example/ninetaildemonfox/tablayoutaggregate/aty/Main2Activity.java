package com.example.ninetaildemonfox.tablayoutaggregate.aty;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.example.ninetaildemonfox.tablayoutaggregate.R;
import com.example.ninetaildemonfox.tablayoutaggregate.adp.ViewPagerAdapter;
import com.example.ninetaildemonfox.tablayoutaggregate.fgt.HomeFgt;
import com.example.ninetaildemonfox.tablayoutaggregate.fgt.QRCodeFgt;
import java.util.ArrayList;
import java.util.List;


public class Main2Activity extends AppCompatActivity {

    private RadioButton rb_first;
    private RadioButton rb_second;
    private RadioGroup ll_rbtn_contain;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        rb_first = findViewById(R.id.rb_first);
        rb_second = findViewById(R.id.rb_second);
        ll_rbtn_contain = findViewById(R.id.ll_rbtn_contain);
        viewPager = findViewById(R.id.viewPager);
        fragments = new ArrayList<>();
        fragments.add(HomeFgt.newInstance());
        fragments.add(QRCodeFgt.newInstence("第二个界面"));
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);
        ll_rbtn_contain.check(R.id.rb_first);
        viewPager.setAdapter(adapter);


        /**
         *
         * 当页面滑动我们改变radioButton按钮
         *
         */
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        ll_rbtn_contain.check(R.id.rb_first);
                        break;
                    case 1:
                        ll_rbtn_contain.check(R.id.rb_second);
                        break;
                    default:
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        /**
         * 当我们点击按钮的时候,改变页面
         */
        ll_rbtn_contain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_first:
                        viewPager.setCurrentItem(0, false);
                        break;
                    case R.id.rb_second:
                        viewPager.setCurrentItem(1, false);
                        break;
                    default:
                }
            }
        });
    }
}
