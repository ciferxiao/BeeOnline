package com.bee.beeonline.main.login;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.bee.beeonline.BeenApplication;
import com.bee.beeonline.R;
import com.bee.beeonline.jpush.Extra;
import com.bee.beeonline.main.MainActivity;
import com.beeonline.library.base.BaseActivity;
import com.beeonline.library.base.BaseApplication;

import java.util.List;

import butterknife.ButterKnife;

public class LauncherActivity extends BaseActivity {

    public static void start(Context context, Extra extra) {
        context.startActivity(
                new Intent(context, LauncherActivity.class)
                        .putExtra("extra", extra)
                        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void initData(Bundle bundle) {
        if (bundle != null) {
            BeenApplication.extra = bundle.getParcelable("extra");
        }
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_launcher;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        ButterKnife.bind(this);
        requestPermission(needPermissions);//申请权限
//        int i = new Random().nextInt(2);
//        Log.e("RENJIE", "     " + i);
//        if (i == 1) {
//            findViewById(R.id.layout_content).setVisibility(View.VISIBLE);
//        } else {
//            findViewById(R.id.layout_content_2).setVisibility(View.VISIBLE);
//        }
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void doBusiness() {

    }

    @SuppressLint("HandlerLeak")
    private class LauncherHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String strToken = (String) msg.obj;
            if (strToken.length() == 0) {
                LoginActivity.startActivity(LauncherActivity.this);
            } else {
                MainActivity.startActivity(LauncherActivity.this);
            }
            BaseApplication.instance().finishActivity(LauncherActivity.this);
        }
    }

    @Override
    public void onBackPressed() {

    }

    protected String[] needPermissions = {
            Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
    };

    @Override
    protected void applyPermissionResult(boolean isSuccess, List deniedPermissions) {
        super.applyPermissionResult(isSuccess, deniedPermissions);
        if (isSuccess) {
            LauncherHandler launcherHandler = new LauncherHandler();
            String strToken = BaseApplication.getToken();
            Message message = Message.obtain();
            message.obj = strToken;
            launcherHandler.sendMessageDelayed(message, 2000);
        } else {
            finish();
        }
    }
}
