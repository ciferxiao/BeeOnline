package com.bee.beeonline.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.bee.beeonline.R;
import com.bee.beeonline.main.buy.BuyFragment;
import com.bee.beeonline.main.home.HomeFragment;
import com.bee.beeonline.main.me.UserFragment;
import com.bee.beeonline.main.show.ShowFragment;
import com.bee.beeonline.main.sort.SortFragment;
import com.bee.beeonline.utils.Util;
import com.beeonline.library.base.BaseActivity;
import com.beeonline.library.base.BasePagerAdapter;
import com.beeonline.library.widget.FixViewPager;
import com.beeonline.library.widget.bottombar.BottomBarLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements BottomBarLayout.OnItemClickListener {

    @BindView(R.id.viewpager)
    FixViewPager mViewPager;
    @BindView(R.id.bottom_nav)
    BottomBarLayout bottomBarLayout;

    List<Fragment> mFragments;


    private int normalTextColor = Color.parseColor("#7b7b7b");
    private int selectTextColor = Color.parseColor("#FCC91C");


    public static void startActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void showError(String msg) {

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
    public void initData(Bundle bundle) {
//        EventBus.getDefault().register(this);

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        ButterKnife.bind(this);
        bottomBarLayout.setNormalTextColor(normalTextColor);
        bottomBarLayout.setSelectTextColor(selectTextColor);
        bottomBarLayout.setTabList(Util.getTabEntitys());
        bottomBarLayout.setOnItemClickListener(this);
        mFragments = new ArrayList<>();
        mFragments.add(HomeFragment.newInstance());
        mFragments.add(SortFragment.newInstance());
        mFragments.add(ShowFragment.newInstance());
        mFragments.add(BuyFragment.newInstance());
        mFragments.add(UserFragment.newInstance());
        new BasePagerAdapter(getSupportFragmentManager(), mViewPager, mFragments);
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void doBusiness() {
        mViewPager.setCurrentItem(0);
    }

    @Override
    public void onItemClick(int position) {
        mViewPager.setCurrentItem(position);
    }
}
