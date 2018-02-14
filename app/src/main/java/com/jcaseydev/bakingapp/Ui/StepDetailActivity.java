package com.jcaseydev.bakingapp.Ui;


import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.jcaseydev.bakingapp.R;

/**
 * Created by jcasey on 2/13/18.
 */

public class StepDetailActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_detail);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.step_detail_fragment_container);

        if (fragment == null) {
            fragment = new StepDetailFragment();
            fm.beginTransaction()
                    .add(R.id.step_detail_fragment_container, fragment)
                    .commit();
        }
    }
}
