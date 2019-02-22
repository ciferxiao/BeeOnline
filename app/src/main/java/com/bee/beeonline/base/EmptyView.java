package com.bee.beeonline.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bee.beeonline.R;
import com.beeonline.library.helper.DisplayHelper;
import com.beeonline.library.helper.StringHelper;

/**
 * 自定义加载和显示数据加载失败view 需要绑定显示的view
 * <p>
 * Created by liuzq on 2017/7/18.
 */

public class EmptyView extends RelativeLayout {
    private LinearLayout layout;
    private ImageView ivTips;
    private TextView tvTips;
    private View bindView;// 被绑定的view

    public EmptyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        LayoutParams params = new LayoutParams(-2, -2);
        params.addRule(CENTER_IN_PARENT);
        addView(layout, params);

        LayoutParams ivParma = new LayoutParams(-2, -2);
        ivParma.addRule(CENTER_IN_PARENT);
        LayoutParams tvParma = new LayoutParams(-2, -2);
        tvParma.addRule(CENTER_HORIZONTAL);
        tvParma.setMargins(0, 20, 0, 0);

        ivTips = new ImageView(context);
        ivTips.setId(R.id.emptyview_img);
        setImageRes(R.mipmap.empty_layout);
        layout.addView(ivTips, ivParma);

        LinearLayout.LayoutParams params1 = (LinearLayout.LayoutParams) ivTips.getLayoutParams();
        params1.width = DisplayHelper.dip2px(150);
        params.height = DisplayHelper.dip2px(150);
        ivTips.setLayoutParams(params1);

        tvTips = new TextView(context);
        tvTips.setId(R.id.emptyview_tv_tip);
        tvTips.setTextSize(16);
        tvTips.setPadding(0, 15, 0, 15);
        setMessage(R.string.emptyview_loading);
        layout.addView(tvTips, tvParma);
    }

    public void bind(View view) {
        this.bindView = view;
    }

    public void unbind() {
        this.bindView = null;
    }

    public void loadSuccess() {
        setVisibility(View.GONE);
        if (bindView != null)
            bindView.setVisibility(View.VISIBLE);
    }


    //空数据，加载数据失败，网络异常
    public void loadFail(String tip, int resId) {
        if (bindView != null) {
            setVisibility(View.VISIBLE);
            bindView.setVisibility(View.GONE);
            setMessage(tip);
            setImageRes(resId);
        }
    }

    public void setImageRes(int resId) {
        if (resId != 0)
            this.ivTips.setImageResource(resId);
    }

    public void setMessage(int stringId) {
        setMessage(StringHelper.resStr(stringId));
    }

    public void setMessage(String message) {
        this.tvTips.setVisibility(View.GONE);
        if (StringHelper.isEmpty(message))
            this.tvTips.setText("暂无数据");
        else
            this.tvTips.setText(message);
    }

    public LinearLayout getLayoutReload() {
        return layout;
    }
}
