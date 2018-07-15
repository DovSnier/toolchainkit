package com.dvsnier.common.listener;

import android.view.View;

import com.dvsnier.base.IBaseOnClickListener;

/**
 * IOnItemClickListener
 * Created by lizw on 2016/6/18.
 */
public interface IOnItemClickListener<T> extends IBaseOnClickListener {

    void onClick(View view, int position, T bean);
}
