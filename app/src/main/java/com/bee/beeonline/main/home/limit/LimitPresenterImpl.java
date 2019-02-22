package com.bee.beeonline.main.home.limit;

import android.content.Context;

import com.bee.beeonline.base.BasePresenterImpl;
import com.bee.beeonline.bean.HomeDataBean;
import com.bee.beeonline.bean.LimitBaseBean;
import com.bee.beeonline.http.HttpRequest;
import com.bee.beeonline.main.home.HomeContract;
import com.beeonline.library.helper.LogHelper;
import com.beeonline.library.httpapi.bean.BaseData;
import com.beeonline.library.httpapi.interceptor.Transformer;
import com.beeonline.library.httpapi.observer.DataObserver;
import com.google.gson.Gson;

import java.util.LinkedHashMap;

public class LimitPresenterImpl extends BasePresenterImpl implements LimitContract.Presenter {

    private LimitContract.LimitContractView mView;//根据这个view回调，需要写handle才能刷新页面
    private Context mContext;

    @Override
    public void getHomeSale(String act_name) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("act_name", act_name);
        map.put("sign", getSign(map));
        HttpRequest.createApi()
                .getHomeSale(map)
                .compose(Transformer.<LimitBaseBean>switchSchedulers())
                .subscribe(new DataObserver<LimitBaseBean>() {
                    @Override
                    protected void onError(int errorCode, String errorMsg) {
                        if (mView != null)
                            mView.getSaleDataFail(errorCode, errorMsg);
                    }

                    @Override
                    protected void onSuccess(LimitBaseBean data) {
                        if (mView != null)
                            mView.getSaleDataSuccess(data);
                    }
                });
    }

    @Override
    public void attachView(LimitContract.LimitContractView view) {
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
