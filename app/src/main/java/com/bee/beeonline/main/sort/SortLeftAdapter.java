package com.bee.beeonline.main.sort;

import android.view.View;

import com.bee.beeonline.R;
import com.bee.beeonline.bean.EffectBean;
import com.bee.beeonline.bean.SortCate;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

public class SortLeftAdapter extends BaseQuickAdapter<SortCate.SortCateBase, BaseViewHolder> {

    public SortLeftAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, SortCate.SortCateBase item) {
        helper.setText(R.id.name, item.getCat_name());
        if (item.isCheck()) {
            helper.itemView.setBackgroundColor(mContext.getResources().getColor(R.color.white));
            helper.getView(R.id.line).setVisibility(View.VISIBLE);
        } else {
            helper.itemView.setBackgroundColor(mContext.getResources().getColor(R.color.white_f5));
            helper.getView(R.id.line).setVisibility(View.INVISIBLE);
        }
        helper.addOnClickListener(R.id.layout_content);
    }
}
