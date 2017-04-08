package com.arstotzka.pruebadecodigo.Views.UserList;

import com.arstotzka.pruebadecodigo.Model.User;

import java.util.List;

/**
 * Created by Dani on 08/04/2017.
 */

public class UserListPresenter implements UserListContract.Presenter{

    private UserListContract.View view;
    private UserListContract.Interactor interactor;

    private int lastId;

    public UserListPresenter(UserListContract.View view) {
        this.view = view;
        this.interactor = new UserListInteractor(this);
    }

    @Override
    public void getUsers() {
        interactor.retrieveUsers(lastId);
    }

    @Override
    public void onRetrievedUsers(List<User> users) {
        lastId = users.get(users.size()-1).getId();

        view.onGetUsers(users);
    }
}
