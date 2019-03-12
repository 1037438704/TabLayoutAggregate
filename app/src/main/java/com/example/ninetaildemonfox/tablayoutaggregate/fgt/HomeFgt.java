package com.example.ninetaildemonfox.tablayoutaggregate.fgt;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.ninetaildemonfox.tablayoutaggregate.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFgt extends Fragment {
    private Button button;
    private Button button_2;
    private Button button_3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fgt_home, container, false);
        // Inflate the layout for this fragment
        initView(view);
        if (getActivity() instanceof FragmentInteraction) {
            listterner = (FragmentInteraction) getActivity(); // 2.2 获取到宿主activity并赋值
        } else {
            throw new IllegalArgumentException("activity must implements FragmentInteraction");
        }
        return view;
    }

    private void initView(View view) {
        button = view.findViewById(R.id.button);
        button_2 = view.findViewById(R.id.button_2);
        button_3 = view.findViewById(R.id.button_3);
        //第二个界面
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listterner.process(1,0);
            }
        });
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listterner.process(2,1);
            }
        });
        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listterner.process(3,0);
            }
        });
    }

    public static HomeFgt newInstance() {
        HomeFgt homeFgt = new HomeFgt();
        Bundle bundle = new Bundle();
        homeFgt.setArguments(bundle);
        return homeFgt;
    }
    private FragmentInteraction listterner;

    public interface FragmentInteraction {
        void process(int selectPage,int count);
    }
}
