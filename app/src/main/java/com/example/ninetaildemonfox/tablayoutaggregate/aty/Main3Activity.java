package com.example.ninetaildemonfox.tablayoutaggregate.aty;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.ninetaildemonfox.tablayoutaggregate.R;
import com.example.ninetaildemonfox.tablayoutaggregate.adp.ViewPagerAdapter;
import com.example.ninetaildemonfox.tablayoutaggregate.fgt.BlankFragment;
import com.example.ninetaildemonfox.tablayoutaggregate.fgt.HomeFgt;
import com.example.ninetaildemonfox.tablayoutaggregate.fgt.QRCodeFgt;
import com.example.ninetaildemonfox.tablayoutaggregate.utlis.NoSrcollViewPage;

import java.util.ArrayList;
import java.util.List;


public class Main3Activity extends AppCompatActivity implements HomeFgt.FragmentInteraction, BottomNavigationBar.OnTabSelectedListener, ViewPager.OnPageChangeListener {

    private ViewPager viewPager;
    private BottomNavigationBar bottom_navigation_bar;
    private List<Fragment> data;
    BlankFragment blankFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
    }



    private void initView() {
        viewPager = findViewById(R.id.viewPager);
        bottom_navigation_bar = findViewById(R.id.bottom_navigation_bar);
        data = new ArrayList<>();
        data.add(HomeFgt.newInstance());
        data.add(QRCodeFgt.newInstence("第二个界面"));
        blankFragment = BlankFragment.newInstence();
        data.add(BlankFragment.newInstence());
        data.add(QRCodeFgt.newInstence("第四个界面"));
        //初始化底部导航栏
        initBottomNavigationBar();
        viewPager.setOffscreenPageLimit(4);
        viewPager.setOnPageChangeListener(this);
        ViewPagerAdapter mainAdapter = new ViewPagerAdapter(getSupportFragmentManager(), data);
        viewPager.setAdapter(mainAdapter); //视图加载适配器
    }


    //初始化底部导航条
    private void initBottomNavigationBar() {
        bottom_navigation_bar.setTabSelectedListener(this);
//        badgeItem = new BadgeItem()
//                .setHideOnSelect(true) //设置被选中时隐藏角标
//                .setBackgroundColor(Color.RED)
//                .setText("99");
        /**
         * 设置模式
         * 1、BottomNavigationBar.MODE_DEFAULT 默认
         * 如果Item的个数<=3就会使用MODE_FIXED模式，否则使用MODE_SHIFTING模式
         *
         * 2、BottomNavigationBar.MODE_FIXED 固定大小
         * 填充模式，未选中的Item会显示文字，没有换挡动画。
         *
         * 3、BottomNavigationBar.MODE_SHIFTING 不固定大小
         * 换挡模式，未选中的Item不会显示文字，选中的会显示文字。在切换的时候会有一个像换挡的动画
         */
        bottom_navigation_bar.setMode(BottomNavigationBar.MODE_FIXED);
        /**
         * 设置背景的样式
         * 1、BottomNavigationBar.BACKGROUND_STYLE_DEFAULT 默认
         * 如果设置的Mode为MODE_FIXED，将使用BACKGROUND_STYLE_STATIC 。
         * 如果Mode为MODE_SHIFTING将使用BACKGROUND_STYLE_RIPPLE。
         *
         * 2、BottomNavigationBar.BACKGROUND_STYLE_STATIC 导航条的背景色是白色，
         * 加上setBarBackgroundColor（）可以设置成你所需要的任何背景颜色
         * 点击的时候没有水波纹效果
         *
         * 3、BottomNavigationBar.BACKGROUND_STYLE_RIPPLE 导航条的背景色是你设置的处于选中状态的
         * Item的颜色（ActiveColor），也就是setActiveColorResource这个设置的颜色
         * 点击的时候有水波纹效果
         */
        bottom_navigation_bar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        //设置导航条背景颜色
        //在BACKGROUND_STYLE_STATIC下，表示整个容器的背景色。
        // 而在BACKGROUND_STYLE_RIPPLE下，表示选中Item的图标和文本颜色。默认 Color.WHITE
        bottom_navigation_bar.setBarBackgroundColor(R.color.colorPrimary);
        //选中时的颜色,在BACKGROUND_STYLE_STATIC下，表示选中Item的图标和文本颜色。
        // 而在BACKGROUND_STYLE_RIPPLE下，表示整个容器的背景色。默认Theme's Primary Color
        //bottomNavigationBar.setActiveColor(R.color.black);
        //未选中时的颜色，表示未选中Item中的图标和文本颜色。默认为 Color.LTGRAY
        //bottomNavigationBar.setInActiveColor("#FFFFFF");

        bottom_navigation_bar.addItem(new BottomNavigationItem(R.drawable.home_imagge_1, "首页").setActiveColorResource(R.color.colorAccent))
                .addItem(new BottomNavigationItem(R.drawable.home_imagge_2, "行情").setActiveColorResource(R.color.colorAccent))
                .addItem(new BottomNavigationItem(R.drawable.home_imagge_3, "咨询").setActiveColorResource(R.color.colorAccent))
                .addItem(new BottomNavigationItem(R.drawable.home_imagge_4, "我的").setActiveColorResource(R.color.colorAccent))
                .setFirstSelectedPosition(0)
                .initialise();
        //所有的设置需在调用该方法前完成

        //如果使用颜色的变化不足以展示一个选项Item的选中与非选中状态，
        // 可以使用BottomNavigationItem.setInActiveIcon()方法来设置。
//        new BottomNavigationItem(R.drawable.ic_home_white_24dp, "公交")//这里表示选中的图片
//                .setInactiveIcon(ContextCompat.getDrawable(this,R.mipmap.ic_launcher));//非选中的图片
    }

    @Override
    public void onTabSelected(int position) {
        //tab被选中
        viewPager.setCurrentItem(position);
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        bottom_navigation_bar.selectTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void process(int selectPage, int count) {
        viewPager.setCurrentItem(selectPage);
        if (selectPage == 2) {
            blankFragment.tabLayout(count);
        }
    }
}
