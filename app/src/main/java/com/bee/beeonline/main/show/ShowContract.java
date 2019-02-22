package com.bee.beeonline.main.show;

import com.bee.beeonline.bean.HomeDataBean;
import com.bee.beeonline.bean.ShowParentBean;
import com.beeonline.library.base.BasePresenter;
import com.beeonline.library.base.BaseView;

public class ShowContract {

    public interface ShowContractView extends BaseView {

        void getShowDataSuccess(ShowParentBean baseData);

        void getShowDataFail(int code, String message);
    }

    public interface Presenter extends BasePresenter<ShowContractView> {
        void getShowData(int page, int size);

    }
}
