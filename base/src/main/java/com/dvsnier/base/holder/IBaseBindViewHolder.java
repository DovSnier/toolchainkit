package com.dvsnier.base.holder;

import android.content.Context;

/**
 * Created by lizw on 2016/5/22.
 */
public interface IBaseBindViewHolder<T> {

    void onBindViewHolder(Context context, int position, T bean);
}
