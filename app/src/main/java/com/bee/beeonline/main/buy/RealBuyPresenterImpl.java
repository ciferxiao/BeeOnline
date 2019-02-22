package com.bee.beeonline.main.buy;

import android.content.Context;

import com.bee.beeonline.BeenApplication;
import com.bee.beeonline.base.BasePresenterImpl;
import com.bee.beeonline.bean.CartBaseBean;
import com.bee.beeonline.bean.HomeLikeBean;
import com.bee.beeonline.http.HttpRequest;
import com.beeonline.library.helper.LogHelper;
import com.beeonline.library.httpapi.bean.BaseData;
import com.beeonline.library.httpapi.interceptor.Transformer;
import com.beeonline.library.httpapi.observer.DataObserver;
import com.google.gson.Gson;

import java.util.LinkedHashMap;

public class RealBuyPresenterImpl extends BasePresenterImpl implements RealBuyContract.Presenter {


    private RealBuyContract.RealBuyContractView mView;//根据这个view回调，需要写handle才能刷新页面
    private Context mContext;

    @Override
    public void getCartData() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("token", BeenApplication.getToken());
        map.put("sign", getSign(map));
        HttpRequest.createApi()
                .getCartListData(map)
                .compose(Transformer.<CartBaseBean>switchSchedulers())
                .subscribe(new DataObserver<CartBaseBean>() {
                    @Override
                    protected void onError(int errorCode, String errorMsg) {
                        if (mView != null)
                            mView.getCartDataFail(errorCode, errorMsg);
                    }

                    @Override
                    protected void onSuccess(CartBaseBean data) {
                        if (mView != null)
                            mView.getCartDataSuccess(data);
                    }
                });
    }

    @Override
    public void attachView(RealBuyContract.RealBuyContractView view) {
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
