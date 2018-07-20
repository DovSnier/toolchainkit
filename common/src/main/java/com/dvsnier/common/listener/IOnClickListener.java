package com.dvsnier.common.listener;

import android.view.View;

import com.dvsnier.base.IBaseOnClickListener;

/**
 * IOnClickListener
 * Created by lizw on 2016/6/18.
 */
public interface IOnClickListener extends IBaseOnClickListener {

    void onClick(View view, int position);
}
