package com.example.gadsleaderboard.UiComponents;



import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.gadsleaderboard.R;
import com.example.gadsleaderboard.ApiComponents.RetrofitClient;
import com.example.gadsleaderboard.ApiComponents.RetrofitClient2;
import com.example.gadsleaderboard.ApiComponents.RetrofitInterface;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmitActivity extends AppCompatActivity {
    EditText editTextFirstName;
    EditText editTextLastname;
    EditText editTextEmail;
    EditText editTextGitubLink;
    AlertDialog dialogBuilderSuccess, dialogBuilderError, dialogBuilder;
    Button submitButton;
    Button yesButton;
    ImageView noButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
//        Toolbar toolbar = findViewById(R.id.toolbar1);
//        setSupportActionBar(toolbar);
//        ActionBar actionBar = getSupportActionBar();
//        assert actionBar != null;
//        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
//        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.setDisplayShowHomeEnabled(true);

        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        actionBar.setDisplayHomeAsUpEnabled(true);


        RetrofitClient.destroyInstance();



        editTextFirstName = findViewById(R.id.firstName);
        editTextLastname = findViewById(R.id.lastName);
        editTextEmail = findViewById(R.id.emailAddress);
        editTextGitubLink = findViewById(R.id.gitHubLink);


        View view = LayoutInflater.from(this).inflate(R.layout.confirm_dialog_question, null, false );
        yesButton = view.findViewById(R.id.btn_confirm_yes);
        noButton = view.findViewById(R.id.btn_close);
        dialogBuilder = new MaterialAlertDialogBuilder(this)
                .setView(view).create();
        submitButton = findViewById(R.id.submit_final);

        dialogBuilderError = new MaterialAlertDialogBuilder(this)
                .setView(LayoutInflater.from(this)
                        .inflate(R.layout.custom_dialog_error_message, null, false)).create() ;

        dialogBuilderSuccess = new MaterialAlertDialogBuilder(this).setView(LayoutInflater.from(this).inflate(R.layout.custom_dialog_success_message, null, false)).create() ;

        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPost();
            }
        });
        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogBuilder.dismiss();

            }
        });



        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isInputsValid()) {
                    dialogBuilder.show();
                } else {
                    Toast.makeText(getApplicationContext(), "Please fill all required fields!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private boolean isInputsValid() {
        return !String.valueOf(editTextFirstName.getText()).isEmpty() && !String.valueOf(editTextLastname.getText()).isEmpty()
                && !String.valueOf(editTextEmail.getText()).isEmpty() && !String.valueOf(editTextGitubLink.getText()).isEmpty();
    }

    private void createPost() {
        RetrofitInterface retrofitInterface = RetrofitClient2.postRetrofitInstance().create(RetrofitInterface.class);
        Call<Void> call = retrofitInterface.submitForm(editTextFirstName.getText().toString(),
                editTextLastname.getText().toString(),
                editTextEmail.getText().toString(),
                editTextGitubLink.getText().toString());
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                    if (response.isSuccessful()){
                        deleteForm("");

                        dialogBuilder.dismiss();
                        Toast.makeText(getApplicationContext(), "File Successfully Submitted", Toast.LENGTH_SHORT).show();
                        dialogBuilderSuccess.show();
                        Handler handler = null;
                        handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                dialogBuilderSuccess.dismiss();
                            }
                        },3000);
//                        Handler dialogHandler = new Handler();
//                        Runnable runnable = new Runnable() {
//                            @Override
//                            public void run() {
//                                if(dialogBuilderSuccess.isShowing()){
//                                    dialogBuilderSuccess.dismiss();
//                                }
//                            }
//                        };
//                        dialogBuilderSuccess.setOnDismissListener(new DialogInterface.OnDismissListener() {
//                            @Override
//                            public void onDismiss(DialogInterface dialogInterface) {
//                                dialogHandler.removeCallbacks(runnable);
//                            }
//                        });
//                        dialogHandler.postDelayed(runnable, 2000);

                    }else{


                    }
                }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "File not Submitted", Toast.LENGTH_SHORT).show();
                deleteForm("");
                dialogBuilder.dismiss();
                dialogBuilderError.show();
                Handler newHandler = null;
                newHandler = new Handler();
                newHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialogBuilderError.dismiss();

                    }
                },3000);



            }
        });



            noButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialogBuilder.dismiss();
                }
            });
            yesButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    createPost();
                    dialogBuilder.dismiss();
                }
            });

        }
    private void deleteForm(String str) {
        editTextFirstName.setText(str);
        editTextLastname.setText(str);
        editTextEmail.setText(str);
        editTextGitubLink.setText(str);


    }
    }


