package com.bee.beeonline.main.home;

import android.content.Context;

import com.bee.beeonline.base.BasePresenterImpl;
import com.bee.beeonline.bean.HomeDataBean;
import com.bee.beeonline.http.HttpRequest;
import com.beeonline.library.helper.LogHelper;
import com.beeonline.library.helper.StringHelper;
import com.beeonline.library.httpapi.bean.BaseData;
import com.beeonline.library.httpapi.interceptor.Transformer;
import com.beeonline.library.httpapi.observer.DataObserver;
import com.google.gson.Gson;

import java.util.LinkedHashMap;

public class HomePresenterImpl extends BasePresenterImpl implements HomeContract.Presenter {

    private HomeContract.HomeContractView mView;//根据这个view回调，需要写handle才能刷新页面
    private Context mContext;

    @Override
    public void getHomeData(int page, int size) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("page", page);
        map.put("app_type", 1);
        map.put("per_page", size);
        map.put("sign", getSign(map));
        HttpRequest.createApi()
                .getHomeData(map)
                .compose(Transformer.<HomeDataBean>switchSchedulers())
                .subscribe(new DataObserver<HomeDataBean>() {
                    @Override
                    protected void onError(int errorCode, String errorMsg) {
                        if (mView != null)
                            mView.getHomeDataFail(errorCode, errorMsg);
                    }

                    @Override
                    protected void onSuccess(HomeDataBean data) {
                        LogHelper.error("LoginBean:" + new Gson().toJson(data));
                        if (mView != null)
                            mView.getHomeDataSuccess(data);
                    }
                });
    }

    @Override
    public void attachView(HomeContract.HomeContractView view) {
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
