package com.lemon.kva.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.joanzapata.android.BaseAdapterHelper;
import com.joanzapata.android.QuickAdapter;
import com.lemon.kva.R;
import com.lemon.kva.util.UIHelper;
import com.lemon.kva.view.EndOfListView;

import java.util.ArrayList;
import java.util.List;

public class NoticeFragment extends Fragment {

    private final static String TAG = "NoticeFragment";

    private EndOfListView listView;
    private QuickAdapter<String> adapter;
    private List<String> dataList = new ArrayList<String>();

    public static NoticeFragment newInstance() {
        NoticeFragment fragment = new NoticeFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notice, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        System.out.println("NoticeFragment onViewCreated");
        initView(view);
    }


    private void initView(View view) {

        adapter = new QuickAdapter<String>(getActivity(), R.layout.listitem_notice) {
            @Override
            protected void convert(BaseAdapterHelper helper, String item) {

//                int position = helper.getPosition();
//                if (position == 1 ){
//                    UIHelper.showNoticeFans(getActivity());
//                } else if (position == 2){
//
//                } else if (position == 3 ){
//
//                }

            }
        };
        listView = (EndOfListView) view.findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0 ){
                    UIHelper.showNoticeFans(getActivity());
                } else if (position == 1){
                    UIHelper.showNoticeComment(getActivity());
                } else if (position == 2 ){
                    UIHelper.showNoticeContribution(getActivity());
                }
            }
        });

        for (int i = 0; i < 10; i++) {
            dataList.add("22222");
        }
        adapter.replaceAll(dataList);

    }

}
