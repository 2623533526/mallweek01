package com.bawei.zhangjiafu1707b20191203.view.Fragment;

import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.bawei.zhangjiafu1707b20191203.R;
import com.bawei.zhangjiafu1707b20191203.base.BaseFragment;
import com.bawei.zhangjiafu1707b20191203.contract.Contract;
import com.bawei.zhangjiafu1707b20191203.entity.Entity;
import com.bawei.zhangjiafu1707b20191203.persenter.Persenter;

public class Cart_Fragment extends BaseFragment implements Contract.IView {

    private ListView list;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View inflate) {
        list = inflate.findViewById(R.id.list);
        Persenter persenter = new Persenter(this);
        persenter.get("http://blog.zhaoliang5156.cn/api/mall/mall.json?title=12&price1000&imageurl=1");
    }

    @Override
    protected int layoutid() {
        return R.layout.cart_fragment;
    }

    @Override
    public void get(Entity entity) {
        Log.i("xxx",entity.getCode());
    }
}
