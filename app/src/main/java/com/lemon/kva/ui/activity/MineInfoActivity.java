package com.lemon.kva.ui.activity;


import android.os.Bundle;

import com.lemon.kva.R;

public class MineInfoActivity extends BaseActivity {

    private static final String TAG = "MineInfoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_info);

        initView();
    }

    @Override
    protected int getActionBarTitle() {
        return R.string.title_mine_info;
    }

    @Override
    protected boolean hasBackButton() {
        return true;
    }

    private  void initView(){

    }
}
