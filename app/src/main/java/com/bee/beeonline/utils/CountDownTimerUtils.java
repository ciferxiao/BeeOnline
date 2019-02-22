package com.bee.beeonline.utils;

import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import com.bee.beeonline.R;


public class CountDownTimerUtils extends CountDownTimer {
    private TextView mTextView;
    private Context context;
    private String huanyuanStr;

    /**
     * @param textView          The TextView
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receiver
     *                          {@link #onTick(long)} callbacks.
     */
    public CountDownTimerUtils(TextView textView, long millisInFuture, long countDownInterval, Context context, String huanyuanStr) {
        super(millisInFuture, countDownInterval);
        this.mTextView = textView;
        this.context = context;
        this.huanyuanStr = huanyuanStr;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        mTextView.setClickable(false); //设置不可点击  
        mTextView.setText(millisUntilFinished / 1000 + "秒后可重发");  //设置倒计时时间
//        mTextView.setBackgroundResource(R.drawable.get_code_bg_wait); //设置按钮为灰色，这时是不能点击的
        mTextView.setTextColor(ColorUtil.getColor(context, R.color.white));
        /**
         * 超链接 URLSpan 
         * 文字背景颜色 BackgroundColorSpan 
         * 文字颜色 ForegroundColorSpan 
         * 字体大小 AbsoluteSizeSpan 
         * 粗体、斜体 StyleSpan 
         * 删除线 StrikethroughSpan 
         * 下划线 UnderlineSpan 
         * 图片 ImageSpan 
         * http://blog.csdn.net/ah200614435/article/details/7914459 
         */
        SpannableString spannableString = new SpannableString(mTextView.getText().toString());  //获取按钮上的文字
        ForegroundColorSpan span = new ForegroundColorSpan(Color.WHITE);
        /**
         * public void setSpan(Object what, int start, int end, int flags) {
         * 主要是start跟end，start是起始位置,无论中英文，都算一个。 
         * 从0开始计算起。end是结束位置，所以处理的文字，包含开始位置，但不包含结束位置。
         */
        spannableString.setSpan(span, 0, 2, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);//将倒计时的时间设置为红色
        mTextView.setText(spannableString);
    }

    @Override
    public void onFinish() {
        mTextView.setText("重新获取密码");
        mTextView.setClickable(true);//重新获得点击  
//        mTextView.setBackgroundResource(R.drawable.get_code_bg);  //还原背景色
        mTextView.setTextColor(ColorUtil.getColor(context, R.color.white));
    }
}  