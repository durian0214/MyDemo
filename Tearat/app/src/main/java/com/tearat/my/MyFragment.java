package com.tearat.my;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.tearat.R;
import com.tearat.base.BaseFragment;
import com.tearat.my.activity.SidemenuMainActivity;

/**
 * Durian
 * 2017-2017/3/15
 */

public class MyFragment extends BaseFragment implements View.OnClickListener {
    private ImageView img ;
    public static MyFragment newInstance(String name) {
        Bundle args = new Bundle();
        args.putString("name", name);
        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_my:
                intentJump(getActivity(), SidemenuMainActivity.class,null);
                break;
        }
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        img = (ImageView) view.findViewById(R.id.img_my);
    }

    @Override
    protected void setOnClick() {
        img.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;
    }
}
