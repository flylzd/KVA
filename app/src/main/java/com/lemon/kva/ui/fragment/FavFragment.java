package com.lemon.kva.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.joanzapata.android.BaseAdapterHelper;
import com.joanzapata.android.QuickAdapter;
import com.lemon.kva.R;
import com.lemon.kva.view.EndOfListView;

import java.util.ArrayList;
import java.util.List;

public class FavFragment extends Fragment {

    private final static String TAG = "FavFragment";

    private RadioGroup radioGroup;
    private RadioButton rbFavFocus;
    private RadioButton rbFavCollect;

    private EndOfListView listView;
    private QuickAdapter<String> adapter;
    private List<String> dataList = new ArrayList<String>();

    public static FavFragment newInstance() {
        FavFragment fragment = new FavFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fav, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        System.out.println("FavFragment onViewCreated");
        initView(view);
    }

    private void initView(View view) {
        radioGroup = (RadioGroup) view.findViewById(R.id.radioGroup);
        rbFavFocus = (RadioButton) view.findViewById(R.id.rbFavFocus);
        rbFavCollect = (RadioButton) view.findViewById(R.id.rbFavCollect);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbFavFocus:
                        break;
                    case R.id.rbFavCollect:
                        break;
                }
            }
        });

        adapter = new QuickAdapter<String>(getActivity(), R.layout.listitem_fav_facus) {
            @Override
            protected void convert(BaseAdapterHelper helper, String item) {

            }
        };
        listView = (EndOfListView) view.findViewById(R.id.listView);
        listView.setAdapter(adapter);

        for (int i = 0; i < 10; i++) {
            dataList.add("22222");
        }
        adapter.replaceAll(dataList);

    }

}
