package com.bee.beeonline.main.order;

import android.content.Context;

import com.bee.beeonline.base.BasePresenterImpl;
import com.bee.beeonline.bean.OrderBaseBean;
import com.bee.beeonline.bean.ShowParentBean;
import com.bee.beeonline.http.HttpRequest;
import com.bee.beeonline.main.show.ShowContract;
import com.beeonline.library.helper.LogHelper;
import com.beeonline.library.httpapi.bean.BaseData;
import com.beeonline.library.httpapi.interceptor.Transformer;
import com.beeonline.library.httpapi.observer.DataObserver;
import com.google.gson.Gson;

import java.util.LinkedHashMap;

public class OrderPresenterImpl extends BasePresenterImpl implements OrderContract.Presenter {

    private OrderContract.OrderContractView mView;//根据这个view回调，需要写handle才能刷新页面
    private Context mContext;


    @Override
    public void getOrderList(int page, int size, int status, int is_wholesale) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("page", page);
        map.put("per_page", size);
        map.put("status", status);
        map.put("is_wholesale", is_wholesale);
        map.put("sign", getSign(map));
        HttpRequest.createApi()
                .orderList(map)
                .compose(Transformer.<OrderBaseBean>switchSchedulers())
                .subscribe(new DataObserver<OrderBaseBean>() {
                    @Override
                    protected void onError(int errorCode, String errorMsg) {
                        if (mView != null)
                            mView.getOrderDataFail(errorCode, errorMsg);
                    }

                    @Override
                    protected void onSuccess(OrderBaseBean data) {
                        LogHelper.error("LoginBean:" + new Gson().toJson(data));
                        if (mView != null)
                            mView.getOrderDataSuccess(data);
                    }
                });
    }

    @Override
    public void attachView(OrderContract.OrderContractView view) {
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
