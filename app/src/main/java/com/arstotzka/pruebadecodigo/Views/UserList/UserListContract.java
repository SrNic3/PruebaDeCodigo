package com.arstotzka.pruebadecodigo.Views.UserList;

import com.arstotzka.pruebadecodigo.Model.User;

import java.util.List;

/**
 * Created by Dani on 08/04/2017.
 */

public class UserListContract {

    protected interface View {

        void onGetUsers(List<User> users);
    }

    protected interface Presenter {

        void getUsers();

        void onRetrievedUsers(List<User> users);
    }

    protected interface Interactor {

        void retrieveUsers(int lastId);
    }
}
