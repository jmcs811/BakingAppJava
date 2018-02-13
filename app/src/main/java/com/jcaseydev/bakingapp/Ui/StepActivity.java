package com.jcaseydev.bakingapp.Ui;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.jcaseydev.bakingapp.Model.Ingredient;
import com.jcaseydev.bakingapp.Model.Recipe;
import com.jcaseydev.bakingapp.R;

import java.util.ArrayList;

/**
 * Created by jcasey on 2/8/18.
 */

public class StepActivity extends AppCompatActivity{

    Recipe rList;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.step_fragment_container);

        bundle = getIntent().getExtras();
        if (bundle != null) {
            rList = bundle.getParcelable("STEPS");
           // for (int i = 0; i < rList.getIngredients().size(); i++){
           //     Log.d("INGREDIENTS LIST", rList.getIngredients().get(i).getIngredient());
           // }
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


    }
}
