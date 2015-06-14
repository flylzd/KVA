package com.lemon.kva.ui.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.lemon.kva.R;
import com.lemon.kva.ui.fragment.FavFragment;
import com.lemon.kva.ui.fragment.HomeFragment;
import com.lemon.kva.ui.fragment.MeFragment;
import com.lemon.kva.ui.fragment.NoticeFragment;
import com.lemon.kva.view.fragmentswitcher.FragmentStateArrayPagerAdapter;
import com.lemon.kva.view.fragmentswitcher.FragmentSwitcher;

import java.util.HashMap;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    private FragmentSwitcher fragmentSwitcher;
    private FragmentStateArrayPagerAdapter fragmentAdapter;

    private View layoutTabHome;
    private View layoutTabFav;
    private View layoutTabPublish;
    private View layoutTabNotice;
    private View layoutTabMe;

    private ImageView imgTabHome;
    private ImageView imgTabFav;
    private ImageView imgTabNotice;
    private ImageView imgTabMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //隐藏标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initFragmentSwitcher();
        initView();

    }

    private void initView() {

        layoutTabHome = findViewById(R.id.layoutTabHome);
        layoutTabFav = findViewById(R.id.layoutTabFav);
        layoutTabPublish = findViewById(R.id.layoutTabPublish);
        layoutTabNotice = findViewById(R.id.layoutTabNotice);
        layoutTabMe = findViewById(R.id.layoutTabMe);

        layoutTabHome.setOnClickListener(this);
        layoutTabFav.setOnClickListener(this);
        layoutTabPublish.setOnClickListener(this);
        layoutTabNotice.setOnClickListener(this);
        layoutTabMe.setOnClickListener(this);

        imgTabHome = (ImageView) findViewById(R.id.imgTabHome);
        imgTabFav = (ImageView) findViewById(R.id.imgTabFav);
        imgTabNotice = (ImageView) findViewById(R.id.imgTabNotice);
        imgTabMe = (ImageView) findViewById(R.id.imgTabMe);
        imgTabHome.setSelected(true);
    }

    private void initFragmentSwitcher() {
        fragmentSwitcher = (FragmentSwitcher) findViewById(R.id.fragment_container);
        fragmentAdapter = new FragmentStateArrayPagerAdapter(getSupportFragmentManager());
        fragmentSwitcher.setAdapter(fragmentAdapter);

//        HomeFragment homeFragment = HomeFragment.newInstance();
        HomeFragment homeNewFragment = HomeFragment.newInstance();
        FavFragment favFragment = FavFragment.newInstance();
        NoticeFragment noticeFragment = NoticeFragment.newInstance();
        MeFragment meFragment = MeFragment.newInstance();

//        fragmentAdapter.add(homeFragment);
        fragmentAdapter.add(homeNewFragment);
        fragmentAdapter.add(favFragment);
        fragmentAdapter.add(noticeFragment);
        fragmentAdapter.add(meFragment);
    }

    @Override
    public void onClick(View v) {

        imgNoSelected();
        switch (v.getId()){
            case R.id.layoutTabHome:
                imgTabHome.setSelected(true);
                fragmentSwitcher.setCurrentItem(0);
                break;
            case R.id.layoutTabFav:
                imgTabFav.setSelected(true);
                fragmentSwitcher.setCurrentItem(1);
                break;
            case R.id.layoutTabPublish:
                break;
            case R.id.layoutTabNotice:
                imgTabNotice.setSelected(true);
                fragmentSwitcher.setCurrentItem(2);
                break;
            case R.id.layoutTabMe:
                imgTabMe.setSelected(true);
                fragmentSwitcher.setCurrentItem(3);
                break;
        }
    }


    private void imgNoSelected(){
        imgTabHome.setSelected(false);
        imgTabFav.setSelected(false);
        imgTabNotice.setSelected(false);
        imgTabMe.setSelected(false);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
