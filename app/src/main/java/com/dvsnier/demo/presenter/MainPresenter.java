package com.dvsnier.demo.presenter;

import android.support.annotation.NonNull;
import android.widget.Toast;

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

    protected List<MainBean> dataSet = new ArrayList<>();

    public void request() {
        for (int i = 0; i < 50; i++) {
            MainBean bean = new MainBean();
            switch (i) {
                case 0:
                    bean.setText("0. 测试 Stash");
                    break;
                case 1:
                    bean.setText("1. 测试3s 延迟 Stash");
                    break;
                case 2:
                    bean.setText("2. 测试 Post");
                    break;
                case 3:
                    bean.setText("3. 测试3s 延迟 Post");
                    break;
                default:
                    bean.setText(String.format("%s. Test Data", i));
                    break;
            }
            dataSet.add(bean);
        }
        if (null != getView()) {
            getView().getAdapter().setData(dataSet);
            getView().getAdapter().notifyDataSetChanged();
        }

    }

    public void testStash() {
        stashOnRun(new StashRunnable() {
            @Override
            public void run(@NonNull MainActivity view) {
                Toast.makeText(view, "测试 Stash", Toast.LENGTH_SHORT).show();
                MainBean bean = new MainBean();
                bean.setText(String.format("Test Describe: %s", "测试 Stash 方法"));
                if (getView() != null) {
                    getView().getAdapter().add(bean);
                    getView().getAdapter().notifyItemChanged(dataSet.size() - 1);
                }
            }
        });
    }

    public void testStashOf3s() {
        stashOnRun(new StashRunnable() {
            @Override
            public void run(@NonNull MainActivity view) {
                Toast.makeText(view, "延迟3s 测试", Toast.LENGTH_SHORT).show();
                MainBean bean = new MainBean();
                bean.setText(String.format("Test Describe: %s", "延迟3s(后台)"));
                if (getView() != null) {
                    getView().getAdapter().add(bean);
                    getView().getAdapter().notifyItemChanged(dataSet.size() - 1);
                }
            }
        }, 3000);
    }
}
