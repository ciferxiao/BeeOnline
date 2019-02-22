package com.beeonline.library.widget.popup;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.beeonline.library.R;
import com.zyyoona7.lib.BaseCustomPopup;

/**
 * Created by liuzq on 2018/4/20.
 */

public class ImagePickerPopup extends BaseCustomPopup implements View.OnClickListener {

    private int selectIndex = -1;

    public ImagePickerPopup(Context context) {
        super(context);
    }

    @Override
    protected void initAttributes() {
        setContentView(R.layout.view_action_sheet);
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setAnimationStyle(R.style.popwindow_anim_style);
        setFocusAndOutsideEnable(true);
        setBackgroundDimEnable(true);
        setDimValue(0.4f);
    }

    @Override
    protected void initViews(View view) {
        TextView camera = (TextView) view.findViewById(R.id.tv_camera);
        TextView photo = (TextView) view.findViewById(R.id.tv_photo);
        TextView cancel = (TextView) view.findViewById(R.id.tv_cancel);
        camera.setOnClickListener(this);
        photo.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.tv_camera) {
            selectIndex = 0;
            if (mOnItemListener != null) {
                mOnItemListener.onItemSelected(selectIndex);
            }
        } else if (i == R.id.tv_photo) {
            selectIndex = 1;
            if (mOnItemListener != null) {
                mOnItemListener.onItemSelected(selectIndex);
            }
        } else if (i == R.id.tv_cancel) {
        }
        dismiss();
    }

    /**
     * 显示在界面的底部
     */
    public void show(Activity activity) {
        showAtLocation(activity.getWindow().getDecorView(), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
    }

    public interface OnItemListener {
        void onItemSelected(int pos);
    }

    @Nullable
    private OnItemListener mOnItemListener;

    public void setOnItemListener(@Nullable OnItemListener listener) {
        mOnItemListener = listener;
    }
}
