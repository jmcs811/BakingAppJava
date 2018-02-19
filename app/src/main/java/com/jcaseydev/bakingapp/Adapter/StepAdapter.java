package com.jcaseydev.bakingapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jcaseydev.bakingapp.Model.Step;
import com.jcaseydev.bakingapp.R;
import com.jcaseydev.bakingapp.Ui.StepDetailActivity;

import java.util.ArrayList;

/**
 * Created by jcasey on 2/12/18.
 */

public class StepAdapter extends RecyclerView.Adapter<StepAdapter.ViewHolder> {
    private ArrayList<Step> dataSet = new ArrayList<>();

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView stepName;
        CardView stepCardView;

        ViewHolder(View itemView) {
            super(itemView);
            stepName = itemView.findViewById(R.id.step_short_descp);
            stepCardView = itemView.findViewById(R.id.step_card_view);
        }
    }

    public StepAdapter(ArrayList<Step> steps){
        dataSet = steps;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.step_list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.stepName.setText(dataSet.get(position).getShortDescription());
        holder.stepCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, StepDetailActivity.class);
                intent.putExtra("STEPDEETS", dataSet.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
