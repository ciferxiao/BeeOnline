package com.bee.beeonline.main.sort;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bee.beeonline.R;
import com.bee.beeonline.base.RefreshLayoutBaseActivity;
import com.bee.beeonline.bean.EffectBean;
import com.bee.beeonline.bean.EffectBrandsBean;
import com.bee.beeonline.bean.HomeDataBean;
import com.bee.beeonline.bean.HomeLikeBean;
import com.bee.beeonline.bean.SortBean;
import com.bee.beeonline.bean.SortCate;
import com.beeonline.library.helper.DisplayHelper;
import com.beeonline.library.helper.RecycleViewDivider;
import com.beeonline.library.helper.StringHelper;
import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.wuhenzhizao.titlebar.widget.CommonTitleBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class FilterActivity extends RefreshLayoutBaseActivity<HomeDataBean.Like, SortPresenterImpl> implements SortContract.SortContractView {

    @BindView(R.id.title_bar)
    CommonTitleBar title_bar;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.refresh_layout)
    RefreshLayout refreshLayout;
    @BindView(R.id.layout_filter)
    LinearLayout layout_filter;
    @BindView(R.id.layout_filter_parent)
    RelativeLayout layout_filter_parent;
    @BindView(R.id.price1)
    TextView price1;
    @BindView(R.id.price2)
    TextView price2;
    @BindView(R.id.price3)
    TextView price3;
    @BindView(R.id.price4)
    TextView price4;
    @BindView(R.id.price5)
    TextView price5;
    @BindView(R.id.price6)
    TextView price6;
    @BindView(R.id.price7)
    TextView price7;
    @BindView(R.id.reset)
    TextView reset;
    @BindView(R.id.confirm)
    TextView comfirm;
    @BindView(R.id.layout_effect)
    LinearLayout layout_effect;
    @BindView(R.id.layout_brands)
    LinearLayout layout_brands;
    @BindView(R.id.brands_more)
    TextView brands_more;
    @BindView(R.id.effect_more)
    TextView effect_more;
    @BindView(R.id.price_right)
    TextView price_right;
    @BindView(R.id.edit_price_min)
    EditText edit_price_min;
    @BindView(R.id.edit_price_max)
    EditText edit_price_max;
    @BindView(R.id.effect_name)
    TextView effect_name;
    @BindView(R.id.brands_name)
    TextView brands_name;
    private FilterAdapter adapter;

    /**
     * cat_id	否	int	分类id
     * search	否	string	搜索词 注：cat_id与search必须选一个
     * brand	否	json string	品牌id 如：[1,2,3]
     * effect	否	string	功效：如 [“美白”,”护肤”]
     * min_price	否	int	最小价格
     * max_price	否	int	最大价格
     * sort	否	string	排序：综合： all，销量：sale-0 顺序，sale-1 倒序， 价格 price-0 顺序，price-1 倒序
     */
    private int cat_id = -1;
    private String search = "";
    private String brand = "";
    private String effect = "";
    private int min_price = -1;
    private int max_price = -1;
    private String sort = "all";

    private boolean isUp = false;
    private String title;

    public static void startActivity(Context context, int cat_id, String search, String title) {
        Intent intent = new Intent(context, FilterActivity.class);
        intent.putExtra("cat_id", cat_id);
        intent.putExtra("search", search);
        intent.putExtra("title", title);
        context.startActivity(intent);
    }

    @Override
    public void initData(Bundle bundle) {
        cat_id = getIntent().getIntExtra("cat_id", -1);
        search = getIntent().getStringExtra("search");
        title = getIntent().getStringExtra("title");
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_filter;
    }

    @Override
    protected void loadData() {
        mPresenter.getCateGoods(start, rows, cat_id, search, brand, effect, min_price, max_price, sort);
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        initLayout();
        initAdapter();
        showEmptyView = false;
        layout_filter_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout_filter.setVisibility(View.GONE);
                layout_filter_parent.setVisibility(View.GONE);
            }
        });

        brands_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isShowMoreBrands = !isShowMoreBrands;
                initBrands(brandsBeans);

            }
        });
        effect_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isShowMoreEffect = !isShowMoreEffect;
                initEffect(effectBeans);
            }
        });
        edit_price_min.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                resetPrice();
                if (!TextUtils.isEmpty(s.toString())) {
                    min_price = Integer.parseInt(s.toString());
                    if (!TextUtils.isEmpty(edit_price_max.getText())) {
                        max_price = Integer.parseInt(edit_price_max.getText().toString());
                        price_right.setText(min_price + "—" + max_price);
                    } else {
                        price_right.setText(min_price + "");
                    }
                } else {
                    if (!TextUtils.isEmpty(edit_price_max.getText())) {
                        max_price = Integer.parseInt(edit_price_max.getText().toString());
                        price_right.setText(min_price + "—" + max_price);
                    }
                }

            }
        });

        edit_price_max.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                resetPrice();
                if (!TextUtils.isEmpty(s.toString())) {
                    max_price = Integer.parseInt(s.toString());
                    if (!TextUtils.isEmpty(edit_price_min.getText())) {
                        min_price = Integer.parseInt(edit_price_min.getText().toString());
                        price_right.setText(min_price + "—" + max_price);
                    } else {
                        price_right.setText(max_price + "");
                    }
                } else {
                    if (!TextUtils.isEmpty(edit_price_min.getText())) {
                        min_price = Integer.parseInt(edit_price_min.getText().toString());
                        price_right.setText(min_price + "");
                    }
                }

            }
        });
    }

    private void resetPrice() {
        price_right.setText("");
        min_price = -1;
        max_price = -1;
        price1.setBackground(getResources().getDrawable(R.drawable.border_f5));
        price2.setBackground(getResources().getDrawable(R.drawable.border_f5));
        price3.setBackground(getResources().getDrawable(R.drawable.border_f5));
        price4.setBackground(getResources().getDrawable(R.drawable.border_f5));
        price5.setBackground(getResources().getDrawable(R.drawable.border_f5));
        price6.setBackground(getResources().getDrawable(R.drawable.border_f5));
        price7.setBackground(getResources().getDrawable(R.drawable.border_f5));
        price1.setTextColor(getResources().getColor(R.color.gray_33));
        price2.setTextColor(getResources().getColor(R.color.gray_33));
        price3.setTextColor(getResources().getColor(R.color.gray_33));
        price4.setTextColor(getResources().getColor(R.color.gray_33));
        price5.setTextColor(getResources().getColor(R.color.gray_33));
        price6.setTextColor(getResources().getColor(R.color.gray_33));
        price7.setTextColor(getResources().getColor(R.color.gray_33));

    }

    @SuppressLint("SetTextI18n")
    @OnClick(value = {R.id.layout_back, R.id.price1, R.id.price2, R.id.price3, R.id.price4, R.id.price5, R.id.price6, R.id.price7, R.id.reset, R.id.confirm})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout_back:
                onBackPressed();
                break;
            case R.id.price1:
                resetPrice();
                min_price = 0;
                max_price = 59;
                edit_price_min.setText("0");
                edit_price_max.setText("59");
                price1.setBackground(getResources().getDrawable(R.drawable.border_red));
                price_right.setText("0—59");
                price1.setTextColor(getResources().getColor(R.color.red_ff0000));
                break;
            case R.id.price2:
                resetPrice();
                min_price = 60;
                max_price = 89;
                edit_price_min.setText("60");
                edit_price_max.setText("89");
                price_right.setText("60—89");
                price2.setBackground(getResources().getDrawable(R.drawable.border_red));
                price2.setTextColor(getResources().getColor(R.color.red_ff0000));
                break;
            case R.id.price3:
                resetPrice();
                min_price = 90;
                max_price = 199;
                edit_price_min.setText("90");
                edit_price_max.setText("199");
                price_right.setText("90—199");
                price3.setBackground(getResources().getDrawable(R.drawable.border_red));
                price3.setTextColor(getResources().getColor(R.color.red_ff0000));
                break;
            case R.id.price4:
                resetPrice();
                min_price = 200;
                max_price = 299;
                edit_price_min.setText("200");
                edit_price_max.setText("299");
                price_right.setText("200—299");
                price4.setBackground(getResources().getDrawable(R.drawable.border_red));
                price4.setTextColor(getResources().getColor(R.color.red_ff0000));
                break;
            case R.id.price5:
                resetPrice();
                min_price = 300;
                max_price = 1199;
                edit_price_min.setText("300");
                edit_price_max.setText("1199");
                price_right.setText("300—1199");
                price5.setBackground(getResources().getDrawable(R.drawable.border_red));
                price5.setTextColor(getResources().getColor(R.color.red_ff0000));
                break;
            case R.id.price6:
                resetPrice();
                min_price = 1200;
                max_price = 1999;
                edit_price_min.setText("1200");
                edit_price_max.setText("1999");
                price_right.setText("1200—1999");
                price6.setBackground(getResources().getDrawable(R.drawable.border_red));
                price6.setTextColor(getResources().getColor(R.color.red_ff0000));
                break;
            case R.id.price7:
                resetPrice();
                min_price = 2000;
                max_price = 3999;
                edit_price_min.setText("2000");
                edit_price_max.setText("3999");
                price_right.setText("2000—3999");
                price7.setBackground(getResources().getDrawable(R.drawable.border_red));
                price7.setTextColor(getResources().getColor(R.color.red_ff0000));
                break;
            case R.id.reset:
                resetPrice();
                resetBrands();
                resetEffects();
                break;
            case R.id.confirm:
                showLoading();

                List<Integer> brandsList = new ArrayList<>();
                for (int i = 0; i < brandsBeans.size(); i++) {
                    if (brandsBeans.get(i).isCheck()) {
                        brandsList.add(brandsBeans.get(i).getBrand_id());
                    }
                }
                if (brandsList.size() > 0) {
                    brand = new Gson().toJson(brandsList);
                } else {
                    brand = "";
                }
                List<String> effctsList = new ArrayList<>();
                for (int i = 0; i < effectBeans.size(); i++) {
                    if (effectBeans.get(i).isCheck()) {
                        effctsList.add(effectBeans.get(i).getAttr_value());
                    }
                }
                if (effctsList.size() > 0) {
                    effect = new Gson().toJson(effctsList);
                } else {
                    effect = "";
                }
                loadData();
                layout_filter_parent.setVisibility(View.GONE);
                layout_filter.setVisibility(View.GONE);
                break;
            default:
                break;
        }
    }

    private void initAdapter() {
        adapter = new FilterAdapter(R.layout.item_show);
        adapter.addHeaderView(getEView());
        StaggeredGridLayoutManager recyclerViewLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerViewLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);//不设置的话，图片闪烁错位，有可能有整列错位的情况。
        recyclerView.addItemDecoration(new RecycleViewDivider(this, LinearLayout.HORIZONTAL,
                DisplayHelper.dip2px(10), StringHelper.resColor(R.color.white)));//边距和分割线，需要自己定义
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        recyclerView.setAdapter(adapter);


        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) title_bar.getLayoutParams();
        params.topMargin = DisplayHelper.getStatusHeight(this);
        title_bar.setLayoutParams(params);
        title_bar.getCenterTextView().setText(title);
    }

    @Override
    public void initPresenter() {
        mPresenter = new SortPresenterImpl();
    }

    @Override
    public void doBusiness() {
        if (null != refreshLayout)
            refreshLayout.autoRefresh();
        mPresenter.getCateCond();
    }


    @Override
    public void showError(String msg) {
        hideLoading();
        showToast(msg);
    }

    @Override
    public void getCateCondSuccess(SortBean baseData) {
        effectBeans = baseData.getData().getEffect();
        brandsBeans = baseData.getData().getBrands();

        initBrands(brandsBeans);
        initEffect(effectBeans);

    }

    private boolean isShowMoreEffect = false;
    private boolean isShowMoreBrands = false;
    private List<EffectBean> effectBeans = new ArrayList<>();
    private List<EffectBrandsBean> brandsBeans = new ArrayList<>();

    private void initEffect(final List<EffectBean> effectBeans) {
        layout_effect.removeAllViews();
        int width = (DisplayHelper.screenW() - DisplayHelper.dip2px(100)) / 3;
        int index = 0;
        int rows = 0;
        LinearLayout layout_parent = null;
        View parent = null;
        for (int i = 0; i < effectBeans.size(); i++) {
            if (index % 3 == 0) {
                rows++;
                if (!isShowMoreEffect && rows > 3) {
                    return;
                }
                parent = LayoutInflater.from(this).inflate(R.layout.item_sort_brands_parent, null);
                layout_parent = parent.findViewById(R.id.layout_parent);
                layout_effect.addView(parent);

            }
            View child = LayoutInflater.from(this).inflate(R.layout.item_sort_brands_child, null);
            final TextView text = child.findViewById(R.id.text);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) text.getLayoutParams();
            params.width = width;
            text.setLayoutParams(params);
            text.setText(effectBeans.get(i).getAttr_value());
            if (effectBeans.get(i).isCheck()) {
                text.setBackground(getResources().getDrawable(R.drawable.border_red));
                text.setTextColor(getResources().getColor(R.color.red_ff0000));
            } else {
                text.setBackground(getResources().getDrawable(R.drawable.border_f5));
                text.setTextColor(getResources().getColor(R.color.gray_33));
            }
            final int finalI = i;
            text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String content = effectBeans.get(finalI).getAttr_value();
                    if (effectBeans.get(finalI).isCheck()) {
                        text.setBackground(getResources().getDrawable(R.drawable.border_f5));
                        text.setTextColor(getResources().getColor(R.color.gray_33));
                        if (effectsContents.contains(content)) {
                            effectsContents.remove(content);
                        }
                    } else {
                        text.setBackground(getResources().getDrawable(R.drawable.border_red));
                        text.setTextColor(getResources().getColor(R.color.red_ff0000));
                        effectsContents.add(content);
                    }
                    addeffectsContent();
                    effectBeans.get(finalI).setCheck(!effectBeans.get(finalI).isCheck());
                }
            });
            if (layout_parent != null) {
                layout_parent.addView(child);
            }
            index++;
        }
    }

    private void resetEffects() {
        effectsContents.clear();
        effect_name.setText("");
        for (int i = 0; i < effectBeans.size(); i++) {
            effectBeans.get(i).setCheck(false);
        }
    }

    private void resetBrands() {
        brandsContents.clear();
        brands_name.setText("");
        for (int i = 0; i < brandsBeans.size(); i++) {
            brandsBeans.get(i).setCheck(false);
        }
    }

    private List<String> brandsContents = new ArrayList<>();
    private List<String> effectsContents = new ArrayList<>();

    private void initBrands(final List<EffectBrandsBean> brandsBeans) {
        layout_brands.removeAllViews();
        int width = (DisplayHelper.screenW() - DisplayHelper.dip2px(100)) / 3;
        int index = 0;
        int rows = 0;
        LinearLayout layout_parent = null;
        View parent = null;
        for (int i = 0; i < brandsBeans.size(); i++) {
            if (index % 3 == 0) {
                rows++;
                if (!isShowMoreBrands && rows > 3) {
                    return;
                }
                parent = LayoutInflater.from(this).inflate(R.layout.item_sort_brands_parent, null);
                layout_parent = parent.findViewById(R.id.layout_parent);
                layout_brands.addView(parent);
            }
            View child = LayoutInflater.from(this).inflate(R.layout.item_sort_brands_child, null);
            final TextView text = child.findViewById(R.id.text);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) text.getLayoutParams();
            params.width = width;
            text.setLayoutParams(params);
            text.setText(brandsBeans.get(i).getBrand_name());
            if (brandsBeans.get(i).isCheck()) {
                text.setBackground(getResources().getDrawable(R.drawable.border_red));
                text.setTextColor(getResources().getColor(R.color.red_ff0000));
            } else {
                text.setBackground(getResources().getDrawable(R.drawable.border_f5));
                text.setTextColor(getResources().getColor(R.color.gray_33));
            }
            final int finalI = i;
            text.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onClick(View v) {
                    String content = brandsBeans.get(finalI).getBrand_name();
                    if (brandsBeans.get(finalI).isCheck()) {
                        text.setBackground(getResources().getDrawable(R.drawable.border_f5));
                        text.setTextColor(getResources().getColor(R.color.gray_33));
                        if (brandsContents.contains(content)) {
                            brandsContents.remove(content);
                        }
                    } else {
                        text.setBackground(getResources().getDrawable(R.drawable.border_red));
                        text.setTextColor(getResources().getColor(R.color.red_ff0000));
                        brandsContents.add(content);
                    }
                    addBrandsContent();
                    brandsBeans.get(finalI).setCheck(!brandsBeans.get(finalI).isCheck());
                }
            });

            if (layout_parent != null) {
                layout_parent.addView(child);
            }
            index++;
        }
    }

    private void addBrandsContent() {
        String nowContent = "";
        for (int j = 0; j < brandsContents.size(); j++) {
            if (j == 0) {
                nowContent = brandsContents.get(j);
            } else {
                nowContent = nowContent + ", " + brandsContents.get(j);
            }
        }
        brands_name.setText(nowContent);
    }

    private void addeffectsContent() {
        String nowContent = "";
        for (int j = 0; j < effectsContents.size(); j++) {
            if (j == 0) {
                nowContent = effectsContents.get(j);
            } else {
                nowContent = nowContent + ", " + effectsContents.get(j);
            }
        }
        effect_name.setText(nowContent);
    }

    @Override
    public void getCateCondFail(int code, String message) {
        hideLoading();
        showToast(message);
    }


    @Override
    public void getCateGoodsSuccess(HomeLikeBean baseData) {
        hideLoading();
        List<HomeDataBean.Like> likes = baseData.getData().getData();

        for (int i = 0; i < likes.size(); i++) {
            likes.get(i).setLeft((i + 1) % 2 != 0);
        }

        handleSuccess(adapter, likes);
    }

    @Override
    public void getCateGoodsFail(int code, String message) {
        hideLoading();
        showToast(message);
    }

    @Override
    public void getCateSuccess(SortCate baseData) {

    }

    @Override
    public void getCateFail(int code, String message) {

    }

    private void checkLoad() {

        all.setTextColor(getResources().getColor(R.color.gray_33));
        all_img.setImageDrawable(getResources().getDrawable(R.mipmap.arrow_down));
        count.setTextColor(getResources().getColor(R.color.gray_33));
        price.setTextColor(getResources().getColor(R.color.gray_33));
        price_up_img.setImageDrawable(getResources().getDrawable(R.mipmap.arrow_up));
        price_down_img.setImageDrawable(getResources().getDrawable(R.mipmap.arrow_down));


        if (sort.equals("all")) {
            all.setTextColor(getResources().getColor(R.color.red_ff0000));
            all_img.setImageDrawable(getResources().getDrawable(R.mipmap.arrow_down_red));
        }

        if (sort.equals("sale-0")) {
            count.setTextColor(getResources().getColor(R.color.red_ff0000));
        }


        if (sort.equals("price-0")) {
            price.setTextColor(getResources().getColor(R.color.red_ff0000));
        }

        if (sort.equals("price-1")) {
            price.setTextColor(getResources().getColor(R.color.red_ff0000));
            price_down_img.setImageDrawable(getResources().getDrawable(R.mipmap.arrow_down_red));

        }
        start = 1;
        loadData();
    }

    TextView all;
    TextView count;
    TextView price;
    TextView filter;
    ImageView all_img;
    ImageView price_up_img;
    ImageView price_down_img;

    public View getEView() {
        View view = LayoutInflater.from(this).inflate(R.layout.item_filter_header, (ViewGroup) recyclerView.getParent(), false);

        all = view.findViewById(R.id.all);
        count = view.findViewById(R.id.count);
        price = view.findViewById(R.id.price);
        filter = view.findViewById(R.id.filter);
        all_img = view.findViewById(R.id.all_img);
        price_up_img = view.findViewById(R.id.price_up_img);
        price_down_img = view.findViewById(R.id.price_down_img);


        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sort = "all";
                checkLoad();
            }
        });

        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sort = "sale-0";
                checkLoad();
            }
        });


        price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isUp) {
                    sort = "price-0";
                } else {
                    sort = "price-1";
                }
                isUp = !isUp;
                checkLoad();
            }
        });

        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (layout_filter.getVisibility() == View.GONE) {
                    layout_filter.setVisibility(View.VISIBLE);
                    layout_filter_parent.setVisibility(View.VISIBLE);
                } else {
                    layout_filter.setVisibility(View.GONE);
                    layout_filter_parent.setVisibility(View.GONE);
                }
            }
        });

        return view;

    }


}
