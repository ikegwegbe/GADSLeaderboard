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

import com.example.gadsleaderboard.DataModel.DataModelSkillIq;
import com.example.gadsleaderboard.R;
import com.example.gadsleaderboard.Adapters.RecyclerViewAdapterSkill;
import com.example.gadsleaderboard.ApiComponents.RetrofitClient;
import com.example.gadsleaderboard.ApiComponents.RetrofitInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SkillIQFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerViewAdapterSkill adapter;
    LinearLayoutManager layoutManager;



    public SkillIQFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_skill_i_q, container, false);
        recyclerView = view.findViewById(R.id.myRecyclerViewSkills);
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        RetrofitInterface retrofitInterface = RetrofitClient.getRetrofitInstance().create(RetrofitInterface.class);
        Call<List<DataModelSkillIq>> call = retrofitInterface.getSkillIqLeaders();
        call.enqueue(new Callback<List<DataModelSkillIq>>() {
            @Override
            public void onResponse(Call<List<DataModelSkillIq>> call, Response<List<DataModelSkillIq>> response) {
                loadData(response.body());
                if(response.isSuccessful()) {
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<List<DataModelSkillIq>> call, Throwable t) {

            }
        });


        return view;
    }

    private void loadData(List<DataModelSkillIq> body) {
        Context context;
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerViewAdapterSkill(body);
        recyclerView.setAdapter(adapter);
    }

}