package com.bee.beeonline.main.order;

import com.bee.beeonline.bean.OrderBaseBean;
import com.bee.beeonline.bean.ShowParentBean;
import com.beeonline.library.base.BasePresenter;
import com.beeonline.library.base.BaseView;
import com.beeonline.library.httpapi.bean.BaseData;

public class OrderContract {

    public interface OrderContractView extends BaseView {

        void getOrderDataSuccess(OrderBaseBean baseData);

        void getOrderDataFail(int code, String message);
    }

    public interface Presenter extends BasePresenter<OrderContract.OrderContractView> {
        void getOrderList(int page, int size, int status, int is_wholesale);

    }
}
