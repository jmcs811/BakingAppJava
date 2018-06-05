package com.jcaseydev.bakingapp.Ui;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.jcaseydev.bakingapp.Model.Recipe;
import com.jcaseydev.bakingapp.Model.Step;
import com.jcaseydev.bakingapp.R;

/**
 * Created by jcasey on 2/8/18.
 */

public class StepActivity extends SingleFragmentActivity{

    Recipe rList;
    Bundle bundle;

    //Used to derterming which layout to use
    @Override
    protected int getLayoutResId(){
        return R.layout.activity_step;
    }

    //Used by SingleFragmentActivity
    @Override
    protected Fragment createFragment() {
     bundle = getIntent().getExtras();
     if (bundle != null){
        rList = bundle.getParcelable("test");
     }
     return StepFragment.newInstance(rList);
    }

    //Consolidated code for starting new StepActivity
    public static Intent newIntent(Context context, Recipe recipe) {
        Intent intent = new Intent(context, StepActivity.class);
        intent.putExtra("test", recipe);
        return intent;
    }
}
