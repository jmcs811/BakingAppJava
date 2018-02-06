package com.jcaseydev.bakingapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jcasey on 2/5/18.
 */

public class Recipe implements Parcelable{

    private String name;
    private String servings;

    public String getName() {
        return name;
    }

    public String getServings() {
        return servings;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(servings);
    }

    private Recipe(Parcel in) {
        name = in.readString();
        servings = in.readString();
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
