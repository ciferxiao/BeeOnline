package com.bee.beeonline.main.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.bee.beeonline.BeenApplication;
import com.bee.beeonline.R;
import com.bee.beeonline.bean.LoginBean;
import com.bee.beeonline.main.MainActivity;
import com.bee.beeonline.utils.CountDownTimerUtils;
import com.beeonline.library.base.BaseActivity;
import com.beeonline.library.helper.StringHelper;
import com.beeonline.library.httpapi.bean.BaseData;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresenterImpl> implements LoginContract.View {

    @BindView(R.id.user_name)
    EditText mUserName;
    @BindView(R.id.password)
    EditText mPassword;
    @BindView(R.id.update_get_password)
    TextView update_get_password;

    @Override
    public void initData(Bundle bundle) {
        BeenApplication.instance().onlyLiveActivity(LoginActivity.class.getSimpleName());
    }

    @Override
    protected void initImmersionBar() {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        ButterKnife.bind(this);
        BeenApplication.instance().onlyLiveActivity(LoginActivity.class.getSimpleName());
    }

    @Override
    public void initPresenter() {
        mPresenter = new LoginPresenterImpl();
    }

    @OnClick({R.id.btn_login, R.id.update_get_password})
    public void onLoginClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                if (StringHelper.isEmpty(mPassword.getText().toString())) {
                    showToast("请输入验证码");
                    return;
                }
                mPresenter.postLogin(mUserName.getText().toString(), "", mPassword.getText().toString());
                break;
            case R.id.update_get_password:
                if (TextUtils.isEmpty(mUserName.getText().toString())) {
                    showToast("手机号不能为空");
                    return;
                }
                CountDownTimerUtils mCountDownTimerUtils = new CountDownTimerUtils(update_get_password, 60000, 1000, mActivity, "重新获取验证码");
                mCountDownTimerUtils.start();
                mPresenter.getCode(mUserName.getText().toString());
                break;
        }
    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void loginSuccess(LoginBean loginBean) {
        MainActivity.startActivity(this);
        BeenApplication.instance().finishActivity(this);
    }

    @Override
    public void loginFail(int code, String message) {
        showToast(message);
    }

    @Override
    public void getCodeSuccess(BaseData loginBean) {
        showToast("短信验证码已发送至手机");
    }

    @Override
    public void getCodeFail(int code, String message) {
        showError(message);
    }

    @Override
    public void showError(String msg) {
        showToast(msg);
    }

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onBackPressed() {

    }
}
