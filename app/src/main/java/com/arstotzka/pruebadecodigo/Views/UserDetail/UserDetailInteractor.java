package com.arstotzka.pruebadecodigo.Views.UserDetail;

import com.arstotzka.pruebadecodigo.App;
import com.arstotzka.pruebadecodigo.Model.UserDetail;
import com.arstotzka.pruebadecodigo.Utils.NetCallback;
import com.arstotzka.pruebadecodigo.Utils.NetworkUtils;

import javax.inject.Inject;

/**
 * Created by Dani on 08/04/2017.
 */

public class UserDetailInteractor implements UserDetailContract.Interactor {

    @Inject
    NetworkUtils networkUtils;

    private UserDetailContract.Presenter presenter;

    public UserDetailInteractor(UserDetailContract.Presenter presenter) {
        App.getmComponent().inject(this);
        this.presenter = presenter;
    }


    @Override
    public void retrieveUser(String userUrl) {
        networkUtils.requestUser(userUrl, new NetCallback<UserDetail>() {
            @Override
            public void onSuccess(UserDetail o) {
                presenter.onRetrievedUser(o);
            }

            @Override
            public void onError(Object o) {

            }
        });
    }
}
