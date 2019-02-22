package com.bee.beeonline.main.login;

import android.content.Context;

import com.bee.beeonline.BeenApplication;
import com.bee.beeonline.base.BasePresenterImpl;
import com.bee.beeonline.bean.LoginBean;
import com.bee.beeonline.http.HttpRequest;
import com.bee.beeonline.utils.Constant;
import com.beeonline.library.helper.LogHelper;
import com.beeonline.library.helper.StringHelper;
import com.beeonline.library.httpapi.bean.BaseData;
import com.beeonline.library.httpapi.interceptor.Transformer;
import com.beeonline.library.httpapi.observer.DataObserver;
import com.beeonline.library.httpapi.utils.SPUtils;
import com.google.gson.Gson;

import java.util.LinkedHashMap;


/**
 * Created by 59395 on 2018/3/3.
 */

public class LoginPresenterImpl extends BasePresenterImpl implements LoginContract.Presenter {

    private LoginContract.View mView;//根据这个view回调，需要写handle才能刷新页面
    private Context mContext;

    @Override
    public void postLogin(String userName, String password, String code) {

        if (StringHelper.isEmpty(userName)) {
            if (mView != null)
                mView.showError("请输入用户名");
            return;
        }

        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        if (StringHelper.isNotEmpty(password)) {
            map.put("password", password);
        }
        if (StringHelper.isNotEmpty(code)) {
            map.put("code", code);
        }
        if (StringHelper.isNotEmpty(userName)) {
            map.put("mobile_phone", userName);
        }
        map.put("sign", getSign(map));
        HttpRequest.createApi()
                .signin(map)
                .compose(Transformer.<LoginBean>switchSchedulers())
                .subscribe(new DataObserver<LoginBean>() {
                    @Override
                    protected void onError(int errorCode, String errorMsg) {
                        if (mView != null)
                            mView.loginFail(errorCode, errorMsg);
                    }

                    @Override
                    protected void onSuccess(LoginBean data) {
//                        LogHelper.error("LoginBean:" + new Gson().toJson(data));
                        BeenApplication.instance().setLoginBean(data);
//                        SPUtils.put(Constant.USER_ID, data.getUser().getUser_id().getId());
                        if (!StringHelper.isEmpty(data.getData().getToken())) {
                            BeenApplication.setToken(data.getData().getToken());
                        }
                        if (mView != null)
                            mView.loginSuccess(data);
                    }
                });
    }

    @Override
    public void getCode(String phone) {

        if (StringHelper.isEmpty(phone)) {
            if (mView != null)
                mView.showError("请输入用户名");
            return;
        }
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        if (StringHelper.isNotEmpty(phone)) {
            map.put("mobile_phone", phone);
        }

        map.put("sign", getSign(map));
        HttpRequest.createApi()
                .getCode(map)
                .compose(Transformer.<BaseData>switchSchedulers())
                .subscribe(new DataObserver<BaseData>() {
                    @Override
                    protected void onError(int errorCode, String errorMsg) {
                        if (mView != null)
                            mView.loginFail(errorCode, errorMsg);
                    }

                    @Override
                    protected void onSuccess(BaseData data) {
                        LogHelper.error("LoginBean:" + new Gson().toJson(data));
                        if (mView != null)
                            mView.getCodeSuccess(data);
                    }
                });
    }

    @Override
    public void attachView(LoginContract.View view) {
        mView = view;
    }

    @Override
    public void attachContext(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
