package com.jcaseydev.bakingapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jcaseydev.bakingapp.Model.Recipe;
import com.jcaseydev.bakingapp.R;
import com.jcaseydev.bakingapp.Ui.StepActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by jcasey on 2/7/18.
 */

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {
    private List<Recipe> dataSet;
    private RecyclerView recyclerView;


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView recipeName;
        ImageView recipeThumbnail;
        CardView cardView;

        ViewHolder(View itemView) {
            super(itemView);
            recipeName = itemView.findViewById(R.id.recipe_name);
            recipeThumbnail = itemView.findViewById(R.id.recipe_thumbnail);
            recyclerView = itemView.findViewById(R.id.recipe_recycler_view);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }

    public RecipeAdapter(List<Recipe> recipes) {
        dataSet = recipes;
    }

    @Override
    public RecipeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_list_item, parent, false);

        return new ViewHolder(view);
    }

    public void onBindViewHolder(RecipeAdapter.ViewHolder holder, int position) {
        final Context context = holder.recipeThumbnail.getContext();

        holder.recipeName.setText(dataSet.get(position).getName());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context newContext = v.getContext();
                Intent intent = new Intent(newContext, StepActivity.class);
                newContext.startActivity(intent);
            }
        });

        if (dataSet.get(position).getImage().isEmpty()) {
            Log.d("RecipeAdapter.class", "Image Path is empty");
        }else{
            Log.d("image != null", dataSet.get(position).getImage() + "yeah");
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