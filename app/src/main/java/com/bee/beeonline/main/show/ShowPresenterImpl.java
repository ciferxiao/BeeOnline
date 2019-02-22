package com.bee.beeonline.main.show;

import android.content.Context;

import com.bee.beeonline.base.BasePresenterImpl;
import com.bee.beeonline.bean.HomeDataBean;
import com.bee.beeonline.bean.ShowParentBean;
import com.bee.beeonline.http.HttpRequest;
import com.bee.beeonline.main.home.HomeContract;
import com.beeonline.library.helper.LogHelper;
import com.beeonline.library.httpapi.interceptor.Transformer;
import com.beeonline.library.httpapi.observer.DataObserver;
import com.google.gson.Gson;

import java.util.LinkedHashMap;

public class ShowPresenterImpl extends BasePresenterImpl implements ShowContract.Presenter {

    private ShowContract.ShowContractView mView;//根据这个view回调，需要写handle才能刷新页面
    private Context mContext;

    @Override
    public void getShowData(int page, int size) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("page", page);
        map.put("per_page", size);
        map.put("sign", getSign(map));
        HttpRequest.createApi()
                .getShowData(map)
                .compose(Transformer.<ShowParentBean>switchSchedulers())
                .subscribe(new DataObserver<ShowParentBean>() {
                    @Override
                    protected void onError(int errorCode, String errorMsg) {
                        if (mView != null)
                            mView.getShowDataFail(errorCode, errorMsg);
                    }

                    @Override
                    protected void onSuccess(ShowParentBean data) {
                        LogHelper.error("LoginBean:" + new Gson().toJson(data));
                        if (mView != null)
                            mView.getShowDataSuccess(data);
                    }
                });
    }

    @Override
    public void attachView(ShowContract.ShowContractView view) {
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
