package com.lemon.kva.ui.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.error.VolleyError;
import com.lemon.kva.R;
import com.lemon.kva.app.APIClient;
import com.lemon.kva.constant.Config;
import com.lemon.kva.volley.ResponseListener;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.CommonDialog;


public class RegisterActivity extends ActionBarActivity {

    public static final String TAG = "RegisterActivity";

    private EditText etPhone;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private EditText etVerCode;

    private Button btnVerCode;
    private Button btnRegister;

    private Dialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initSDK();
        initView();
    }

    private void initView() {

        etPhone = (EditText) findViewById(R.id.etPhone);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etConfirmPassword = (EditText) findViewById(R.id.etConfirmPassword);
        etVerCode = (EditText) findViewById(R.id.etVerCode);

        btnVerCode = (Button) findViewById(R.id.btnVerCode);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnVerCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phone = etPhone.getText().toString();
                SMSSDK.getVerificationCode("86", phone);
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phone = etPhone.getText().toString();
                String password = etPassword.getText().toString();
                String verCode = etVerCode.getText().toString();

                register(phone,password,verCode);
            }
        });
    }

    private void register(String phone, String password, String verCode) {

        APIClient.register(TAG,phone,password,verCode,new ResponseListener() {
            @Override
            public void onStarted() {

            }

            @Override
            public void onResponse(Object response) {

            }

            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });


    }


    private void initSDK() {
        // 初始化短信SDK
        SMSSDK.initSDK(this, Config.APPKEY, Config.APPSECRET);
        EventHandler eventHandler = new EventHandler() {
            @Override
            public void afterEvent(int event, int result, Object data) {

                if (result == SMSSDK.RESULT_COMPLETE) {
                    //回调完成
                    if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                        //提交验证码成功
                        System.out.println("提交验证码成功");
                    } else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                        //获取验证码成功
                        System.out.println("获取验证码成功");
                    } else if (event == SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES) {
                        //返回支持发送验证码的国家列表
                        System.out.println("返回支持发送验证码的国家列表");
                    }
                } else {
                    ((Throwable) data).printStackTrace();
                }
            }
        };
        // 注册回调监听接口
        SMSSDK.registerEventHandler(eventHandler);
    }

    // 弹出加载框
    private void showDialog() {
        if (pd != null && pd.isShowing()) {
            pd.dismiss();
        }
        pd = CommonDialog.ProgressDialog(this);
        pd.show();
    }

    @Override
    protected void onDestroy() {
        // 销毁回调监听接口
        SMSSDK.unregisterAllEventHandler();
        super.onDestroy();
    }

}