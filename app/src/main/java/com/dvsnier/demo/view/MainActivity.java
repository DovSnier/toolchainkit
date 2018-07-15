package com.dvsnier.demo.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.dvsnier.base.view.ICompatV1BaseView;
import com.dvsnier.common.listener.IOnClickListener;
import com.dvsnier.common.view.BaseCompatActivity;
import com.dvsnier.demo.R;
import com.dvsnier.demo.adapter.MainAdapter;
import com.dvsnier.demo.presenter.MainPresenter;

/**
 * MainActivity
 */
public class MainActivity extends BaseCompatActivity<MainPresenter> implements ICompatV1BaseView, IOnClickListener {

    private RecyclerView recycleView;
    private MainAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    @Override
    public void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        recycleView = (RecyclerView) findViewById(R.id.recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleView.setLayoutManager(layoutManager);
        adapter = new MainAdapter(this);
        adapter.setOnClickListener(this);
        recycleView.setAdapter(adapter);
    }

    @Override
    public void initData() {
        if (null != getPresenter()) {
            getPresenter().request();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent();
        switch (item.getItemId()) {
            case R.id.action_edit:
                intent.setClass(this, DemoActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                return true;
            case R.id.action_share:
                Toast.makeText(this, "...", Toast.LENGTH_SHORT).show();
//                intent.setClass(this,DemoActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
//                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public MainAdapter getAdapter() {
        return adapter;
    }

    @Override
    public void onClick(View view, int position) {
        Toast.makeText(this, "position: " + position, Toast.LENGTH_SHORT).show();
    }
}
