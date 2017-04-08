package com.arstotzka.pruebadecodigo.Views.UserDetail;

import com.arstotzka.pruebadecodigo.Model.User;
import com.arstotzka.pruebadecodigo.Model.UserDetail;
import com.arstotzka.pruebadecodigo.Utils.ADB;

/**
 * Created by Dani on 08/04/2017.
 */

public class UserDetailPresenter implements UserDetailContract.Presenter {

    private UserDetailContract.View view;
    private UserDetailContract.Interactor interactor;

    public UserDetailPresenter(UserDetailContract.View view) {
        this.view = view;
        this.interactor = new UserDetailInteractor(this);
    }

    @Override
    public void getUser() {
        User user = (User) ADB.getObject();
        interactor.retrieveUser(user.getUrl());
    }

    @Override
    public void onRetrievedUser(UserDetail user) {
        view.onGetUser(user);
    }
}
