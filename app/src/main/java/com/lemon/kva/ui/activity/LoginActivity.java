package com.lemon.kva.ui.activity;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.error.VolleyError;
import com.lemon.kva.R;
import com.lemon.kva.app.APIClient;
import com.lemon.kva.util.UIHelper;
import com.lemon.kva.volley.ResponseListener;

public class LoginActivity extends ActionBarActivity {

    private static final String TAG = "LoginActivity";

    private EditText etUsername;
    private EditText etPassword;
    private Button btnRegister;
    private Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //隐藏标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        initView();
    }

    private void initView() {

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIHelper.showRegister(LoginActivity.this);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(LoginActivity.this, getString(R.string.login_username_empty), Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(LoginActivity.this, getString(R.string.login_password_empty), Toast.LENGTH_SHORT).show();
                    return;
                }

                login(username, password);
            }
        });
    }

    private void login(String username, String password) {

        APIClient.login(TAG, username, password, new ResponseListener() {
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
}
