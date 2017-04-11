package com.tearat.home;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.tearat.R;
import com.tearat.base.BaseFragment;

/**
 * Durian
 * 2017-2017/3/15
 */

public class HomeFragment extends BaseFragment implements View.OnClickListener {
    RecyclerView rv;
    public static HomeFragment newInstance(String name) {
        Bundle args = new Bundle();
        args.putString("name",name);
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onClick(View v) {

    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        rv = (RecyclerView) view.findViewById(R.id.rv_home);
    }

    @Override
    protected void setOnClick() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }
}
