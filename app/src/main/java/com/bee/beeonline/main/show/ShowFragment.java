package com.bee.beeonline.main.show;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bee.beeonline.R;
import com.bee.beeonline.base.RefreshLayoutBaseFragment;
import com.bee.beeonline.bean.ShowBean;
import com.bee.beeonline.bean.ShowParentBean;
import com.beeonline.library.helper.DisplayHelper;
import com.beeonline.library.helper.RecycleViewDivider;
import com.beeonline.library.helper.StringHelper;

import butterknife.BindView;

public class ShowFragment extends RefreshLayoutBaseFragment<ShowBean, ShowPresenterImpl> implements ShowContract.ShowContractView {


    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private ShowAdapter homeAdapter;

    public static ShowFragment newInstance() {
        return new ShowFragment();
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        initLayout(view);
        homeAdapter = new ShowAdapter(R.layout.item_show);
        homeAdapter.addHeaderView(getEView());
        StaggeredGridLayoutManager recyclerViewLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerViewLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);//不设置的话，图片闪烁错位，有可能有整列错位的情况。
        mRecyclerView.addItemDecoration(new RecycleViewDivider(mContext, LinearLayout.HORIZONTAL,
                DisplayHelper.dip2px(10), StringHelper.resColor(R.color.white)));//边距和分割线，需要自己定义
        mRecyclerView.setLayoutManager(recyclerViewLayoutManager);
        mRecyclerView.setAdapter(homeAdapter);
    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    protected void loadData() {
        mPresenter.getShowData(start, rows);
    }

    @Override
    public void getShowDataSuccess(ShowParentBean baseData) {
        handleSuccess(homeAdapter, baseData.getData());
    }

    @Override
    public void getShowDataFail(int code, String message) {
        hideAtyLoading();
        showToast(message);

    }

    @Override
    public void showError(String msg) {
        hideAtyLoading();
        showToast(msg);
    }


    @Override
    public int bindLayout() {
        return R.layout.activity_show;
    }


    @Override
    public void initPresenter() {
        mPresenter = new ShowPresenterImpl();
    }

    @Override
    public void doBusiness() {
        if (null != refreshLayout)
            refreshLayout.autoRefresh();
    }


    public View getEView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.view_empty, (ViewGroup) mRecyclerView.getParent(), false);
        return view;
    }
}
