package com.dvsnier.common.listener;

import android.view.View;

import com.dvsnier.base.IBaseOnClickListener;

/**
 * IOnItemClickListener
 * Created by lizw on 2016/6/18.
 */
public interface IOnItemClickListener<T> extends IBaseOnClickListener {

    /**
     * a simple click
     *
     * @param view     {@see View}
     * @param position
     * @param bean
     */

    void onItemClick(View view, int position, T bean);
}
