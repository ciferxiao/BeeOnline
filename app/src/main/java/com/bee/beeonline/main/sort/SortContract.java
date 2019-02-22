package com.bee.beeonline.main.sort;

import com.bee.beeonline.bean.HomeLikeBean;
import com.bee.beeonline.bean.SortBean;
import com.bee.beeonline.bean.SortCate;
import com.beeonline.library.base.BasePresenter;
import com.beeonline.library.base.BaseView;
import com.beeonline.library.httpapi.bean.BaseData;

public class SortContract {

    public interface SortContractView extends BaseView {

        void getCateCondSuccess(SortBean baseData);

        void getCateCondFail(int code, String message);

        void getCateSuccess(SortCate baseData);

        void getCateFail(int code, String message);

        void getCateGoodsSuccess(HomeLikeBean baseData);

        void getCateGoodsFail(int code, String message);
    }


    public interface Presenter extends BasePresenter<SortContract.SortContractView> {
        void getCateCond();

        void getCate();

        void getCateGoods(int page, int size, int cat_id, String search, String brand, String effect, int min_price, int max_price, String sort);

    }
}
