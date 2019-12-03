package com.bawei.zhangjiafu1707b20191203.model;

import android.util.Log;

import com.bawei.zhangjiafu1707b20191203.Utils.NetUtil;
import com.bawei.zhangjiafu1707b20191203.contract.Contract;
import com.bawei.zhangjiafu1707b20191203.entity.Entity;
import com.google.gson.Gson;

public class Model implements Contract.IModel {




    @Override
    public void get(String string, final Datat datat) {
        Log.i("XXX",string);
        NetUtil.getInstance().getjson(string, new NetUtil.Datat() {
            @Override
            public void get(String str) {
                Gson gson = new Gson();
                Entity entity = gson.fromJson(str, Entity.class);
              datat.getEntity(entity);
            }
        });
    }
}
