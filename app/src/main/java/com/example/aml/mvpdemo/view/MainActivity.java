package com.example.aml.mvpdemo.view;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.aml.mvpdemo.R;
import com.example.aml.mvpdemo.presenter.MainActivityPresenter;

public class MainActivity extends AppCompatActivity implements MainActivityPresenter.View {

    MainActivityPresenter mainActivityPresenter ;
    private TextView textView ;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mainActivityPresenter = new MainActivityPresenter(this);
        textView = findViewById(R.id.myTextView);
        EditText userName = findViewById(R.id.username);
        EditText email = findViewById(R.id.email);
        initProgressBar();

        userName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                mainActivityPresenter.updateFullName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

                hideProgress();
            }
        });
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
mainActivityPresenter.updateEmail(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

                hideProgress();
            }
        });
    }

    private void initProgressBar() {

        progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleSmall);
        progressBar.setIndeterminate(true);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(Resources.getSystem().getDisplayMetrics().widthPixels,
                250);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        this.addContentView(progressBar, params);
        showProgress();

    }

    @Override
    public void updateUserInfoTextView(String fullName) {

        textView.setText(fullName);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {

        progressBar.setVisibility(View.GONE);
    }
}
