package com.bee.beeonline.main.home;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bee.beeonline.R;
import com.bee.beeonline.bean.HomeDataBean;
import com.beeonline.library.helper.DisplayHelper;
import com.beeonline.library.helper.GlideHelper;
import com.beeonline.library.widget.CircleView;
import com.wuhenzhizao.titlebar.utils.ScreenUtils;

import java.util.List;

public class HomeNewsAdapter extends BaseAdapter {

    private List<HomeDataBean.Like> news;
    private Context context;
    private LayoutInflater inflate;

    public HomeNewsAdapter(Context context, List<HomeDataBean.Like> news) {
        this.news = news;
        this.context = context;
        inflate = LayoutInflater.from(this.context);

    }

    @Override
    public int getCount() {
        return news.size();
    }

    @Override
    public Object getItem(int position) {
        return news.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        int screenWidth = ScreenUtils.getScreenWidth(context);
        int viewWidth = (screenWidth - DisplayHelper.dip2px(20)) / 3;
        if (convertView == null) {
            convertView = inflate.inflate(R.layout.item_home_news_child, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) viewHolder.layout_content.getLayoutParams();
        params.width = viewWidth;
        viewHolder.layout_content.setLayoutParams(params);
        viewHolder.mName.setText(news.get(position).getBrand_name());
//        GlideHelper.loadNetworkResource(news.get(position).getGoods_photo().getGoods_thumb().getLarge(), viewHolder.mIcon);
        viewHolder.now_price.setText("￥" + news.get(position).getPrice());
        viewHolder.old_price.getPaint().setAntiAlias(true);//抗锯齿
        viewHolder.old_price.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);  // 设置中划线并加清晰
        if (position <= 3) {
            viewHolder.topLine.setVisibility(View.INVISIBLE);
        } else {
            viewHolder.topLine.setVisibility(View.INVISIBLE);
        }
        if (position % 3 == 1 || position % 3 == 2) {
            viewHolder.leftLine.setVisibility(View.INVISIBLE);
        } else {
            viewHolder.leftLine.setVisibility(View.VISIBLE);
        }

        return convertView;
    }

    class ViewHolder {
        ImageView mIcon;
        TextView mName;
        TextView now_price;
        TextView old_price;
        RelativeLayout layout_content;
        View topLine;
        View leftLine;
        View botLine;


        ViewHolder(View convertView) {
            mIcon = convertView.findViewById(R.id.img);
            mName = convertView.findViewById(R.id.text);
            now_price = convertView.findViewById(R.id.now_price);
            old_price = convertView.findViewById(R.id.old_price);
            layout_content = convertView.findViewById(R.id.layout_content);
            topLine = convertView.findViewById(R.id.top_line);
            leftLine = convertView.findViewById(R.id.left_line);
            botLine = convertView.findViewById(R.id.bot_line);
        }
    }
}