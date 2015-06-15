package com.lemon.kva.util;


import android.content.Context;
import android.content.Intent;

import com.lemon.kva.ui.activity.MineInfoActivity;
import com.lemon.kva.ui.activity.NoticeCommentActivity;
import com.lemon.kva.ui.activity.NoticeContributionActivity;
import com.lemon.kva.ui.activity.NoticeFansActivity;
import com.lemon.kva.ui.activity.RegisterActivity;

public class UIHelper {

    public static  void showRegister(Context context){
        Intent intent = new Intent(context, RegisterActivity.class);
        context.startActivity(intent);
    }

    public static  void showMineInfo(Context context){
        Intent intent = new Intent(context, MineInfoActivity.class);
        context.startActivity(intent);
    }

    public static  void showNoticeFans(Context context){
        Intent intent = new Intent(context, NoticeFansActivity.class);
        context.startActivity(intent);
    }

    public static  void showNoticeComment(Context context){
        Intent intent = new Intent(context, NoticeCommentActivity.class);
        context.startActivity(intent);
    }

    public static  void showNoticeContribution(Context context){
        Intent intent = new Intent(context, NoticeContributionActivity.class);
        context.startActivity(intent);
    }
}
