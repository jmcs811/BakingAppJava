package com.jcaseydev.bakingapp.Ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jcaseydev.bakingapp.Model.Recipe;
import com.jcaseydev.bakingapp.Model.Step;
import com.jcaseydev.bakingapp.R;

import java.util.List;


/**
 * Created by jcasey on 2/8/18.
 */

public class StepFragment extends Fragment{
    List<Step> stepList;
    Step step;
    Recipe rList;
    TextView stepInfo;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_step, container, false);

       /** Intent intent = getActivity().getIntent();
        if (intent != null && intent.hasExtra("STEPS")){
            rList = intent.getParcelableExtra("STEPS");
        }else{
            Log.d("ERROR!!!", "RLIST IS EMPTY");
        }**/


        stepInfo = v.findViewById(R.id.stepText);


        return v;
    }
}
