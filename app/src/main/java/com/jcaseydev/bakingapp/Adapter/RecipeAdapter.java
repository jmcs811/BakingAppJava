package com.jcaseydev.bakingapp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jcaseydev.bakingapp.Model.Recipe;
import com.jcaseydev.bakingapp.R;

import java.util.List;

/**
 * Created by jcasey on 2/7/18.
 */

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {
    private List<Recipe> dataSet;

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView recipeName;

        ViewHolder(View itemView) {
            super(itemView);
            recipeName = itemView.findViewById(R.id.recipe_name);
        }
    }

    public RecipeAdapter(List<Recipe> recipes) {
        dataSet = recipes;
    }

    @Override
    public RecipeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_list_item, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(RecipeAdapter.ViewHolder holder, int position) {
        holder.recipeName.setText(dataSet.get(position).getName());
    }


    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}