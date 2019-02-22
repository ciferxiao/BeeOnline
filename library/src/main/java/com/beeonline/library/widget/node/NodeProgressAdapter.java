package com.beeonline.library.widget.node;

import java.util.List;

/**
 * Created by liuzq on 2018/4/23.
 */

public interface NodeProgressAdapter<T> {
    /**
     * 返回集合大小
     *
     * @return
     */
    int getCount();

    /**
     * 适配数据的集合
     *
     * @return
     */
    List<T> getData();
}
