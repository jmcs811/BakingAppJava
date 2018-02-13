package com.jcaseydev.bakingapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jcaseydev.bakingapp.Model.Recipe;
import com.jcaseydev.bakingapp.R;
import com.jcaseydev.bakingapp.Ui.StepActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by jcasey on 2/7/18.
 */

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {
    private ArrayList<Recipe> dataSet = new ArrayList<>();


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView recipeName;
        ImageView recipeThumbnail;
        CardView cardView;

        ViewHolder(View itemView) {
            super(itemView);
            recipeName = itemView.findViewById(R.id.recipe_name);
            recipeThumbnail = itemView.findViewById(R.id.recipe_thumbnail);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }

    public RecipeAdapter(ArrayList<Recipe> recipes) {
        dataSet = recipes;
    }

    @Override
    public RecipeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_list_item, parent, false);

        return new ViewHolder(view);
    }

    public void onBindViewHolder(RecipeAdapter.ViewHolder holder, final int position) {
        final Context context = holder.recipeThumbnail.getContext();
        final int currentPos = holder.getAdapterPosition();

        holder.recipeName.setText(dataSet.get(position).getName());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context newContext = v.getContext();
                Intent intent = new Intent(newContext, StepActivity.class);
                intent.putExtra("STEPS", dataSet.get(currentPos));
                newContext.startActivity(intent);
            }
        });

        if (dataSet.get(position).getImage().isEmpty()) {
            holder.recipeThumbnail.setVisibility(View.INVISIBLE);
        }else{
            Picasso.with(context).load(dataSet.get(position)
                    .getImage())
                    .placeholder(R.drawable.error)
                    .error(R.drawable.error)
                    .into(holder.recipeThumbnail);
        }
    }


    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}