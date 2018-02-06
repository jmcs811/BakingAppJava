package com.jcaseydev.bakingapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jcasey on 2/5/18.
 */

public class Recipe implements Parcelable{

    private String name;
    private String servings;
    private List<Ingredient> ingredients;
    private List<Step> steps;

    public String getName() {
        return name;
    }

    public String getServings() {
        return servings;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<Step> getSteps() {
        return steps;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(servings);
        dest.writeList(ingredients);
        dest.writeList(steps);
    }

    private Recipe(Parcel in) {
        name = in.readString();
        servings = in.readString();

        ingredients = new ArrayList<>();
        in.readList(ingredients, Ingredient.class.getClassLoader());

        steps = new ArrayList<>();
        in.readList(steps, Step.class.getClassLoader());
    }

    public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };
}
