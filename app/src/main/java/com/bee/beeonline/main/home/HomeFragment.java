package com.bee.beeonline.main.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bee.beeonline.R;
import com.bee.beeonline.base.RefreshLayoutBaseFragment;
import com.bee.beeonline.bean.HomeDataBean;
import com.bee.beeonline.bean.Products;
import com.bee.beeonline.main.home.limit.LimitActivity;
import com.bee.beeonline.main.show.WebActivity;
import com.beeonline.library.helper.DisplayHelper;
import com.beeonline.library.helper.GlideHelper;
import com.beeonline.library.helper.RecycleViewDivider;
import com.beeonline.library.helper.StringHelper;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeFragment extends RefreshLayoutBaseFragment<HomeDataBean.Like, HomePresenterImpl> implements HomeContract.HomeContractView {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private HomeAdapter homeAdapter;
    private HomeBrandsAdapter gridAdapter;
    private HomeNewsAdapter newsAdapter;
    private List<HomeDataBean.Banner> banner = new ArrayList<>();
    private List<HomeDataBean.Brands> brands = new ArrayList<>();
    private List<HomeDataBean.RushBuy> rushBuy = new ArrayList<>();
    private List<HomeDataBean.Like> news = new ArrayList<>();
    private List<HomeDataBean.Optimization> optimization = new ArrayList<>();
    private View bannerView;
    private View brandsView;
    private View rushBugView;
    private LinearLayout optView;
    private View newsView;

    /**
     * 创建实例对象
     */
    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_home;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        initLayout(view);
        homeAdapter = new HomeAdapter(R.layout.item_home);
        homeAdapter.addHeaderView(getBannerHeader());
        homeAdapter.addHeaderView(getBrandsHeader());
        homeAdapter.addHeaderView(getRushBuyHeader());
        homeAdapter.addHeaderView(getNewsHeader());
        homeAdapter.addHeaderView(getOptimization());
        StaggeredGridLayoutManager recyclerViewLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerViewLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);//不设置的话，图片闪烁错位，有可能有整列错位的情况。
        mRecyclerView.addItemDecoration(new RecycleViewDivider(mContext, LinearLayout.HORIZONTAL,
                DisplayHelper.dip2px(10), StringHelper.resColor(R.color.white)));//边距和分割线，需要自己定义
        mRecyclerView.setLayoutManager(recyclerViewLayoutManager);
        mRecyclerView.setAdapter(homeAdapter);
    }

    private View getBannerHeader() {
        bannerView = LayoutInflater.from(getContext()).inflate(R.layout.item_home_banner, (ViewGroup) mRecyclerView.getParent(), false);
        initBannerView();
        return bannerView;
    }

    private View getBrandsHeader() {
        brandsView = LayoutInflater.from(getContext()).inflate(R.layout.item_home_brands, (ViewGroup) mRecyclerView.getParent(), false);
        gridAdapter = new HomeBrandsAdapter(getActivity(), brands);
        GridView gridView = brandsView.findViewById(R.id.gridView);
        gridView.setAdapter(gridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        gridAdapter.notifyDataSetChanged();

        return brandsView;
    }


    private View getRushBuyHeader() {
        rushBugView = LayoutInflater.from(getContext()).inflate(R.layout.item_home_products, (ViewGroup) mRecyclerView.getParent(), false);
        return rushBugView;
    }

    private View getNewsHeader() {
        newsView = LayoutInflater.from(getContext()).inflate(R.layout.item_home_news, (ViewGroup) mRecyclerView.getParent(), false);
        newsAdapter = new HomeNewsAdapter(getActivity(), news);
        GridView gridView = newsView.findViewById(R.id.gridView);
        gridView.setAdapter(newsAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        newsAdapter.notifyDataSetChanged();
        return newsView;
    }

    private View getOptimization() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_home_optimization_layout, (ViewGroup) mRecyclerView.getParent(), false);
        optView = view.findViewById(R.id.layout_content);
        return view;
    }

    private void initRushBugView() {
        TextView start_time = rushBugView.findViewById(R.id.start_time);
        ImageView img = rushBugView.findViewById(R.id.img);
        TextView now_price = rushBugView.findViewById(R.id.now_price);
        TextView old_price = rushBugView.findViewById(R.id.old_price);
        TextView time = rushBugView.findViewById(R.id.time);
        RelativeLayout rush_buy1 = rushBugView.findViewById(R.id.rush_buy1);
        if (rushBuy != null && rushBuy.size() > 0) {
            List<Products> products = rushBuy.get(0).getProducts();
            if (products != null && products.size() > 0) {
//                time.setText(products.get(0).getEnd_time());
                now_price.setText("￥" + products.get(0).getPromote_price());
                old_price.setText("￥" + products.get(0).getPrice());
                old_price.getPaint().setAntiAlias(true);//抗锯齿
                old_price.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);  // 设置中划线并加清晰
                if (products.get(0).getPhotos() != null && products.get(0).getPhotos().size() > 0) {
                    GlideHelper.loadNetworkResource(products.get(0).getPhotos().get(0).getLarge(), img);
                }

            }
        }
        rush_buy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LimitActivity.class));
            }
        });


    }

    private void initRushBugView2() {
        TextView hint = rushBugView.findViewById(R.id.hint);
        ImageView img2 = rushBugView.findViewById(R.id.img2);


        if (news != null && news.size() > 0) {
            hint.setText(news.get(0).getGoods_title());
            GlideHelper.loadNetworkResource(news.get(0).getDefault_photo().getLarge(), img2);
        }

    }


    private void initBannerView() {
        ConvenientBanner convenientBanner = bannerView.findViewById(R.id.convenientBanner);
        convenientBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
            @Override
            public NetworkImageHolderView createHolder() {
                return new NetworkImageHolderView();
            }
        }, banner)
                //设置指示器是否可见
                .setPointViewVisible(true)
                //设置自动切换（同时设置了切换时间间隔）
                .startTurning(4000)
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                .setPageIndicator(new int[]{R.mipmap.ic_page_indicator, R.mipmap.ic_page_indicator_focused})
                //设置指示器的方向（左、中、右）
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                //设置点击监听事件
                .setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        getActivity().startActivity(new Intent(getActivity(), WebActivity.class));
                    }
                })
                //设置手动影响（设置了该项无法手动切换）
                .setManualPageable(true);
    }

    public static class NetworkImageHolderView implements Holder<HomeDataBean.Banner> {
        private ImageView imageView;

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, HomeDataBean.Banner data) {
            GlideHelper.loadNetworkResource(data.getUrl().getThumb(), imageView);
        }


    }

    @Override
    public void getHomeDataSuccess(HomeDataBean baseData) {
        banner = baseData.getData().getBanner();
        rushBuy = baseData.getData().getRushBuy();
        optimization = baseData.getData().getOptimization();

        initNewsView(baseData);
        initBrandsView(baseData);
        initBannerView();
        initRushBugView();
        initRushBugView2();
        initOptimization();

        handleSuccess(homeAdapter, baseData.getData().getLike());
    }

    private void initOptimization() {
        if (optimization == null) {
            return;
        }
        optView.removeAllViews();
        for (int i = 0; i < optimization.size(); i++) {
            View childView = LayoutInflater.from(getActivity()).inflate(R.layout.item_home_optimization, null);
            ImageView background = childView.findViewById(R.id.background);
            LinearLayout layout_child = childView.findViewById(R.id.layout_child);

            GlideHelper.loadNetworkResource(optimization.get(i).getCarousel().getUrl().getLarge(), background);
            layout_child.removeAllViews();
            List<HomeDataBean.Like> goods = optimization.get(i).getGoods();
            for (int j = 0; j < goods.size(); j++) {
                View scrollViewChild = LayoutInflater.from(getActivity()).inflate(R.layout.item_home_optimization_child, null);
                ImageView img = scrollViewChild.findViewById(R.id.img);
                TextView text = scrollViewChild.findViewById(R.id.text);
                TextView now_price = scrollViewChild.findViewById(R.id.now_price);
                TextView old_price = scrollViewChild.findViewById(R.id.old_price);
                old_price.getPaint().setAntiAlias(true);//抗锯齿
                old_price.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);  // 设置中划线并加清晰
                View rightLine = scrollViewChild.findViewById(R.id.right_line);
                if (j == goods.size() - 1) {

                    rightLine.setVisibility(View.VISIBLE);
                } else {
                    rightLine.setVisibility(View.INVISIBLE);
                }
                //GlideHelper.loadNetworkResource(goods.get(j).getGoods_photo().getGoods_img().getLarge(), img);
                text.setText(goods.get(j).getBrand_name());
                now_price.setText("￥" + goods.get(j).getPrice());
                layout_child.addView(scrollViewChild);
            }
            optView.addView(childView);
        }
    }

    private void initBrandsView(HomeDataBean baseData) {
        brands.clear();
        brands.addAll(baseData.getData().getBrands());
        gridAdapter.notifyDataSetChanged();
    }

    private void initNewsView(HomeDataBean baseData) {
        news.clear();
        news.addAll(baseData.getData().getNews());
        news.remove(0);
        GridView gridView = newsView.findViewById(R.id.gridView);
        int count = news.size() / 3;
        if (news.size() % 3 > 0) {
            count++;
        }
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) gridView.getLayoutParams();
        params.height = DisplayHelper.dip2px(140) * count;
        gridView.setLayoutParams(params);
        newsAdapter.notifyDataSetChanged();


    }

    @Override
    public void getHomeDataFail(int code, String message) {

    }

    @Override
    public void initPresenter() {
        mPresenter = new HomePresenterImpl();
    }

    @Override
    public void doBusiness() {
        if (null != refreshLayout)
            refreshLayout.autoRefresh();
    }

    @Override
    public void showError(String msg) {
        showError(msg);
    }

    @Override
    protected void loadData() {
        mPresenter.getHomeData(start, rows);
    }
}
