package com.bee.beeonline.bean;

import com.beeonline.library.httpapi.bean.BaseData;

import java.io.Serializable;

/**
 * Created by 59395 on 2018/3/3.
 */

public class LoginBean extends BaseData {

    private LoginData data;

    public LoginData getData() {
        return data;
    }

    public void setData(LoginData data) {
        this.data = data;
    }

    public class LoginData{
        private String token;
        private UserBean user;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }
    }

}
