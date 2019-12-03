package com.bawei.zhangjiafu1707b20191203.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 基类
 */
public abstract class BaseActivity extends AppCompatActivity {
    //e)封装Activity与Fragment基类，在基类中抽取统一加载布局，加载数据的方法（2.5）在项目中使用基类（2.5分）
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutid());
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int layoutid();
}
