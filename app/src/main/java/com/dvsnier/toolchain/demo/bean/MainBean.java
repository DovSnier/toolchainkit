package com.dvsnier.toolchain.demo.bean;

import com.dvsnier.base.bean.BaseBean;

/**
 * MainBean
 * Created by DovSnier on 2018/7/15.
 */
public class MainBean extends BaseBean {

    protected String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "MainBean{" +
                "text='" + text + '\'' +
                '}';
    }
}