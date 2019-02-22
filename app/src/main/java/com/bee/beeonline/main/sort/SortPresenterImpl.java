package com.bee.beeonline.main.sort;

import android.content.Context;
import android.text.TextUtils;

import com.bee.beeonline.base.BasePresenterImpl;
import com.bee.beeonline.bean.HomeLikeBean;
import com.bee.beeonline.bean.ShowParentBean;
import com.bee.beeonline.bean.SortBean;
import com.bee.beeonline.bean.SortCate;
import com.bee.beeonline.http.HttpRequest;
import com.beeonline.library.helper.LogHelper;
import com.beeonline.library.httpapi.bean.BaseData;
import com.beeonline.library.httpapi.interceptor.Transformer;
import com.beeonline.library.httpapi.observer.DataObserver;
import com.google.gson.Gson;

import java.util.LinkedHashMap;

public class SortPresenterImpl extends BasePresenterImpl implements SortContract.Presenter {

    private SortContract.SortContractView mView;//根据这个view回调，需要写handle才能刷新页面
    private Context mContext;

    @Override
    public void getCateCond() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("sign", getSign(map));
        HttpRequest.createApi()
                .getCateCondData(map)
                .compose(Transformer.<SortBean>switchSchedulers())
                .subscribe(new DataObserver<SortBean>() {
                    @Override
                    protected void onError(int errorCode, String errorMsg) {
                        if (mView != null)
                            mView.getCateCondFail(errorCode, errorMsg);
                    }

                    @Override
                    protected void onSuccess(SortBean data) {
                        if (mView != null)
                            mView.getCateCondSuccess(data);
                    }
                });
    }

    @Override
    public void getCate() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("sign", getSign(map));
        HttpRequest.createApi()
                .getCateData(map)
                .compose(Transformer.<SortCate>switchSchedulers())
                .subscribe(new DataObserver<SortCate>() {
                    @Override
                    protected void onError(int errorCode, String errorMsg) {
                        if (mView != null)
                            mView.getCateFail(errorCode, errorMsg);
                    }

                    @Override
                    protected void onSuccess(SortCate data) {
                        if (mView != null)
                            mView.getCateSuccess(data);
                    }
                });

    }

    /**
     * cat_id	否	int	分类id
     * search	否	string	搜索词 注：cat_id与search必须选一个
     * brand	否	json string	品牌id 如：[1,2,3]
     * effect	否	string	功效：如 [“美白”,”护肤”]
     * min_price	否	int	最小价格
     * max_price	否	int	最大价格
     * sort	否	string	排序：综合： all，销量：sale-0 顺序，sale-1 倒序， 价格 price-0 顺序，price-1 倒序
     */
    @Override
    public void getCateGoods(int page, int size, int cat_id, String search, String brand, String effect, int min_price, int max_price, String sort) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("page", page);
        map.put("per_page", size);
        if (cat_id >= 0) {
            map.put("cat_id", cat_id);
        }
        if (!TextUtils.isEmpty(search)) {
            map.put("search", search);
        }
        if (!TextUtils.isEmpty(brand)) {
            map.put("brand", brand);
        }
        if (!TextUtils.isEmpty(effect)) {
            map.put("effect", effect);
        }
        if (min_price >= 0) {
            map.put("min_price", min_price);
        }
        if (max_price >= 0) {
            map.put("max_price", max_price);
        }
        if (!TextUtils.isEmpty(sort)) {
            map.put("sort", sort);
        }
        map.put("sign", getSign(map));
        HttpRequest.createApi()
                .getCateGoods(map)
                .compose(Transformer.<HomeLikeBean>switchSchedulers())
                .subscribe(new DataObserver<HomeLikeBean>() {
                    @Override
                    protected void onError(int errorCode, String errorMsg) {
                        if (mView != null)
                            mView.getCateGoodsFail(errorCode, errorMsg);
                    }

                    @Override
                    protected void onSuccess(HomeLikeBean data) {
                        if (mView != null)
                            mView.getCateGoodsSuccess(data);
                    }
                });
    }

    @Override
    public void attachView(SortContract.SortContractView view) {
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
