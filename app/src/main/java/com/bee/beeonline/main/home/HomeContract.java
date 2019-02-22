package com.bee.beeonline.main.home;

import com.bee.beeonline.bean.HomeDataBean;
import com.beeonline.library.base.BasePresenter;
import com.beeonline.library.base.BaseView;
import com.beeonline.library.httpapi.bean.BaseData;

public class HomeContract {


    public interface HomeContractView extends BaseView {

        void getHomeDataSuccess(HomeDataBean baseData);

        void getHomeDataFail(int code, String message);
    }

    public interface Presenter extends BasePresenter<HomeContractView> {
        void getHomeData(int page,int size);
    }
}
