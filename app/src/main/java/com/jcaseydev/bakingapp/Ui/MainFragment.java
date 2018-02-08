package com.jcaseydev.bakingapp.Ui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcaseydev.bakingapp.Adapter.RecipeAdapter;
import com.jcaseydev.bakingapp.Model.Ingredient;
import com.jcaseydev.bakingapp.Model.Recipe;
import com.jcaseydev.bakingapp.Model.Step;
import com.jcaseydev.bakingapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by jcasey on 2/2/18.
 */

public class MainFragment extends Fragment {

    //String jsonURL = "https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json";
    String jsonURL = "https://api.myjson.com/bins/120vox";

    RecyclerView recipeListView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    private List<Recipe> recipesList = new ArrayList<>();


    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        recipeListView = v.findViewById(R.id.recipe_recycler_view);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recipeListView.setLayoutManager(layoutManager);

        adapter = new RecipeAdapter(recipesList);
        recipeListView.setAdapter(adapter);

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        recipesList.clear();
        GetData gd = new GetData();
        gd.execute(jsonURL);
    }

    private class GetData extends AsyncTask<String, Void, Recipe[]> {

        private Recipe[] getJsonData(String json) throws JSONException{

            final String TAG_ID = "id";
            final String TAG_NAME = "name";
            final String TAG_INGREDIENTS = "ingredients";
            final String TAG_QUANTITY = "quantity";
            final String TAG_MEASURE = "measure";
            final String TAG_INGREDIENT = "ingredient";
            final String TAG_STEPS = "steps";
            final String TAG_SDESCP = "shortDescription";
            final String TAG_DESCP = "description";
            final String TAG_VURL = "videoURL";
            final String TAG_SERVINGS = "servings";
            final String TAG_IMAGE = "image";

            JSONArray recipeArray = new JSONArray(json);

            Recipe[] recipes = new Recipe[recipeArray.length()];

            for (int i = 0; i < recipeArray.length(); i++) {
                recipes[i] = new Recipe();

                JSONObject recipeInfo = recipeArray.getJSONObject(i);

                recipes[i].setName(recipeInfo.getString(TAG_NAME));
                recipes[i].setImage(recipeInfo.getString(TAG_IMAGE));
                recipes[i].setServings(recipeInfo.getString(TAG_SERVINGS));

                List<Ingredient> ingredientList = new ArrayList<>();
                List<Step> stepList = new ArrayList<>();

                JSONArray ingredientArray = new JSONArray(recipeInfo.getString(TAG_INGREDIENTS));
                Ingredient[] ingredients = new Ingredient[ingredientArray.length()];

                for(int j = 0; j < ingredientArray.length(); j++){
                    ingredients[j] = new Ingredient();

                    JSONObject ingredientInfo = ingredientArray.getJSONObject(j);

                    ingredients[j].setQuantity(ingredientInfo.getInt(TAG_QUANTITY));
                    ingredients[j].setMeasure(ingredientInfo.getString(TAG_MEASURE));
                    ingredients[j].setIngredient(ingredientInfo.getString(TAG_INGREDIENT));

                    ingredientList.add(ingredients[j]);
                }

                recipes[i].setIngredients(ingredientList);

                JSONArray stepArray = new JSONArray(recipeInfo.getString(TAG_STEPS));
                Step[] steps = new Step[stepArray.length()];

                for(int k = 0; k < stepArray.length(); k++) {
                    steps[k] = new Step();

                    JSONObject stepInfo = stepArray.getJSONObject(k);

                    steps[k].setShortDescription(stepInfo.getString(TAG_SDESCP));
                    steps[k].setDescription(stepInfo.getString(TAG_DESCP));
                    steps[k].setId(stepInfo.getInt(TAG_ID));
                    steps[k].setVideoUrl(stepInfo.getString(TAG_VURL));

                    stepList.add(steps[k]);
                }

                recipes[i].setSteps(stepList);
            }
            return recipes;
        }


     @Override
     protected Recipe[] doInBackground(String... urls) {
         String url = urls[0];

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response;

        String jsonData = null;

         try {
             response = client.newCall(request).execute();
             jsonData = response.body().string();
         } catch (IOException e) {
             e.printStackTrace();
         }

         try {
             return getJsonData(jsonData);
         } catch (JSONException e) {
             e.printStackTrace();
         }
         return null;
     }

        @Override
        protected void onPostExecute(Recipe[] recipes) {
            super.onPostExecute(recipes);
            if(recipes != null) {
                recipesList.addAll(Arrays.asList(recipes));
                adapter.notifyDataSetChanged();
            }
        }
    }
}
