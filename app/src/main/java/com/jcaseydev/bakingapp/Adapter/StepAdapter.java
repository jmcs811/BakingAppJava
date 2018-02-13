package com.jcaseydev.bakingapp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jcaseydev.bakingapp.Model.Recipe;
import com.jcaseydev.bakingapp.Model.Step;
import com.jcaseydev.bakingapp.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by jcasey on 2/12/18.
 */

public class StepAdapter extends RecyclerView.Adapter<StepAdapter.ViewHolder> {
    private ArrayList<Step> dataSet = new ArrayList<>();

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView stepShortDescp;

        public ViewHolder(View itemView) {
            super(itemView);
            stepShortDescp = itemView.findViewById(R.id.step_short_desp);
        }
    }

    public StepAdapter(ArrayList<Step> steps){
        dataSet = steps;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.step_list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.stepShortDescp.setText(dataSet.get(position).getShortDescription());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
