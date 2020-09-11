package com.example.gadsleaderboard.UiComponents;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gadsleaderboard.DataModel.DataModelLearners;
import com.example.gadsleaderboard.R;
import com.example.gadsleaderboard.Adapters.RecyclerViewAdapterLearners;
import com.example.gadsleaderboard.ApiComponents.RetrofitClient;
import com.example.gadsleaderboard.ApiComponents.RetrofitInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LearnerHoursFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerViewAdapterLearners adapter;

    public LearnerHoursFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_learner_hours, container, false);
        recyclerView = view.findViewById(R.id.myRecyclerViewHours);
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.show();



        RetrofitInterface retrofitInterface = RetrofitClient.getRetrofitInstance().create(RetrofitInterface.class);
        Call<List<DataModelLearners>> call = retrofitInterface.getLearningLeaders();
        call.enqueue(new Callback<List<DataModelLearners>>() {
            @Override
            public void onResponse(Call<List<DataModelLearners>> call, Response<List<DataModelLearners>> response) {
                data(response.body());
                if(response.isSuccessful()) {
                    progressDialog.dismiss();
                }

            }

            @Override
            public void onFailure(Call<List<DataModelLearners>> call, Throwable t) {

            }
        });

        return view
                ;
    }
    public void data(List<DataModelLearners> body){

        Context context;
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerViewAdapterLearners(body);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }
}