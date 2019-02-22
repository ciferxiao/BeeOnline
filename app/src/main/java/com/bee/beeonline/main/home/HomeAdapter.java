package com.bee.beeonline.main.home;

import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bee.beeonline.R;
import com.bee.beeonline.bean.HomeDataBean;
import com.beeonline.library.helper.DisplayHelper;
import com.beeonline.library.helper.GlideHelper;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

public class HomeAdapter extends BaseQuickAdapter<HomeDataBean.Like, BaseViewHolder> {

    public HomeAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeDataBean.Like item) {
//        GlideHelper.loadNetworkResource(item.getGoods_photo().getGoods_thumb().getLarge(), (ImageView) helper.getView(R.id.image_item));

        if (helper.getLayoutPosition() % 2 == 0) {
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(helper.itemView.getLayoutParams());
            lp.setMargins(DisplayHelper.dip2px(5), 0, DisplayHelper.dip2px(10), 0);
            helper.itemView.setLayoutParams(lp);

        } else {
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(helper.itemView.getLayoutParams());
            lp.setMargins(DisplayHelper.dip2px(10), 0, DisplayHelper.dip2px(5), 0);
            helper.itemView.setLayoutParams(lp);
        }

        helper.setText(R.id.name_item, item.getBrand_name());
        helper.setText(R.id.desc, item.getGoods_title());
        helper.setText(R.id.price, "￥" + item.getPrice());
        helper.setText(R.id.count, item.getSales_count() + "已付款");

    }

}
