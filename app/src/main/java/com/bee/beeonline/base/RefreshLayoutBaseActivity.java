package com.bee.beeonline.base;

import android.view.View;

import com.bee.beeonline.R;
import com.beeonline.library.base.BaseActivity;
import com.beeonline.library.base.BasePresenter;
import com.beeonline.library.helper.LogHelper;
import com.beeonline.library.utils.Constant;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by liuzq on 2018/3/8.
 */

public abstract class RefreshLayoutBaseActivity<T, V extends BasePresenter> extends BaseActivity<V> implements OnRefreshLoadMoreListener {

    protected final int REFRESH = 654654;
    protected final int LOADMORE = 685463541;
    @BindView(R.id.refresh_layout)
    protected RefreshLayout refreshLayout;
    @BindView(R.id.empty_view)
    protected EmptyView emptyView;

    protected int loadType = -1;
    protected int start = -1;
    protected int rows = 20;
    protected boolean loadMoreEnable = true;

    protected void initLayout() {
        ButterKnife.bind(this);
        initRefreshLayout();
        refreshLayout.setEnableLoadMore(loadMoreEnable);
    }

    public void setLoadMoreEnable(boolean loadMoreEnable) {
        this.loadMoreEnable = loadMoreEnable;
        refreshLayout.setEnableLoadMore(loadMoreEnable);
    }

    protected void initRefreshLayout() {
        if (refreshLayout != null) refreshLayout.setOnRefreshLoadMoreListener(this);
        if (emptyView != null && refreshLayout != null) {
            emptyView.bind((View) refreshLayout);
            emptyView.getLayoutReload().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    reloadLayoutClick();
                }
            });
        }
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        loadType = REFRESH;
        start = 1;
        LogHelper.error("panmengfrag onRefresh", "start = " + start);
        loadData();
    }

    @Override
    public void onLoadMore(RefreshLayout refreshlayout) {
        loadType = LOADMORE;
        start++;
        LogHelper.error("panmengfrag onLoadmore", "start = " + start);
        loadData();
    }

    protected boolean showEmptyView = true;

    protected void handleSuccess(BaseQuickAdapter<T, ? extends BaseViewHolder> adapter, List<T> datas) {
        if (refreshLayout == null) {
            return;
        }
        if (loadType == REFRESH) {
            refreshLayout.finishRefresh();
            if (datas.size() > 0) {
                emptyView.loadSuccess();
                adapter.setNewData(datas);
                adapter.notifyDataSetChanged();
            } else {
                if (adapter != null) {
                    adapter.setNewData(datas);
                    adapter.notifyDataSetChanged();
                }
                if (!showEmptyView) {
                    emptyView.loadSuccess();
                } else {
                    emptyView.loadFail("暂无数据", getResId(Constant.NULL_POINTER_EXCEPTION));
                }
            }
        } else if (loadType == LOADMORE) {
            if (datas.size() > 0) {
                adapter.addData(datas);
                adapter.notifyDataSetChanged();
                if (datas.size() < rows) {
                    refreshLayout.finishLoadMoreWithNoMoreData();
                } else {
                    refreshLayout.finishLoadMore();
                }
            } else {
                refreshLayout.finishLoadMoreWithNoMoreData();
            }
        }

    }

    protected void handleFailure(int errorCode, String errorMessage) {
        if (refreshLayout == null) {
            return;
        }
        if (loadType == REFRESH) {
            refreshLayout.finishRefresh();
            emptyView.loadFail(errorMessage, getResId(errorCode));
        } else {
            refreshLayout.finishLoadMore();
            emptyView.loadFail(errorMessage, getResId(errorCode));
        }
    }

    //匹配状态图标
    private int getResId(int errorCode) {
        int resId = R.mipmap.empty_layout;
        switch (errorCode) {
            case Constant.TIMEOUT_ERROR:  //无网络设置
                resId = R.mipmap.empty_layout;
                break;
            case Constant.NULL_POINTER_EXCEPTION://数据加载失败
                resId = R.mipmap.empty_layout;
                break;
        }
        return resId;
    }

    //点击控件重新加载
    public void reloadLayoutClick() {
        if (refreshLayout != null) refreshLayout.autoRefresh();
    }

    //加载数据
    protected abstract void loadData();
}
