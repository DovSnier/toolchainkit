package com.dvsnier.base.holder;

import android.content.Context;

/**
 * IBaseViewHolder
 * Created by lizw on 2016/5/22.
 * <p>
 * {@see IBaseBindViewHolder}
 *
 * @deprecated
 */
public interface IBaseViewHolder {

    void onBindViewHolder(Context context, int position);
}
