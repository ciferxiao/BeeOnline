package com.bee.beeonline.main.order;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.bee.beeonline.R;
import com.bee.beeonline.base.RefreshLayoutBaseFragment;
import com.bee.beeonline.utils.Constant;
import com.beeonline.library.base.BaseActivity;
import com.beeonline.library.base.BaseFragmentAdapter;
import com.beeonline.library.widget.TabIndicator;
import com.wuhenzhizao.titlebar.widget.CommonTitleBar;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderActivity extends BaseActivity {


    @BindView(R.id.title_bar)
    CommonTitleBar mTitleBar;
    @BindView(R.id.tab_indicator)
    TabIndicator mTabIndicator;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    OrderFragment[] fragments;

    public static void startActivity(Context context, int status) {
        Intent intent = new Intent(context, OrderActivity.class);
        intent.putExtra("status", status);
        context.startActivity(intent);
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
    public void showError(String msg) {

    }

    @Override
    public void initData(Bundle bundle) {
//        EventBus.getDefault().register(this);
    }

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onEventToPage() {
//
//    }

    @Override
    public int bindLayout() {
        return R.layout.activity_order;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        ButterKnife.bind(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void doBusiness() {
        String[] titles = {"全部", "待付款", "待发货", "待收货", "待评价"};
        mTabIndicator.setTabTitles(titles);
        mTabIndicator.setOnTabClickListener(new TabIndicator.onTabClickListener() {
            @Override
            public void onTabClick(String title, int position) {
                mViewPager.setCurrentItem(position);
            }
        });
        fragments = new OrderFragment[]{OrderFragment.getInstance(Constant.ORDER_STATUS1),
                OrderFragment.getInstance(Constant.ORDER_STATUS2), OrderFragment.getInstance(Constant.ORDER_STATUS3), OrderFragment.getInstance(Constant.ORDER_STATUS4), OrderFragment.getInstance(Constant.ORDER_STATUS5)};
        // 自定义设置
        mTabIndicator.setViewPage(mViewPager, new BaseFragmentAdapter(getSupportFragmentManager(), fragments));
        mViewPager.setOffscreenPageLimit(fragments.length);
//        for (int index = 0; index < titles.length; index++) {
//            RefreshLayoutBaseFragment fragment = fragments[index];
//            fragment.setTvTitle(mTabIndicator.getTextView(index), titles[index]);
//        }
    }
}
