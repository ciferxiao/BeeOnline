package com.bee.beeonline.main.sort;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.bee.beeonline.R;
import com.bee.beeonline.bean.EffectBean;
import com.bee.beeonline.bean.HomeDataBean;
import com.bee.beeonline.bean.HomeLikeBean;
import com.bee.beeonline.bean.SortBean;
import com.bee.beeonline.bean.SortCate;
import com.bee.beeonline.main.home.HomeBrandsAdapter;
import com.beeonline.library.base.BaseFragment;
import com.beeonline.library.helper.AndroidHelper;
import com.beeonline.library.helper.DisplayHelper;
import com.beeonline.library.helper.RVHelper;
import com.beeonline.library.helper.RecycleViewDivider;
import com.beeonline.library.helper.StringHelper;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SortFragment extends BaseFragment<SortPresenterImpl> implements SortContract.SortContractView {

    @BindView(R.id.left_recycler_view)
    RecyclerView mLeftRecyclerView;
    @BindView(R.id.gridView)
    GridView mRightGridView;
    @BindView(R.id.refresh_layout)
    SmartRefreshLayout refreshLayout;
    private List<SortCate.SortCateBase> effectBeans = new ArrayList<>();
    private List<SortCate.SortCateBase> rightBeans = new ArrayList<>();
    private SortLeftAdapter sortLeftAdapter;
    private SortRightAdapter gridAdapter;

    public static SortFragment newInstance() {
        return new SortFragment();
    }

    @Override
    public void getCateCondSuccess(SortBean baseData) {

    }

    private void setCheck(int position) {
        for (int i = 0; i < effectBeans.size(); i++) {
            effectBeans.get(i).setCheck(i == position);
            if (i == position) {
                rightBeans.clear();
                if (effectBeans.get(i).getChilds() != null) {
                    rightBeans.addAll(effectBeans.get(i).getChilds());
                }
                gridAdapter.notifyDataSetChanged();
            }
//            mPresenter.getCateGoods(0, Integer.MAX_VALUE, sortLeftAdapter.getData().get(position).getCat_id(), "", "", "", -1, -1, "");
        }
        sortLeftAdapter.notifyDataSetChanged();
    }

    @Override
    public void getCateCondFail(int code, String message) {
        hideAtyLoading();
        showToast(message);
    }

    @Override
    public void getCateSuccess(SortCate baseData) {
        hideAtyLoading();
        effectBeans.clear();
        effectBeans.addAll(baseData.getData());
        sortLeftAdapter.setNewData(effectBeans);
        refreshLayout.finishRefresh();
        refreshLayout.finishLoadMore();
        setCheck(0);
    }

    @Override
    public void getCateFail(int code, String message) {
        refreshLayout.finishRefresh();
        refreshLayout.finishLoadMore();
        hideAtyLoading();
        showToast(message);
    }

    @Override
    public void getCateGoodsSuccess(HomeLikeBean baseData) {

    }

    @Override
    public void getCateGoodsFail(int code, String message) {
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
        return R.layout.activity_sort;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        ButterKnife.bind(this, view);
        refreshLayout.setEnableLoadMore(false);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                doBusiness();
            }
        });
        initLeftRecycleView();
        initRightRecycleView();
    }

    private void initRightRecycleView() {
        gridAdapter = new SortRightAdapter(getActivity(), rightBeans);
        mRightGridView.setAdapter(gridAdapter);

        mRightGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FilterActivity.startActivity(getActivity(), rightBeans.get(position).getCat_id(), "", rightBeans.get(position).getCat_name());
            }
        });
        gridAdapter.notifyDataSetChanged();

    }

    private void initLeftRecycleView() {
        RVHelper.initRecyclerViewStyle(getActivity(), mLeftRecyclerView, LinearLayout.VERTICAL);
        mLeftRecyclerView.addItemDecoration(new RecycleViewDivider(mContext, LinearLayout.HORIZONTAL,
                40, StringHelper.resColor(R.color.gray_f6)));
        sortLeftAdapter = new SortLeftAdapter(R.layout.item_sort_left);
        sortLeftAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.layout_content:
                        setCheck(position);
                        break;
                    default:
                        break;
                }

            }
        });
        mLeftRecyclerView.setAdapter(sortLeftAdapter);
    }

    @Override
    public void initPresenter() {
        mPresenter = new SortPresenterImpl();
    }

    @Override
    public void doBusiness() {
        mPresenter.getCate();
    }
}
