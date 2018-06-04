package com.jcaseydev.bakingapp.Ui;

import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;

import com.jcaseydev.bakingapp.R;

public class MainActivity extends SingleFragmentActivity {

    @LayoutRes
    protected int getLayoutResId() {
        return R.layout.activity_masterdetail;
    }

    @Override
    protected Fragment createFragment() {
        return new MainFragment();
    }
}

