package com.bee.beeonline.main.buy;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bee.beeonline.R;
import com.bee.beeonline.base.RefreshLayoutBaseFragment;
import com.bee.beeonline.bean.CartBaseBean;
import com.bee.beeonline.bean.CartBean;
import com.bee.beeonline.bean.CartUpdate;
import com.bee.beeonline.bean.HomeDataBean;
import com.bee.beeonline.bean.HomeLikeBean;
import com.beeonline.library.helper.DisplayHelper;
import com.beeonline.library.helper.RVHelper;
import com.beeonline.library.helper.RecycleViewDivider;
import com.beeonline.library.helper.StringHelper;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class BuyFragment extends RefreshLayoutBaseFragment<HomeDataBean.Like, BuyPresenterImpl> implements BuyContract.BuyContractView {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.checkbox)
    CheckBox checkbox;
    @BindView(R.id.total_price)
    TextView total_price;
    @BindView(R.id.to_pay)
    TextView to_pay;
    RecommendAdapter adapter;
    List<CartBean> dataList = new ArrayList<>();
    RealBuyAdapter realBuyAdapter;


    public static BuyFragment newInstance() {
        return new BuyFragment();
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        initLayout(view);
        adapter = new RecommendAdapter(R.layout.item_home);
        realBuyAdapter = new RealBuyAdapter(R.layout.item_shop_car, dataList);
        adapter.addHeaderView(getHeadView());
        adapter.addHeaderView(getEView());
        StaggeredGridLayoutManager recyclerViewLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerViewLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);//不设置的话，图片闪烁错位，有可能有整列错位的情况。
        mRecyclerView.addItemDecoration(new RecycleViewDivider(mContext, LinearLayout.HORIZONTAL,
                DisplayHelper.dip2px(10), StringHelper.resColor(R.color.gray_ff)));//边距和分割线，需要自己定义
        mRecyclerView.setLayoutManager(recyclerViewLayoutManager);
        mRecyclerView.setAdapter(adapter);
    }


    @Override
    protected void loadData() {
        mPresenter.getCartData();
        mPresenter.getLikeData(start, rows);

    }

    @Override
    public void getLikeDataSuccess(HomeLikeBean baseData) {
        handleSuccess(adapter, baseData.getData().getData());
    }

    @Override
    public void getLikeDataFail(int code, String message) {
        hideAtyLoading();
        showToast(message);
    }

    @Override
    public void getCartDataSuccess(CartBaseBean baseData) {
        dataList.clear();
        dataList.addAll(baseData.getData().getCart());
        realBuyAdapter.notifyDataSetChanged();

        if (baseData.getData().getCart().size() <= 0) {
            emptyView.findViewById(R.id.empty_view).setVisibility(View.VISIBLE);
        } else {
            emptyView.findViewById(R.id.empty_view).setVisibility(View.GONE);
        }
    }

    @Override
    public void getCartDataFail(int code, String message) {

    }


    @Override
    public void cartUpdateSuccess(CartUpdate cartUpdate, int position, boolean isAdd) {

    }

    @Override
    public void cartDeleteSuccess(CartUpdate cartUpdate) {
        refreshLayout.autoRefresh();
    }

    @Override
    public void cartCancelSuccess(CartUpdate cartUpdate, final int position, final boolean isCheck) {

    }

    @Override
    public void cartCancelAllSuccess(CartUpdate cartUpdate) {

    }

    @Override
    public void cartSelectSuccess(CartUpdate cartUpdate, final int position, final boolean isCheck) {

    }

    @Override
    public void cartSelectAllSuccess(CartUpdate cartUpdate) {

    }

    @Override
    public void cartFail(int code, String message) {

    }

    @Override
    public void cartUpdateFail(int code, String message, int position, boolean isAdd) {
        if (isAdd) {
            dataList.get(position).setAmount(dataList.get(position).getAmount() - 1);
        } else {
            dataList.get(position).setAmount(dataList.get(position).getAmount() + 1);
        }
        realBuyAdapter.notifyDataSetChanged();
    }

    @Override
    public void cartSelectFail(int code, String message, int position, boolean isCheck) {
        if (isCheck) {
            dataList.get(position).setSelected(0);
        } else {
            dataList.get(position).setAmount(1);
        }
        realBuyAdapter.notifyDataSetChanged();
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
        return R.layout.activity_buy;
    }


    @Override
    public void initPresenter() {
        mPresenter = new BuyPresenterImpl();
    }

    @Override
    public void doBusiness() {
        if (null != refreshLayout)
            refreshLayout.autoRefresh();
    }

    public View getHeadView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.activity_real_buy, (ViewGroup) mRecyclerView.getParent(), false);
        RecyclerView recycler_view = view.findViewById(R.id.recycler_view);
        RVHelper.initRecyclerViewStyle(getActivity(), recycler_view, LinearLayout.VERTICAL);
        realBuyAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.cut:
                        if (dataList.get(position).getAmount() > 0) {
                            mPresenter.cartUpdate(dataList.get(position).getId(), dataList.get(position).getAmount() - 1, position, false);
                            dataList.get(position).setAmount(dataList.get(position).getAmount() - 1);
                            realBuyAdapter.notifyDataSetChanged();
                        }
                        break;
                    case R.id.add:
                        mPresenter.cartUpdate(dataList.get(position).getId(), dataList.get(position).getAmount() + 1, position, true);
                        dataList.get(position).setAmount(dataList.get(position).getAmount() + 1);
                        realBuyAdapter.notifyDataSetChanged();
                        break;
                    case R.id.checkbox:
                        if (dataList.get(position).getSelected() == 0) {
                            mPresenter.cartSelect(dataList.get(position).getId(), position, true);
                            dataList.get(position).setSelected(1);
                        } else {
                            mPresenter.cartCancel(dataList.get(position).getId(), position, false);
                            dataList.get(position).setSelected(0);
                        }
                        realBuyAdapter.notifyDataSetChanged();
                        break;
                    case R.id.delete:
                        List<String> list = new ArrayList<>();
                        list.add(dataList.get(position).getGoods_id() + "");
                        String json = new Gson().toJson(list);
                        mPresenter.cartDelete(json);
                    default:
                        break;
                }

            }
        });
        recycler_view.setAdapter(realBuyAdapter);
        return view;
    }

    View emptyView;

    public View getEView() {
        emptyView = LayoutInflater.from(getContext()).inflate(R.layout.view_recommend_hint_header, (ViewGroup) mRecyclerView.getParent(), false);
        return emptyView;
    }
}
