package com.bee.beeonline.utils;

import com.bee.beeonline.R;
import com.bee.beeonline.bean.HomeDataBean;
import com.bee.beeonline.http.HttpRequest;
import com.beeonline.library.helper.LogHelper;
import com.beeonline.library.httpapi.interceptor.Transformer;
import com.beeonline.library.httpapi.observer.DataObserver;
import com.beeonline.library.httpapi.utils.SPUtils;
import com.beeonline.library.widget.bottombar.TabEntity;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 59395 on 2018/3/4.
 */

public class Util {

    /**
     * 判断手机号的合法性
     *
     * @param inputString
     * @return
     */
    public static boolean isMobile(String inputString) {
        Pattern pattern = Pattern.compile("^[1][3-8]+\\d{9}");
        Matcher macher = pattern.matcher(inputString);
        return macher.find();
    }

    /**
     * 集合不为空
     *
     * @param map
     * @return
     */
    public static boolean notEmptyMap(Map map) {
        return !emptyMap(map);
    }

    /**
     * 判断一个接口是否是null或者size小于等于0
     *
     * @param map
     * @return
     */
    public static boolean emptyMap(Map map) {
        return null == map || map.size() <= 0;
    }

    /**
     * 集合不为空
     *
     * @param list
     * @return
     */
    public static boolean notEmptyList(List list) {
        return !emptyList(list);
    }

    /**
     * 判断一个接口是否是null或者size小于等于0
     *
     * @param list
     * @return
     */
    public static boolean emptyList(List list) {
        return null == list || list.size() <= 0;
    }

    /**
     * 集合不为空
     *
     * @param set
     * @return
     */
    public static boolean notEmptySet(Set set) {
        return !emptySet(set);
    }

    /**
     * 判断一个接口是否是null或者size小于等于0
     *
     * @param set
     * @return
     */
    public static boolean emptySet(Set set) {
        return null == set || set.size() <= 0;
    }

    //
    public static List<TabEntity> getTabEntitys() {
        int[] normalIcon = {R.mipmap.icon_work_unselect, R.mipmap.icon_sort, R.mipmap.icon_show, R.mipmap.icon_buy, R.mipmap.icon_me};
        int[] selectIcon = {R.mipmap.icon_home, R.mipmap.icon_sort2, R.mipmap.icon_show2, R.mipmap.icon_buy2, R.mipmap.icon_mine_select};

        String[] tabText = {"首页", "分类", "SHOW", "购物车", "我的"};
        List<TabEntity> tabEntityList = new ArrayList<>();
        for (int i = 0; i < tabText.length; i++) {
            TabEntity item = new TabEntity();
            item.setText(tabText[i]);
            item.setNormalIconId(normalIcon[i]);
            item.setSelectIconId(selectIcon[i]);
            tabEntityList.add(item);
        }
        return tabEntityList;
    }

    public static Integer getUserID() {
        return SPUtils.get(Constant.USER_ID, 0);
    }

    public static String getUserName() {
        return SPUtils.get(Constant.USER_NAME, "");
    }


}
