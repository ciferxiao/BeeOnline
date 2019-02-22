package com.bee.beeonline.main.home.limit;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bee.beeonline.R;
import com.bee.beeonline.bean.HomeDataBean;
import com.bee.beeonline.bean.ProductBean;
import com.beeonline.library.helper.GlideHelper;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class LimitAdapter extends BaseQuickAdapter<ProductBean, BaseViewHolder> {

    public LimitAdapter(int layoutResId, @Nullable List<ProductBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProductBean item) {
        HomeDataBean.Like like = item.getGoods();
        GlideHelper.loadNetworkResource(like.getDefault_photo().getLarge(), (ImageView) helper.getView(R.id.image));
        helper.setText(R.id.title, like.getGoods_title());
        StringBuilder desc = new StringBuilder();
        for (int i = 0; i < like.getGoodspro().size(); i++) {
            desc.append(like.getGoodspro().get(i).getAttr_name());
        }
        helper.setText(R.id.desc, desc.toString());
        helper.setText(R.id.now_price, like.getCurrent_price());
        helper.setText(R.id.old_price, like.getPrice());

    }
}
