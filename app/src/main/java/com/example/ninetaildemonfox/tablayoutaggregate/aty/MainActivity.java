package com.example.ninetaildemonfox.tablayoutaggregate.aty;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.ninetaildemonfox.tablayoutaggregate.R;
import com.example.ninetaildemonfox.tablayoutaggregate.fgt.BlankFragment;
import com.example.ninetaildemonfox.tablayoutaggregate.fgt.BlankFragment2;
import com.example.ninetaildemonfox.tablayoutaggregate.fgt.HomeFgt;
import com.example.ninetaildemonfox.tablayoutaggregate.fgt.QRCodeFgt;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements HomeFgt.FragmentInteraction{

    private FrameLayout main_center_layout;
    private RadioButton home_rb;
    private RadioButton qr_scan_rb;
    private RadioButton my_order_rb;
    private RadioButton profile_rb;
    private RadioGroup main_rg;
    private FragmentManager fragmentManager;
    private ArrayList<Fragment> fragments;
    private List<String> fragmentTags;
    private List<RadioButton> listRb;
    private int selectPage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    BlankFragment blankFragment;
    private void initView() {
        Log.d("zdl", "==========日志启动了==========");
        main_center_layout = findViewById(R.id.main_center_layout);
        home_rb = findViewById(R.id.home_rb);
        qr_scan_rb = findViewById(R.id.qr_scan_rb);
        my_order_rb = findViewById(R.id.my_order_rb);
        profile_rb = findViewById(R.id.profile_rb);
        main_rg = findViewById(R.id.main_rg);
        fragmentManager = getSupportFragmentManager();
        fragmentTags = new ArrayList<>();
        fragments = new ArrayList<>();
        listRb = new ArrayList<>();
        fragments.add(HomeFgt.newInstance());
        fragments.add(QRCodeFgt.newInstence("第1个界面"));
        blankFragment = new BlankFragment();
        fragments.add(blankFragment);
        fragments.add(new BlankFragment2());
        for (Fragment fgt : fragments) {
            fragmentTags.add(fgt.getClass().getSimpleName());
        }

        listRb.add(home_rb);
        listRb.add(qr_scan_rb);
        listRb.add(my_order_rb);
        listRb.add(profile_rb);
        main_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.home_rb:
                        selectPage = 0;
                        Toast.makeText(MainActivity.this, "0", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.qr_scan_rb:
                        Toast.makeText(MainActivity.this, "1", Toast.LENGTH_SHORT).show();
                        selectPage = 1;
                        break;
                    case R.id.my_order_rb:
                        Toast.makeText(MainActivity.this, "2", Toast.LENGTH_SHORT).show();
                        selectPage = 2;
                        break;
                    case R.id.profile_rb:
                        Toast.makeText(MainActivity.this, "3", Toast.LENGTH_SHORT).show();
                        selectPage = 3;
                        break;
                }
                showFragment();
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        listRb.get(selectPage).setChecked(true);
    }
    /**
     * 显示Fragment
     */
    private void showFragment() {
        // 事物开始
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // 获取选中的Fragment
        Fragment fragment = fragmentManager.findFragmentByTag(fragmentTags.get(selectPage));
        // 碎片为空
        if (fragment == null) {
            // 获取碎片
            fragment = instantFragment(selectPage);
        }
        // 隐藏之前显示过的Fragment
        for (int i = 0; i < fragmentTags.size(); i++) {
            Fragment f = fragmentManager.findFragmentByTag(fragmentTags.get(i));
            if (f != null && f.isAdded()) {
                fragmentTransaction.hide(f);
            }
        }
        // 判断当前选中的Fragment是否被添加
        if (fragment.isAdded()) {
            // 显示
            fragmentTransaction.show(fragment);
        } else {
            // 添加当前碎片到fragment_container容器中
            fragmentTransaction.add(R.id.main_center_layout, fragment, fragmentTags.get(selectPage));
        }
        /*
         * commit()：安排一个事务的提交。
         * commitAllowingStateLoss()：和commit一样，但是允许Activity的状态保存之后提交。
         * commitNow()：同步的提交这个事务。（API_24添加的）
         * commitNowAllowingStateLoss()：和commitNow()一样，但是允许Activity的状态保存之后提交。（API_24添加的）
         */
        fragmentTransaction.commitAllowingStateLoss();
        fragmentManager.executePendingTransactions();
    }

    /**
     * 返回一个新的Fragment
     *
     * @param currIndex 下标
     * @return Fragment
     */
    private Fragment instantFragment(int currIndex) {
        return fragments.get(currIndex);
    }

    @Override
    public void process(int selectPage, int count) {
        Log.d("zdl", "==========日志启动了======2===="+selectPage);
        listRb.get(selectPage).setChecked(true);
        Log.d("zdl","===========count============"+count);
        if (selectPage == 2){
            blankFragment.tabLayout(count);
        }

    }
}
