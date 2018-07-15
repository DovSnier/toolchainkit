package com.dvsnier.demo.presenter;

import com.dvsnier.common.presenter.BaseCompatPresenter;
import com.dvsnier.demo.bean.MainBean;
import com.dvsnier.demo.view.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * MainPresenter
 * Created by dovsnier on 2018/7/2.
 */
public class MainPresenter extends BaseCompatPresenter<MainActivity> {

    public void request() {
        List<MainBean> dataSet = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            MainBean bean = new MainBean();
            bean.setText(String.format("%s. Test Data", i));
            dataSet.add(bean);
        }
        if (null != getView()) {
            getView().getAdapter().setData(dataSet);
            getView().getAdapter().notifyDataSetChanged();
        }
    }
}
