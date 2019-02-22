package com.bee.beeonline.main.me;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.bee.beeonline.R;
import com.beeonline.library.base.BaseActivity;
import com.beeonline.library.base.BaseDialog;

import butterknife.ButterKnife;

/**
 * Created by liuzq on 2018/3/6.
 */

public class MineActivity extends BaseActivity {


    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_mine;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        immersionBar.fitsSystemWindows(true)
                .statusBarColor(R.color.white)
                .statusBarDarkFont(true, 0.2f)
                .init();
    }

    @Override
    public void doBusiness() {
    }
//
//    @OnClick(value = {R.id.person_info, R.id.update_password, R.id.message_notify, R.id.clear_cache, R.id.about_been, R.id.btn_out_login, R.id.layout_back})
//    public void onMineClick(View view) {
//        switch (view.getId()) {
//            case R.id.person_info:
//                PersonInfoActivity.startActivity(this);
//                break;
//            case R.id.update_password:
//                UpdatePasswordActivity.startActivity(this);
//                break;
//            case R.id.message_notify:
//                NewMessageNoticeActivity.startActivity(this);
//                break;
//            case R.id.clear_cache:
//                clearCache();
//                break;
//            case R.id.about_been:
//                AboutBeenActivity.startActivity(this);
//                break;
//            case R.id.btn_out_login:
//                SPHelper.remove(this, Constant.PREF_LOGIN_TOKEN);
//                LoginActivity.startActivity(this);
//                break;
//            case R.id.layout_back:
//                onBackPressed();
//                break;
//            default:
//                break;
//        }
//    }

    private void clearCache() {
        new BaseDialog(this)
                .setmTitle("确认清除缓存吗？")
                .setmPositiveButtonText("确认")
                .setmNegativeButtonText("取消")
                .setmPositiveButtonClickListener(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        showLoading();
                        handler.sendEmptyMessageDelayed(1, 2000);
                    }
                })
                .setmNegativeButtonClickListener(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        showToast("取消");
                    }
                })
                .mCreate()
                .show();
    }

    @Override
    public void showError(String msg) {
        showToast(msg);
    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            hideLoading();
        }
    };
}
