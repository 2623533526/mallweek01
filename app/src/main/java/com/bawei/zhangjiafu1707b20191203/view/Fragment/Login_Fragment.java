package com.bawei.zhangjiafu1707b20191203.view.Fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.zhangjiafu1707b20191203.R;
import com.bawei.zhangjiafu1707b20191203.Utils.NetUtil;
import com.bawei.zhangjiafu1707b20191203.base.BaseFragment;

public class Login_Fragment extends BaseFragment {

    private ImageView vis_image;
    private TextView vis_text;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View inflate) {
        vis_image = inflate.findViewById(R.id.vis_image);
        vis_text = inflate.findViewById(R.id.vis_text);
        if(NetUtil.getInstance().has(getContext())){
            vis_image.setVisibility(View.INVISIBLE);
            vis_text.setVisibility(View.VISIBLE);
        }else {
            vis_text.setVisibility(View.INVISIBLE);
            vis_image.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected int layoutid() {
        return R.layout.login_fragment;
    }
}
