package com.bee.beeonline.main.order;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.bee.beeonline.R;
import com.bee.beeonline.base.RefreshLayoutBaseFragment;
import com.bee.beeonline.bean.OrderBaseBean;
import com.bee.beeonline.bean.OrderBean;
import com.beeonline.library.helper.RVHelper;
import com.chad.library.adapter.base.BaseQuickAdapter;

import butterknife.BindView;

public class OrderFragment extends RefreshLayoutBaseFragment<OrderBean, OrderPresenterImpl> implements OrderContract.OrderContractView {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private OrderAdapter adapter;
    private Integer mStatus;

    public static OrderFragment getInstance(int status) {
        OrderFragment fragment = new OrderFragment();
        Bundle args = new Bundle();
        args.putInt("status", status);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void showError(String msg) {
        hideAtyLoading();
        showToast(msg);
    }

    @Override
    public void initData(Bundle bundle) {
        mStatus = getArguments().getInt("status");
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_order;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        initLayout(view);
        RVHelper.initRecyclerViewStyle(mContext, mRecyclerView, LinearLayout.VERTICAL);
        adapter = new OrderAdapter(R.layout.item_order);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void initPresenter() {
        mPresenter = new OrderPresenterImpl();
    }

    @Override
    public void doBusiness() {
        if (null != refreshLayout)
            refreshLayout.autoRefresh();
    }

    @Override
    protected void loadData() {
        mPresenter.getOrderList(start, rows, mStatus, 0);

    }

    @Override
    public void getOrderDataSuccess(OrderBaseBean baseData) {
        handleSuccess(adapter, baseData.getData().getOrders());
    }

    @Override
    public void getOrderDataFail(int code, String message) {
        showError(message);
    }
}
