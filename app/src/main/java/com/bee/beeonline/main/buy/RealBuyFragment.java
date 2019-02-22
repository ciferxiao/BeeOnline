package com.bee.beeonline.main.buy;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.bee.beeonline.R;
import com.bee.beeonline.bean.CartBaseBean;
import com.bee.beeonline.bean.CartBean;
import com.bee.beeonline.main.sort.SortLeftAdapter;
import com.beeonline.library.base.BaseFragment;
import com.beeonline.library.helper.RVHelper;
import com.beeonline.library.helper.RecycleViewDivider;
import com.beeonline.library.helper.StringHelper;
import com.beeonline.library.httpapi.bean.BaseData;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RealBuyFragment extends BaseFragment<RealBuyPresenterImpl> implements RealBuyContract.RealBuyContractView {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    RealBuyAdapter adapter;
    List<CartBean> dataList = new ArrayList<>();

    public static RealBuyFragment newInstance() {
        return new RealBuyFragment();
    }


    @Override
    public void getCartDataSuccess(CartBaseBean baseData) {
        dataList.clear();
        dataList.addAll(baseData.getData().getCart());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void getCartDataFail(int code, String message) {
        hideAtyLoading();
        showToast(message);
    }

    @Override
    public void showError(String msg) {
        hideAtyLoading();
        showToast(msg);
    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_real_buy;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        ButterKnife.bind(this, view);
        RVHelper.initRecyclerViewStyle(getActivity(), recyclerView, LinearLayout.VERTICAL);
        adapter = new RealBuyAdapter(R.layout.item_shop_car, dataList);
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
//                    case R.id.layout_content:
//                        setCheck(position);
//                        break;
                    default:
                        break;
                }

            }
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void initPresenter() {
        mPresenter = new RealBuyPresenterImpl();

    }

    @Override
    public void doBusiness() {
        mPresenter.getCartData();
    }
}
