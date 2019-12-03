package com.bawei.zhangjiafu1707b20191203.contract;

import com.bawei.zhangjiafu1707b20191203.entity.Entity;

public interface Contract {
    interface IModel{
        void get(String string,Datat datat);
        interface Datat{
            void getEntity(Entity entity);
        }
    }
    interface IPresenter{
        void get(String string);
    }
    interface  IView{
        void get(Entity entity);
    }
}
