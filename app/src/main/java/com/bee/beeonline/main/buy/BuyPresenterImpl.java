package com.bee.beeonline.main.buy;

import android.content.Context;

import com.bee.beeonline.BeenApplication;
import com.bee.beeonline.base.BasePresenterImpl;
import com.bee.beeonline.bean.CartBaseBean;
import com.bee.beeonline.bean.CartUpdate;
import com.bee.beeonline.bean.HomeLikeBean;
import com.bee.beeonline.bean.ShowParentBean;
import com.bee.beeonline.http.HttpRequest;
import com.bee.beeonline.main.show.ShowContract;
import com.beeonline.library.helper.LogHelper;
import com.beeonline.library.httpapi.interceptor.Transformer;
import com.beeonline.library.httpapi.observer.DataObserver;
import com.google.gson.Gson;

import java.util.LinkedHashMap;

public class BuyPresenterImpl extends BasePresenterImpl implements BuyContract.Presenter {

    private BuyContract.BuyContractView mView;//根据这个view回调，需要写handle才能刷新页面
    private Context mContext;

    @Override
    public void getLikeData(int page, int size) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("page", page);
        map.put("per_page", size);
        map.put("sign", getSign(map));
        HttpRequest.createApi()
                .getHomeLikeData(map)
                .compose(Transformer.<HomeLikeBean>switchSchedulers())
                .subscribe(new DataObserver<HomeLikeBean>() {
                    @Override
                    protected void onError(int errorCode, String errorMsg) {
                        if (mView != null)
                            mView.getLikeDataFail(errorCode, errorMsg);
                    }

                    @Override
                    protected void onSuccess(HomeLikeBean data) {
                        LogHelper.error("LoginBean:" + new Gson().toJson(data));
                        if (mView != null)
                            mView.getLikeDataSuccess(data);
                    }
                });
    }

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
    public void cartUpdate(int good, int amount, final int position, final boolean isAdd) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("good", good);
        map.put("amount", amount);
        map.put("sign", getSign(map));
        HttpRequest.createApi()
                .cartUpdate(map)
                .compose(Transformer.<CartUpdate>switchSchedulers())
                .subscribe(new DataObserver<CartUpdate>() {
                    @Override
                    protected void onError(int errorCode, String errorMsg) {
                        if (mView != null)
                            mView.cartUpdateFail(errorCode, errorMsg, position, isAdd);
                    }

                    @Override
                    protected void onSuccess(CartUpdate data) {
                        if (mView != null)
                            mView.cartUpdateSuccess(data, position, isAdd);
                    }
                });
    }

    @Override
    public void cartDelete(String id) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("id", id);
        map.put("sign", getSign(map));
        HttpRequest.createApi()
                .cartDelete(map)
                .compose(Transformer.<CartUpdate>switchSchedulers())
                .subscribe(new DataObserver<CartUpdate>() {
                    @Override
                    protected void onError(int errorCode, String errorMsg) {
                        if (mView != null)
                            mView.cartFail(errorCode, errorMsg);
                    }

                    @Override
                    protected void onSuccess(CartUpdate data) {
                        if (mView != null)
                            mView.cartDeleteSuccess(data);
                    }
                });
    }

    @Override
    public void cartCancel(int id, final int position, final boolean isCheck) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("id", id);
        map.put("sign", getSign(map));
        HttpRequest.createApi()
                .cartCancel(map)
                .compose(Transformer.<CartUpdate>switchSchedulers())
                .subscribe(new DataObserver<CartUpdate>() {
                    @Override
                    protected void onError(int errorCode, String errorMsg) {
                        if (mView != null)
                            mView.cartSelectFail(errorCode, errorMsg, position, isCheck);
                    }

                    @Override
                    protected void onSuccess(CartUpdate data) {
                        if (mView != null)
                            mView.cartCancelSuccess(data, position, isCheck);
                    }
                });
    }

    @Override
    public void cartCancelAll() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("sign", getSign(map));
        HttpRequest.createApi()
                .cartCancelAll(map)
                .compose(Transformer.<CartUpdate>switchSchedulers())
                .subscribe(new DataObserver<CartUpdate>() {
                    @Override
                    protected void onError(int errorCode, String errorMsg) {
                        if (mView != null)
                            mView.cartFail(errorCode, errorMsg);
                    }

                    @Override
                    protected void onSuccess(CartUpdate data) {
                        if (mView != null)
                            mView.cartCancelAllSuccess(data);
                    }
                });
    }

    @Override
    public void cartSelect(int id, final int position, final boolean isCheck) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("id", id);
        map.put("sign", getSign(map));
        HttpRequest.createApi()
                .cartSelect(map)
                .compose(Transformer.<CartUpdate>switchSchedulers())
                .subscribe(new DataObserver<CartUpdate>() {
                    @Override
                    protected void onError(int errorCode, String errorMsg) {
                        if (mView != null)
                            mView.cartSelectFail(errorCode, errorMsg, position, isCheck);
                    }

                    @Override
                    protected void onSuccess(CartUpdate data) {
                        if (mView != null)
                            mView.cartSelectSuccess(data, position, isCheck);
                    }
                });
    }

    @Override
    public void cartSelectAll() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("sign", getSign(map));
        HttpRequest.createApi()
                .cartSelectAll(map)
                .compose(Transformer.<CartUpdate>switchSchedulers())
                .subscribe(new DataObserver<CartUpdate>() {
                    @Override
                    protected void onError(int errorCode, String errorMsg) {
                        if (mView != null)
                            mView.cartFail(errorCode, errorMsg);
                    }

                    @Override
                    protected void onSuccess(CartUpdate data) {
                        if (mView != null)
                            mView.cartSelectAllSuccess(data);
                    }
                });
    }

    @Override
    public void attachView(BuyContract.BuyContractView view) {
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
