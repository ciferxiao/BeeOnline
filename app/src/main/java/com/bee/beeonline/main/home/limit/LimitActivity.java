package com.bee.beeonline.main.home.limit;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bee.beeonline.R;
import com.bee.beeonline.bean.LimitBaseBean;
import com.bee.beeonline.bean.LimitInfo;
import com.bee.beeonline.bean.ProductBean;
import com.beeonline.library.base.BaseActivity;
import com.beeonline.library.helper.DisplayHelper;
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
import butterknife.OnClick;

public class LimitActivity extends BaseActivity<LimitPresenterImpl> implements LimitContract.LimitContractView {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.refresh_layout)
    protected RefreshLayout refreshLayout;
    LimitAdapter adapter;
    private List<ProductBean> list = new ArrayList<>();

    @Override
    public void showError(String msg) {
        hideLoading();
        showToast(msg);
    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        immersionBar.fitsSystemWindows(true)
                .statusBarColor(R.color.white)
                .statusBarDarkFont(true, 0.2f)
                .init();
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_home_limit;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        ButterKnife.bind(this, view);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                doBusiness();
            }
        });
    }

    private void initAdapter() {
        RVHelper.initRecyclerViewStyle(this, recyclerView, LinearLayout.VERTICAL);
        adapter = new LimitAdapter(R.layout.item_limit, list);
        adapter.addHeaderView(getHeaderView());
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
        recyclerView.setAdapter(adapter);

    }


    @Override
    public void initPresenter() {
        mPresenter = new LimitPresenterImpl();
    }

    @Override
    public void doBusiness() {
        initAdapter();
        mPresenter.getHomeSale("");
    }

    @Override
    public void getSaleDataSuccess(LimitBaseBean baseData) {

        list.clear();
        list.addAll(baseData.getData().getData().get(0).getProducts());
        adapter.notifyDataSetChanged();

        initHeaderView(baseData.getData().getInfo(), baseData.getData().getData().get(0).getAct_id());

        refreshLayout.finishLoadMore();
        refreshLayout.finishRefresh();

    }

    private void initHeaderView(List<LimitInfo> limitInfos, int id) {

        LinearLayout layout_content = headerView.findViewById(R.id.layout_content);

        layout_content.removeAllViews();
        for (int i = 0; i < limitInfos.size(); i++) {
            LimitInfo info = limitInfos.get(i);

            View child = LayoutInflater.from(this).inflate(R.layout.item_limit_header_child, null);

            LinearLayout layout_child = child.findViewById(R.id.layout_child);

            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) layout_child.getLayoutParams();
            params.width = DisplayHelper.screenW() / limitInfos.size();
            layout_child.setLayoutParams(params);

            final TextView time = child.findViewById(R.id.time);
            TextView name = child.findViewById(R.id.name);

            if (info.getStatus() == 0) {
                name.setText("已开抢");
            } else if (info.getStatus() == 1) {
                name.setText("正在抢购");
            } else if (info.getStatus() == 2) {
                name.setText("即将开抢");
            }
            time.setText(info.getAct_name());
            if (id == info.getAct_id()) {
                layout_child.setBackgroundColor(getResources().getColor(R.color.red_ff0000));
                name.setTextColor(getResources().getColor(R.color.white));
                time.setTextColor(getResources().getColor(R.color.white));

            } else {
                layout_child.setBackgroundColor(getResources().getColor(R.color.white));
                name.setTextColor(getResources().getColor(R.color.black_7b));
                time.setTextColor(getResources().getColor(R.color.black_7b));
            }

            layout_child.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPresenter.getHomeSale(time.getText() + "");
                }
            });
            layout_content.addView(child);
        }

    }

    @Override
    public void getSaleDataFail(int code, String message) {
        hideLoading();
        refreshLayout.finishLoadMore();
        refreshLayout.finishRefresh();
        showToast(message);
    }


    @OnClick({R.id.layout_back})
    public void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.layout_back:
                onBackPressed();
                break;
        }
    }

    View headerView;

    public View getHeaderView() {
        headerView = LayoutInflater.from(this).inflate(R.layout.item_limit_header, null);
        return headerView;
    }
}
