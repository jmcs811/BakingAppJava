package com.jcaseydev.bakingapp.Ui;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jcaseydev.bakingapp.Adapter.StepAdapter;
import com.jcaseydev.bakingapp.Model.Recipe;
import com.jcaseydev.bakingapp.Model.Step;
import com.jcaseydev.bakingapp.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by jcasey on 2/8/18.
 */

public class StepFragment extends Fragment{

    Recipe rList;
    RecyclerView stepsView;
    RecyclerView.Adapter stepsAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<Step> stepArrayList;

    private static final String STEP_ID = "test";

    public static StepFragment newInstance(Recipe recipeList){
        Bundle args = new Bundle();
        args.putParcelable(STEP_ID, recipeList);

        StepFragment fragment = new StepFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null){
            rList = getArguments().getParcelable(STEP_ID);
            if (rList != null) {
                stepArrayList = rList.getSteps();
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_step, container, false);

        LinearLayout ingredientLayout = v.findViewById(R.id.ingredient_layout);

        //Ingredients List
        for (int i = 0; i < rList.getIngredients().size(); i++){
            TextView ingredient = new TextView(getContext());
            TextView quantityAndMeasure = new TextView(getContext());

            ingredient.setId(i + 5);
            ingredient.setText(rList.getIngredients().get(i).getIngredient());
            ingredient.setAllCaps(true);
            ingredient.setTextSize(12);
            ingredient.setTypeface(null, Typeface.BOLD);

            quantityAndMeasure.setId(i + 4);
            quantityAndMeasure.setTextSize(10);
            quantityAndMeasure.setText(rList.getIngredients().get(i).getQuantity() + " " + rList.getIngredients().get(i).getMeasure());

            ingredientLayout.addView(ingredient);
            ingredientLayout.addView(quantityAndMeasure);
        }

        stepsView = v.findViewById(R.id.step_recycler_view);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        stepsView.setLayoutManager(layoutManager);

        ArrayList<Step> newsteps = new ArrayList<>(stepArrayList);

        stepsAdapter = new StepAdapter(newsteps);
        stepsView.setAdapter(stepsAdapter);
        stepsAdapter.notifyDataSetChanged();
        return v;
    }
}
