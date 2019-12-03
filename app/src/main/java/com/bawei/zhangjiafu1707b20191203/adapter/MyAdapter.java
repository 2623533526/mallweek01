package com.bawei.zhangjiafu1707b20191203.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.bawei.zhangjiafu1707b20191203.R;
import com.bawei.zhangjiafu1707b20191203.entity.Entity;
import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    Context context;
    List<Entity.ShopGridDataBean> shopGridData;
    public MyAdapter(Context context, List<Entity.ShopGridDataBean> shopGridData) {
        this.context=context;
        this.shopGridData=shopGridData;
    }

    @Override
    public int getCount() {
        return shopGridData.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if(view==null){
            view=View.inflate(context, R.layout.layout_left,null);
            viewHolder = new ViewHolder();
            viewHolder.textView=view.findViewById(R.id.lay_text);
            viewHolder.tity=view.findViewById(R.id.lay_tity);
            viewHolder.imageView=view.findViewById(R.id.lay_image);
            view.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder)view.getTag();
        }
        viewHolder.textView.setText(shopGridData.get(i).getTitle());
        viewHolder.tity.setText(shopGridData.get(i).getPrice());
        Glide.with(context).load(shopGridData.get(i).getImageurl()).into(viewHolder.imageView);
        return view;
    }
    class ViewHolder{
        TextView textView;
        TextView tity;
        ImageView imageView;
    }
}
