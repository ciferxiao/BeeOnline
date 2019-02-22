package com.bee.beeonline.main.home.limit;

import com.bee.beeonline.bean.HomeDataBean;
import com.bee.beeonline.bean.LimitBaseBean;
import com.bee.beeonline.main.home.HomeContract;
import com.beeonline.library.base.BasePresenter;
import com.beeonline.library.base.BaseView;
import com.beeonline.library.httpapi.bean.BaseData;

public class LimitContract {


    public interface LimitContractView extends BaseView {

        void getSaleDataSuccess(LimitBaseBean baseData);

        void getSaleDataFail(int code, String message);
    }

    public interface Presenter extends BasePresenter<LimitContract.LimitContractView> {
        void getHomeSale(String act_name);
    }
}
