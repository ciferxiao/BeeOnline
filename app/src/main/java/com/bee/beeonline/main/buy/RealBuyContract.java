package com.bee.beeonline.main.buy;

import com.bee.beeonline.bean.CartBaseBean;
import com.bee.beeonline.bean.HomeLikeBean;
import com.beeonline.library.base.BasePresenter;
import com.beeonline.library.base.BaseView;
import com.beeonline.library.httpapi.bean.BaseData;

public class RealBuyContract {

    public interface RealBuyContractView extends BaseView {

        void getCartDataSuccess(CartBaseBean baseData);

        void getCartDataFail(int code, String message);
    }

    public interface Presenter extends BasePresenter<RealBuyContract.RealBuyContractView> {
        void getCartData();
    }
}
