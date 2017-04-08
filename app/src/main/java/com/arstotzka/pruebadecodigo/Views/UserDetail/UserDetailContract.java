package com.arstotzka.pruebadecodigo.Views.UserDetail;

import com.arstotzka.pruebadecodigo.Model.UserDetail;

/**
 * Created by Dani on 08/04/2017.
 */

public class UserDetailContract {

    protected interface View {

        void onGetUser(UserDetail user);
    }

    protected interface Presenter {

        void getUser();

        void onRetrievedUser(UserDetail user);
    }

    protected interface Interactor {

        void retrieveUser(String userUrl);
    }
}
