package com.jcaseydev.bakingapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcaseydev.bakingapp.Model.Recipe;

import java.io.IOException;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by jcasey on 2/2/18.
 */

public class MainFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        return v;
    }

 /**   private void getJson() throws IOException {
        String url = "https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json";
        OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            Response response = client.newCall(request).execute();

            System.out.println(response.body().string());
        }**/

    private class GetData extends AsyncTask<URL, Void, Recipe[]> {

     @Override
     protected Recipe[] doInBackground(URL... urls) {
         URL url = urls[0];

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = null;

         try {
             response = client.newCall(request).execute();
             String jsonData = response.body().string();
         } catch (IOException e) {
             e.printStackTrace();
         }



         return new Recipe[0];


     }

     private Recipe[] getJsonData(){

         final String TAG_ID = "id";
         final String TAG_NAME = "name";
         final String TAG_INGREDIENTS = "ingredients";
         final String TAG_QUANTITY = "quantity";
         final String TAG_MEASURE = "measure";
         final String TAG_ingredient = "ingredient";
         final String TAG_SETPS = "setps";
         final String TAG_SDESCP = "shortDescription";
         final String TAG_DESCP = "description";
         final String TAG_VURL = "videoURL";
         final String TAG_SERVIGNS = "servings";

         return null;
     }


   }
}
