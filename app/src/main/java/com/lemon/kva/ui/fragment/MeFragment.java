package com.lemon.kva.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.lemon.kva.R;
import com.lemon.kva.util.UIHelper;

public class MeFragment extends Fragment implements View.OnClickListener {

    private final static String TAG = "MeFragment";

    private View layoutMineInfo;
    private View layoutMeGold;
    private View layoutMeManYin;
    private View layoutMeScore;
    private View layoutMeFeedback;
    private View layoutMeAbout;
    private View layoutMeSetting;

    private Button btnLogout;


    public static MeFragment newInstance() {
        MeFragment fragment = new MeFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        System.out.println("MeFragment onViewCreated");
        initView(view);
    }

    private void initView(View view) {

        layoutMineInfo = view.findViewById(R.id.layoutMineInfo);
        layoutMeGold = view.findViewById(R.id.layoutMeGold);
        layoutMeManYin = view.findViewById(R.id.layoutMeManYin);
        layoutMeScore = view.findViewById(R.id.layoutMeScore);
        layoutMeFeedback = view.findViewById(R.id.layoutMeFeedback);
        layoutMeAbout = view.findViewById(R.id.layoutMeAbout);
        layoutMeSetting = view.findViewById(R.id.layoutMeSetting);
        btnLogout = (Button) view.findViewById(R.id.btnLogout);

        layoutMineInfo.setOnClickListener(this);
        layoutMeGold.setOnClickListener(this);
        layoutMeManYin.setOnClickListener(this);
        layoutMeScore.setOnClickListener(this);
        layoutMeFeedback.setOnClickListener(this);
        layoutMeAbout.setOnClickListener(this);
        layoutMeSetting.setOnClickListener(this);
        btnLogout.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layoutMineInfo:
                UIHelper.showMineInfo(getActivity());
                break;
        }
    }
}
