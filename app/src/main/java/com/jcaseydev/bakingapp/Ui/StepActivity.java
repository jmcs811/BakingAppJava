package com.jcaseydev.bakingapp.Ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.jcaseydev.bakingapp.Model.Recipe;
import com.jcaseydev.bakingapp.R;

/**
 * Created by jcasey on 2/8/18.
 */

public class StepActivity extends SingleFragmentActivity{

    Recipe rList;
    Bundle bundle;


    @Override
    protected int getLayoutResId(){
        return R.layout.activity_step;
    }

    @Override
    protected Fragment createFragment() {
     bundle = getIntent().getExtras();
     if (bundle != null){
        rList = bundle.getParcelable("STEPS");
     }
     return StepFragment.newInstance(rList);
    }

}
