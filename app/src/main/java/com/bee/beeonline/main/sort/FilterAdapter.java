package com.bee.beeonline.main.sort;

import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bee.beeonline.R;
import com.bee.beeonline.bean.HomeDataBean;
import com.beeonline.library.helper.DisplayHelper;
import com.beeonline.library.helper.GlideHelper;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

public class FilterAdapter extends BaseQuickAdapter<HomeDataBean.Like, BaseViewHolder> {

    public FilterAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeDataBean.Like item) {

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(helper.itemView.getLayoutParams());
        lp.setMargins(0, 0, DisplayHelper.dip2px(10), 0);
        helper.itemView.setLayoutParams(lp);

        helper.setText(R.id.name_item, item.getBrand_name());
        helper.setText(R.id.desc, item.getGoods_title());
        helper.setText(R.id.price, item.getPrice());
        helper.setText(R.id.count, item.getSales_count() + "已付款");
        if (!TextUtils.isEmpty(item.getDefault_photo().getLarge())) {
            GlideHelper.loadNetworkResource(item.getDefault_photo().getLarge(), (ImageView) helper.getView(R.id.image_item));
        }
    }

}
