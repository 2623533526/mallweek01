package com.bawei.zhangjiafu1707b20191203.view.Fragment;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import androidx.viewpager.widget.ViewPager;

import com.bawei.zhangjiafu1707b20191203.R;
import com.bawei.zhangjiafu1707b20191203.adapter.MyAdapter;
import com.bawei.zhangjiafu1707b20191203.base.BaseFragment;
import com.bawei.zhangjiafu1707b20191203.contract.Contract;
import com.bawei.zhangjiafu1707b20191203.entity.Entity;
import com.bawei.zhangjiafu1707b20191203.persenter.Persenter;

public class Cart_Fragment extends BaseFragment implements Contract.IView {

    private GridView grid;
    private Button bt;
    private ViewPager vp;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View inflate) {
        grid = inflate.findViewById(R.id.grid);
        bt = inflate.findViewById(R.id.bt);
        vp = getActivity().findViewById(R.id.vp);
        //ii.点击图2购物车页面的去购物跳转到首页图1。
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vp.setCurrentItem(0);
            }
        });

        Persenter persenter = new Persenter(this);
        persenter.get("http://blog.zhaoliang5156.cn/api/mall/mall.json?title=12&price1000&imageurl=1");
    }

    @Override
    protected int layoutid() {
        return R.layout.cart_fragment;
    }

    @Override
    public void get(Entity entity) {
        MyAdapter myAdapter = new MyAdapter(getActivity(), entity.getShopGridData());
        grid.setAdapter(myAdapter);
    }

    @Override
    public void shibai(String string) {

    }
}
