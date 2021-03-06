package com.tearat.utils;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

/**
 * Durian
 * 2017-2017/4/11
 */

public class Utils {
    /**
     * RV水平管理
     * @param mContext
     * @return
     */
    public static LinearLayoutManager getHManager(Context mContext){
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        return manager;
    }

    /**
     * RV垂直管理
     * @param mContext
     * @return
     */

    public static LinearLayoutManager getVManager(Context mContext){
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        return manager;
    }

    /**
     * 表格佈局
     * @param mContext
     * @param size 数量
     * @return
     */
    public static GridLayoutManager getTableManager (Context mContext, int size){
        GridLayoutManager glm =   new GridLayoutManager(mContext,size);
        return glm;
    }
}
