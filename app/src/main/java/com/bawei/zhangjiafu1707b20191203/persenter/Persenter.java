package com.bawei.zhangjiafu1707b20191203.persenter;

import android.util.Log;

import com.bawei.zhangjiafu1707b20191203.contract.Contract;
import com.bawei.zhangjiafu1707b20191203.entity.Entity;
import com.bawei.zhangjiafu1707b20191203.model.Model;

public class Persenter implements Contract.IPresenter {
    private Contract.IView iView;
    public Persenter(Contract.IView iView) {
        this.iView=iView;
    }

    @Override
    public void get(String string) {
        Log.i("xxx",string);
        Model model = new Model();
        model.get(string, new Contract.IModel.Datat() {
            @Override
            public void getEntity(Entity entity) {
                iView.get(entity);
            }
        });
    }
}
