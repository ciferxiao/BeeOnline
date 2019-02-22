package com.bee.beeonline.main.show;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bee.beeonline.R;
import com.bee.beeonline.bean.HomeDataBean;
import com.bee.beeonline.bean.ShowBean;
import com.beeonline.library.helper.DisplayHelper;
import com.beeonline.library.helper.GlideHelper;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

public class ShowAdapter extends BaseQuickAdapter<ShowBean, BaseViewHolder> {

    public ShowAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShowBean item) {
        GlideHelper.loadNetworkResource(item.getImage(), (ImageView) helper.getView(R.id.image_item));
        if (helper.getLayoutPosition() % 2 == 0) {
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(helper.itemView.getLayoutParams());
            lp.setMargins(DisplayHelper.dip2px(5), 0, DisplayHelper.dip2px(10), 0);
            helper.itemView.setLayoutParams(lp);

        } else {
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(helper.itemView.getLayoutParams());
            lp.setMargins(DisplayHelper.dip2px(10), 0, DisplayHelper.dip2px(5), 0);
            helper.itemView.setLayoutParams(lp);
        }

        helper.setText(R.id.name_item, item.getTitle());
        if (TextUtils.isEmpty(item.getContent())) {
            helper.getView(R.id.desc).setVisibility(View.GONE);
        } else {
            helper.getView(R.id.desc).setVisibility(View.VISIBLE);
            helper.setText(R.id.desc, item.getContent());
        }
        helper.setText(R.id.price, "浏览：" + item.getPraise());
        helper.setText(R.id.count, "评论：" + item.getNumber());

    }

}
