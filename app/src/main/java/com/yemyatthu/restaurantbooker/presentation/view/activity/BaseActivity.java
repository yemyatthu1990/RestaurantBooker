package com.yemyatthu.restaurantbooker.presentation.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;

/**
 * Created by Ye Myat Thu on 2/8/2017.
 */


public abstract class BaseActivity extends Activity{
    BaseActivity(){

    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentLayout());
        ButterKnife.bind(this);
        initComponents();
    }

    public abstract int getContentLayout();

    public abstract void initComponents();
}
