package com.bawei.zhangjiafu1707b20191203.contract;

import com.bawei.zhangjiafu1707b20191203.entity.Entity;

/**
 * 张家辅
 * 契约接口
 */
public interface Contract {
    //f)使用契约接口统计管理MVP（5分）
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
        //e)封装网络响应接口回调，在接口中封装响应成功和响应失败的两个方法（2.5分）在Model层使用网络响应接口回调（2.5分）
        //成功方法
        void get(Entity entity);
        //失败方法
        void shibai(String string);
    }
}
