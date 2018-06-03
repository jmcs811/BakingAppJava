package com.jcaseydev.bakingapp.Ui;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.view.View;

import com.jcaseydev.bakingapp.R;

public class MainActivity extends SingleFragmentActivity {
    boolean mIsDualPane;

    @Override
    protected Fragment createFragment() {
        return new MainFragment();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View articleView = findViewById(R.id.recipe_list);
        mIsDualPane = articleView != null && articleView.getVisibility() == View.VISIBLE;
    }
}

