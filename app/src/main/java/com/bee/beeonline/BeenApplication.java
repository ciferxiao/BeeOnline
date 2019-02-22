package com.bee.beeonline;

import android.app.ActivityManager;
import android.content.Context;

import com.bee.beeonline.bean.LoginBean;
import com.bee.beeonline.http.HttpRequest;
import com.bee.beeonline.jpush.Extra;
import com.bee.beeonline.main.MainActivity;
import com.bee.beeonline.utils.Constant;
import com.beeonline.library.base.BaseApplication;
import com.beeonline.library.utils.DD;

import java.util.List;

import static com.beeonline.library.helper.SPHelper.getObject;
import static com.beeonline.library.helper.SPHelper.saveObject;

/**
 * Created by 59395 on 2018/3/4.
 */

public class BeenApplication extends BaseApplication {

    private LoginBean loginBean;
    public static Extra extra;

    public static BeenApplication instance() {
        return (BeenApplication) INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        HttpRequest.requestConfig();
//        CrashHandler.getInstance().setCustomCrashInfo(this);//崩溃日志
//        CrashHandler.getInstance().uploadBugly(this);  //开启腾讯Bugly
        DD.initALog(this);
//        initJPush();

    }



    /**
     * 获取用户
     *
     * @return todo 返回值可能为空 慎用
     */
    public LoginBean getLoginBean() {
        if (null != loginBean) {
            return loginBean;
        }
        loginBean = (LoginBean) getObject(Constant.LOGIN_BEAN);
        if (null != loginBean) {
            return loginBean;
        }
        return null;
    }

    /**
     * 设置用户
     *
     * @return
     */
    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
//        JPush.setAlias(this, loginBean.getData().getUser().getUser_id() + "");
        saveObject(Constant.LOGIN_BEAN, loginBean); //保存登录用户对象
    }


    public static boolean isRun() {
        return instance().containActivity(MainActivity.class);
    }

    public static void toFront() {
        if (!isFront()) {
            Object service = instance().getSystemService(Context.ACTIVITY_SERVICE);
            if (service == null)
                return;
            ActivityManager mAm = (ActivityManager) service;
            List<ActivityManager.RunningTaskInfo> taskList = mAm.getRunningTasks(100);
            for (ActivityManager.RunningTaskInfo rti : taskList) {
                //找到当前应用的task，并启动task的栈顶activity，达到程序切换到前台
                if (rti.topActivity.getPackageName().equals(instance().getPackageName())) {
                    mAm.moveTaskToFront(rti.id, ActivityManager.MOVE_TASK_WITH_HOME);
                    return;
                }
            }
        }
    }
}