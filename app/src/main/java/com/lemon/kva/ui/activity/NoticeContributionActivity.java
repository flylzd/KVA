package com.lemon.kva.ui.activity;


import android.os.Bundle;

import com.joanzapata.android.BaseAdapterHelper;
import com.joanzapata.android.QuickAdapter;
import com.lemon.kva.R;
import com.lemon.kva.view.EndOfListView;

import java.util.ArrayList;
import java.util.List;

public class NoticeContributionActivity extends BaseActivity {

    private static final String TAG = "NoticeContributionActivity";

    private EndOfListView listView;
    private QuickAdapter<String> adapter;
    private List<String> dataList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_comment);

        initView();
    }

    @Override
    protected int getActionBarTitle() {
        return R.string.title_contribution;
    }

    @Override
    protected boolean hasBackButton() {
        return true;
    }

    private  void initView(){

        adapter = new QuickAdapter<String>(NoticeContributionActivity.this, R.layout.listitem_notice_comment) {
            @Override
            protected void convert(BaseAdapterHelper helper, String item) {

            }
        };
        listView = (EndOfListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        for (int i = 0; i < 10; i++) {
            dataList.add("22222");
        }
        adapter.replaceAll(dataList);
    }
}
