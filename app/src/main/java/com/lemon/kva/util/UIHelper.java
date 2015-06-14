package com.lemon.kva.util;


import android.content.Context;
import android.content.Intent;

import com.lemon.kva.ui.activity.RegisterActivity;

public class UIHelper {

    public static  void showRegister(Context context){
        Intent intent = new Intent(context, RegisterActivity.class);
        context.startActivity(intent);
    }
}
