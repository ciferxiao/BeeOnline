package com.bee.beeonline.main.sort;

import android.content.Context;
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
import com.bee.beeonline.bean.SortCate;
import com.beeonline.library.helper.DisplayHelper;
import com.beeonline.library.helper.GlideHelper;
import com.beeonline.library.widget.CircleView;
import com.wuhenzhizao.titlebar.utils.ScreenUtils;

import java.util.List;

public class SortRightAdapter extends BaseAdapter {

    private List<SortCate.SortCateBase> likes;
    private Context context;
    private LayoutInflater inflate;

    public SortRightAdapter(Context context, List<SortCate.SortCateBase> likes) {
        this.likes = likes;
        this.context = context;
        inflate = LayoutInflater.from(this.context);

    }

    @Override
    public int getCount() {
        return likes.size();
    }

    @Override
    public Object getItem(int position) {
        return likes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        int screenWidth = ScreenUtils.getScreenWidth(context) - DisplayHelper.dip2px(20 + 120);
        int viewWidth = screenWidth / 3;
        if (convertView == null) {
            convertView = inflate.inflate(R.layout.item_sort_goods, null);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) viewHolder.layout_content.getLayoutParams();
        params.width = viewWidth;
        viewHolder.layout_content.setLayoutParams(params);

        viewHolder.mName.setText(likes.get(position).getCat_name());
        GlideHelper.loadNetworkResource(likes.get(position).getPhotos().getLarge(), viewHolder.mIcon);
        return convertView;
    }

    class ViewHolder {
        ImageView mIcon;
        TextView mName;
        RelativeLayout layout_content;

        ViewHolder(View convertView) {
            mIcon = convertView.findViewById(R.id.img);
            mName = convertView.findViewById(R.id.text);
            layout_content = convertView.findViewById(R.id.layout_content);
        }
    }
}