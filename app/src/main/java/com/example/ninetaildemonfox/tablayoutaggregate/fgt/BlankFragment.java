package com.example.ninetaildemonfox.tablayoutaggregate.fgt;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ninetaildemonfox.tablayoutaggregate.R;
import com.example.ninetaildemonfox.tablayoutaggregate.adp.FragmentAdp;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> fragments;
    private FragmentAdp fragmentAdp;
    private List<String> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.viewPager);
        fragments = new ArrayList<>();
        list.add("第一个");
        list.add("第二个");
        fragments.add(QRCodeFgt.newInstence("我是碎片界面"));
        fragments.add(QRCodeFgt.newInstence("我是碎片的第二个界面"));
        fragmentAdp = new FragmentAdp(getChildFragmentManager(), fragments, list);
        viewPager.setAdapter(fragmentAdp);
        tabLayout.setupWithViewPager(viewPager);
    }

    public static BlankFragment newInstence() {
        BlankFragment blankFragment = new BlankFragment();
        Bundle bundle = new Bundle();
        blankFragment.setArguments(bundle);
        return blankFragment;
    }

    public void tabLayout(int tab) {
        viewPager.setCurrentItem(tab);
//        Toast.makeText(getActivity(), "第"+tab, Toast.LENGTH_SHORT).show();
    }
}
