package com.example.aml.mvpdemo.presenter;

import com.example.aml.mvpdemo.model.User;

public class MainActivityPresenter {

    private View view ;
    private User user ;

    public MainActivityPresenter(View view) {
        this.view = view;
        this.user = new User();
    }

    public void updateFullName (String fullName) {
        user.setFullName(fullName);
        view.updateUserInfoTextView(user.toString());
    }

    public void updateEmail (String email){
        user.setEmail(email);
        view.updateUserInfoTextView(user.toString());
    }
    public interface View {

        void updateUserInfoTextView (String fullName);
        void showProgress();
        void hideProgress();
    }
}
