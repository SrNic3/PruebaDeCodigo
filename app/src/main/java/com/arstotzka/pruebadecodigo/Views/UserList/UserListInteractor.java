package com.arstotzka.pruebadecodigo.Views.UserList;

import com.arstotzka.pruebadecodigo.App;
import com.arstotzka.pruebadecodigo.Model.User;
import com.arstotzka.pruebadecodigo.Utils.NetCallback;
import com.arstotzka.pruebadecodigo.Utils.NetworkUtils;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Dani on 08/04/2017.
 */

public class UserListInteractor implements UserListContract.Interactor{


    @Inject
    NetworkUtils networkUtils;

    private UserListContract.Presenter presenter;

    public UserListInteractor(UserListContract.Presenter presenter) {
        App.getmComponent().inject(this);
        this.presenter = presenter;

    }

    @Override
    public void retrieveUsers(int lastId) {
        networkUtils.requestUserList(lastId, new NetCallback<List<User>>() {
            @Override
            public void onSuccess(List<User> users) {
                presenter.onRetrievedUsers(users);
            }

            @Override
            public void onError(Object o) {

            }
        });
    }
}
