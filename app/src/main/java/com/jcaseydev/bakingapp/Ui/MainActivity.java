package com.jcaseydev.bakingapp.Ui;

import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;

import com.jcaseydev.bakingapp.Model.Recipe;
import com.jcaseydev.bakingapp.R;

public class MainActivity extends SingleFragmentActivity implements MainFragment.Callbacks{

    //Used to specify which layout to load. Single pane or Dual Pane
    @LayoutRes
    protected int getLayoutResId() {
        return R.layout.activity_masterdetail;
    }

    //Part of SingleFragmentActivity
    @Override
    protected Fragment createFragment() {
        return new MainFragment();
    }

    //Logic to start new activity or to change fragment
    @Override
    public void onRecipeSelected(Recipe recipe) {
        if (findViewById(R.id.detail_fragment_container) == null){
            Intent intent = StepActivity.newIntent(this, recipe);
            startActivity(intent);
        } else {
            Fragment fragment = StepFragment.newInstance(recipe);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_fragment_container, fragment)
                    .commit();
        }
    }
}

