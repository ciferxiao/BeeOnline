package com.bee.beeonline.main.home;

import android.content.Context;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
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

public class HomeBrandsAdapter extends BaseAdapter {

    private List<HomeDataBean.Brands> brands;
    private Context context;
    private LayoutInflater inflate;

    public HomeBrandsAdapter(Context context, List<HomeDataBean.Brands> brands) {
        this.brands = brands;
        this.context = context;
        inflate = LayoutInflater.from(this.context);

    }

    @Override
    public int getCount() {
        return brands.size();
    }

    @Override
    public Object getItem(int position) {
        return brands.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        int screenWidth = ScreenUtils.getScreenWidth(context) - DisplayHelper.dip2px(20);
        int viewWidth = screenWidth / 5;
        if (convertView == null) {
            convertView = inflate.inflate(R.layout.item_home_brands_child, null);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) viewHolder.layout_content.getLayoutParams();
        params.width = viewWidth;
        viewHolder.layout_content.setLayoutParams(params);

        viewHolder.mName.setText(brands.get(position).getName());
        GlideHelper.loadNetworkResource(brands.get(position).getLogo().getLarge(), viewHolder.mIcon);
        return convertView;
    }

    class ViewHolder {
        CircleView mIcon;
        TextView mName;
        RelativeLayout layout_content;

        ViewHolder(View convertView) {
            mIcon = convertView.findViewById(R.id.img);
            mName = convertView.findViewById(R.id.text);
            layout_content = convertView.findViewById(R.id.layout_content);
        }
    }
}