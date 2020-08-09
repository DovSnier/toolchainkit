package com.dvsnier.toolchain.demo.view;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.dvsnier.base.task.UIRunnable;
import com.dvsnier.common.compat.ICompatBaseView;
import com.dvsnier.common.listener.IOnClickListener;
import com.dvsnier.common.view.BaseCompatActivity;
import com.dvsnier.permission.OnSimpleResponsePermissionListener;
import com.dvsnier.permission.Permission;
import com.dvsnier.permission.PermissionWrapper;
import com.dvsnier.toolchain.demo.R;
import com.dvsnier.toolchain.demo.adapter.MainAdapter;
import com.dvsnier.toolchain.demo.presenter.MainPresenter;

import java.util.Arrays;

/**
 * MainActivity
 */
public class MainActivity extends BaseCompatActivity<MainPresenter> implements ICompatBaseView, IOnClickListener {

    private RecyclerView recyclerView;
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
        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MainAdapter(this);
        adapter.setOnClickListener(this);
        recyclerView.setAdapter(adapter);
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
//        Toast.makeText(this, "position: " + position, Toast.LENGTH_SHORT).show();
        switch (position) {
            case 0:
                if (getPresenter() != null) {
                    getPresenter().testStash();
                }
                break;
            case 1:
                postDelayed(new UIRunnable() {
                    @Override
                    public void uiRun() {
                        if (getPresenter() != null) {
                            getPresenter().testStashOf3s();
                        }
                    }
                }, 3000);

                break;
            case 2:
                post(new UIRunnable() {
                    @Override
                    public void uiRun() {
                        if (getPresenter() != null) {
                            getPresenter().testStash();
                        }
                    }
                });
                break;
            case 3:
                postDelayed(new UIRunnable() {
                    @Override
                    public void uiRun() {
                        if (getPresenter() != null) {
                            getPresenter().testStash();
                        }
                    }
                }, 3000);
                break;
            case 4:
                PermissionWrapper.newInstance(this).requestPermission(
//                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.CALL_PHONE,
                        new OnSimpleResponsePermissionListener() {
                            @Override
                            public void onPermissionCallback(Context context, boolean isGrant, Permission permission) {
                                super.onPermissionCallback(context, isGrant, permission);
                                String value = String.format("isGrant: %s , isNegatived: %s , isNegativedAndNoPresentation: %s , permission: %s"
                                        , isGrant, permission.isNegatived(),
                                        permission.isNegativedAndNoPresentation(), permission);
                                Log.d(TAG, value);
                                Toast.makeText(context, value, Toast.LENGTH_SHORT).show();
                            }
                        });
                break;
            case 5:
                String[] permissions = new String[]{
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.INTERNET,
                        Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.CALL_PHONE};
                PermissionWrapper.newInstance(this).requestPermission(permissions,
                        new OnSimpleResponsePermissionListener() {
                            @Override
                            public void onPermissionCallback(Context context, boolean isGrant, Permission[] permissions) {
                                super.onPermissionCallback(context, isGrant, permissions);
                                String value = String.format("isGrant: %s , permission: %s", isGrant, Arrays.toString(permissions));
                                Log.d(TAG, value);
                                Toast.makeText(context, value, Toast.LENGTH_SHORT).show();
                            }
                        });
                break;
        }
    }
}
