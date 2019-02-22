package com.bee.beeonline.base;

import android.view.View;
import android.widget.TextView;

import com.bee.beeonline.R;
import com.beeonline.library.base.BaseFragment;
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

public abstract class RefreshLayoutBaseFragment<T, V extends BasePresenter> extends BaseFragment<V> implements OnRefreshLoadMoreListener {
    protected final int REFRESH = 654654;
    protected final int LOADMORE = 685463541;
    @BindView(R.id.refresh_layout)
    protected RefreshLayout refreshLayout;
    //    @BindView(R.id.empty_view)
    protected EmptyUI emptyView;

    protected int loadType = -1;
    protected int start = -1;
    protected int rows = 20;

    protected void initLayout(View view) {
        ButterKnife.bind(this, view);
        initRefreshLayout();
    }

    protected void initRefreshLayout() {
        if (refreshLayout != null) refreshLayout.setOnRefreshLoadMoreListener(this);
        emptyView = new EmptyUI(getActivity());
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

    protected void handleSuccess(BaseQuickAdapter<T, ? extends BaseViewHolder> adapter, List<T> datas) {
        if (adapter.getEmptyView() == null) {
            adapter.setEmptyView(emptyView.view);
            adapter.setHeaderAndEmpty(true);
        }
        if (refreshLayout == null) {
            return;
        }
        if (loadType == REFRESH) {
            refreshLayout.finishRefresh();
            if (datas.size() > 0) {
                adapter.setNewData(datas);
                adapter.notifyDataSetChanged();
            } else {
                adapter.setNewData(datas);
                adapter.notifyDataSetChanged();
//                emptyView.loadFail("暂无数据", getResId(Constant.NULL_POINTER_EXCEPTION));
            }
            if (datas.size() < rows)
                refreshLayout.finishLoadMoreWithNoMoreData();
        } else if (loadType == LOADMORE) {
            if (datas.size() > 0) {
                adapter.addData(datas);
                adapter.notifyDataSetChanged();
                if (datas.size() < rows)
                    refreshLayout.finishLoadMoreWithNoMoreData();
                else
                    refreshLayout.finishLoadMore();
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
        } else {
            refreshLayout.finishLoadMore();
        }
    }

    //匹配状态图标
    private int getResId(int errorCode) {
        int resId = R.mipmap.ic_launcher;
        switch (errorCode) {
            case Constant.TIMEOUT_ERROR:  //无网络设置
                resId = R.mipmap.ic_launcher;
                break;
            case Constant.NULL_POINTER_EXCEPTION://数据加载失败
                resId = R.mipmap.ic_launcher;
                break;
        }
        return resId;
    }


    //点击控件重新加载
    public void reloadLayoutClick() {
        if (refreshLayout != null) {
            refreshLayout.autoRefresh();
        }
    }

    public void setLoadMoreEnable(boolean enable) {
        refreshLayout.setEnableLoadMore(enable);
    }

    //加载数据
    protected abstract void loadData();


    public String title = "";
    public TextView tvTitle;

    public void setTvTitle(TextView tvTitle, String title) {
        this.tvTitle = tvTitle;
        this.title = title;
    }
}
