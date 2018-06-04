package com.jcaseydev.bakingapp.Ui;


import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.jcaseydev.bakingapp.Model.Step;
import com.jcaseydev.bakingapp.R;

/**
 * Created by jcasey on 2/13/18.
 */

public class StepDetailActivity extends SingleFragmentActivity{

    Step stepDetail;
    Bundle bundle;

    @LayoutRes
    protected int getLayoutResId(){
        return R.layout.activity_step_detail;
    }

    @Override
    protected Fragment createFragment() {
        bundle = getIntent().getExtras();
        if (bundle != null){
            stepDetail = bundle.getParcelable("stepdetails");
        }
        return StepDetailFragment.newInstance(stepDetail);
    }

/**    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_detail);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.step_detail_fragment_container);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            stepDetail = bundle.getParcelable("STEPDEETS");
        }

        Bundle stepBundle = new Bundle();
        stepBundle.putParcelable("STEP/DETAILS", stepDetail);

        if (fragment == null) {
            fragment = new StepDetailFragment();
            fragment.setArguments(stepBundle);
            fm.beginTransaction()
                    .add(R.id.step_detail_fragment_container, fragment)
                    .commit();
        }
    }**/
}
