package com.bee.beeonline.main.buy;

import android.annotation.SuppressLint;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bee.beeonline.R;
import com.bee.beeonline.bean.CartBean;
import com.beeonline.library.helper.DisplayHelper;
import com.beeonline.library.helper.GlideHelper;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class RealBuyAdapter extends BaseQuickAdapter<CartBean, BaseViewHolder> {

    public RealBuyAdapter(int layoutResId, @Nullable List<CartBean> data) {
        super(layoutResId, data);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void convert(final BaseViewHolder helper, CartBean item) {
        LinearLayout content_layout = helper.getView(R.id.content_layout);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) content_layout.getLayoutParams();
        params.width = DisplayHelper.screenW();
        content_layout.setLayoutParams(params);

        GlideHelper.loadNetworkResource(item.getProduct().getDefault_photo().getLarge(), (ImageView) helper.getView(R.id.image));
        helper.setText(R.id.title, item.getProduct().getGoods_title());
        helper.setText(R.id.price, "￥ " + item.getProduct().getCurrent_price());

        helper.setText(R.id.count, item.getAmount() + "");

        CheckBox checkBox = helper.getView(R.id.checkbox);
        checkBox.setChecked(item.getSelected() == 1);

        helper.addOnClickListener(R.id.cut);
        helper.addOnClickListener(R.id.add);
        helper.addOnClickListener(R.id.checkbox);
        helper.addOnClickListener(R.id.delete);
    }
}
