package com.example.computer.retrofitexample;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.computer.retrofitexample.Model.UserListResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<UserListResponse> userListResponseData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        recyclerView = findViewById(R.id.recycler_view);
        getUserListData();
    }

    private void getUserListData() {
        final ProgressDialog progressDialog = new ProgressDialog(DetailsActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Please Wait");
        progressDialog.show();

        (Api.getClient().getUsersList()).enqueue(new Callback<List<UserListResponse>>() {
            @Override
            public void onResponse(Call<List<UserListResponse>> call, Response<List<UserListResponse>> response) {
                Log.d("responseGet", response.body().get(0).getName());
                progressDialog.dismiss();
                userListResponseData = response.body();
                setDataInRecyclerView();
            }

            @Override
            public void onFailure(Call<List<UserListResponse>> call, Throwable t) {
                Toast.makeText(DetailsActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }

    private void setDataInRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(DetailsActivity.this));
        UsersAdapter usersAdapter = new UsersAdapter(DetailsActivity.this, userListResponseData);
        recyclerView.setAdapter(usersAdapter);
    }
}
