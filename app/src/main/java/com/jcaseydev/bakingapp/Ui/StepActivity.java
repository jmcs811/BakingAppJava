package com.jcaseydev.bakingapp.Ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

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

    /**  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.step_fragment_container);

        bundle = getIntent().getExtras();
        if (bundle != null) {
            rList = bundle.getParcelable("STEPS");
        }

        Bundle newBundle = new Bundle();
        newBundle.putParcelable("STEPS/INGREDIENTS", rList);

        if (fragment == null){
            fragment = new StepFragment();
            fragment.setArguments(newBundle);
            fm.beginTransaction()
                    .add(R.id.step_fragment_container, fragment)
                    .commit();
        }

    }**/
}
