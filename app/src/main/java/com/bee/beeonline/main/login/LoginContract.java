package com.bee.beeonline.main.login;

import com.bee.beeonline.bean.LoginBean;
import com.beeonline.library.base.BasePresenter;
import com.beeonline.library.base.BaseView;
import com.beeonline.library.httpapi.bean.BaseData;

/**
 * Created by 59395 on 2018/3/3.
 */

public class LoginContract {
    public interface View extends BaseView {

        void loginSuccess(LoginBean loginBean);

        void loginFail(int code, String message);

        void getCodeSuccess(BaseData loginBean);

        void getCodeFail(int code, String message);
    }

    public interface Presenter extends BasePresenter<View> {
        //post登录
        void postLogin(String userName, String password,String code);

        void getCode(String phone);
    }
}
