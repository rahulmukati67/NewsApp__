package com.example.newsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SportsFragment extends Fragment {

    String api = "a37611e4a3484864adb46d90add23a66";
    ArrayList<ModelCLass> modelCLassArrayList;
    Adapter adapter;
    String country = "in";
    private RecyclerView recyclerviewofsports;
    private String category = "sports";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.sportsfragment, null);

        recyclerviewofsports= v.findViewById(R.id.recyclerviewofsports);
        modelCLassArrayList = new ArrayList<>();
        recyclerviewofsports.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(), modelCLassArrayList);
        recyclerviewofsports.setAdapter(adapter);
        findNews();
        return v;
    }

    private void findNews() {

        ApiUtilities.getApiInterface().getNews(country,category,100,api).enqueue(new Callback<MainClass>() {
            @Override
            public void onResponse(Call<MainClass> call, Response<MainClass> response) {
                if(response.isSuccessful()){
                    modelCLassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<MainClass> call, Throwable t) {

            }
        });
    }
}
