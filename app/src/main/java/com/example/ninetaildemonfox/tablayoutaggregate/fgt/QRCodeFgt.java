package com.example.ninetaildemonfox.tablayoutaggregate.fgt;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ninetaildemonfox.tablayoutaggregate.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class QRCodeFgt extends Fragment {

    private TextView textView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fgt_qrcode, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        String context = QRCodeFgt.this.getArguments().getString("context");
        textView = view.findViewById(R.id.textView);
        textView.setText(context);
    }

    public static QRCodeFgt newInstence(String context) {
        QRCodeFgt qrCodeFgt = new QRCodeFgt();
        Bundle bundle = new Bundle();
        bundle.putString("context", context);
        qrCodeFgt.setArguments(bundle);
        return qrCodeFgt;
    }


}
