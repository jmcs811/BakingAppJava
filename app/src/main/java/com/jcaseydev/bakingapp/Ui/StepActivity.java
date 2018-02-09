package com.jcaseydev.bakingapp.Ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.jcaseydev.bakingapp.R;

/**
 * Created by jcasey on 2/8/18.
 */

public class StepActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.step_fragment_container);

        if (fragment == null){
            fragment = new StepFragment();
            fm.beginTransaction()
                    .add(R.id.step_fragment_container, fragment)
                    .commit();
        }


    }
}
