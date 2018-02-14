package com.jcaseydev.bakingapp.Ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jcaseydev.bakingapp.R;

/**
 * Created by jcasey on 2/13/18.
 */

public class StepDetailFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_step_detail, container, false);

        TextView test = v.findViewById(R.id.test);
        test.setText("THIS IS A REAL TEST");

        return v;
    }
}
