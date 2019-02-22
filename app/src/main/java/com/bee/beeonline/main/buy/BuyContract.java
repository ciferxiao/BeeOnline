package com.bee.beeonline.main.buy;

import com.bee.beeonline.bean.CartBaseBean;
import com.bee.beeonline.bean.CartUpdate;
import com.bee.beeonline.bean.HomeLikeBean;
import com.bee.beeonline.bean.ShowParentBean;
import com.bee.beeonline.main.show.ShowContract;
import com.beeonline.library.base.BasePresenter;
import com.beeonline.library.base.BaseView;

public class BuyContract {
    public interface BuyContractView extends BaseView {

        void getLikeDataSuccess(HomeLikeBean baseData);

        void getLikeDataFail(int code, String message);

        void getCartDataSuccess(CartBaseBean baseData);

        void getCartDataFail(int code, String message);

        void cartUpdateSuccess(CartUpdate cartUpdate, int position, boolean isAdd);

        void cartDeleteSuccess(CartUpdate cartUpdate);

        void cartCancelSuccess(CartUpdate cartUpdate, int position, boolean isCheck);

        void cartCancelAllSuccess(CartUpdate cartUpdate);

        void cartSelectSuccess(CartUpdate cartUpdate, int position, boolean isCheck);

        void cartSelectAllSuccess(CartUpdate cartUpdate);

        void cartFail(int code, String message);

        void cartUpdateFail(int code, String message, int position, boolean isAdd);

        void cartSelectFail(int code, String message, int position, boolean isCheck);

    }

    public interface Presenter extends BasePresenter<BuyContract.BuyContractView> {

        void getLikeData(int page, int size);

        void getCartData();

        void cartUpdate(int good, int amount, int position, boolean isAdd);

        void cartDelete(String id);

        void cartCancel(int id, int position, boolean isCheck);

        void cartCancelAll();

        void cartSelect(int id, int position, boolean isCheck);

        void cartSelectAll();

    }
}
