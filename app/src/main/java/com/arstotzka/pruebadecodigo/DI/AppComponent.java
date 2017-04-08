package com.arstotzka.pruebadecodigo.DI;

import com.arstotzka.pruebadecodigo.Utils.NetworkUtils;
import com.arstotzka.pruebadecodigo.Views.UserDetail.UserDetailInteractor;
import com.arstotzka.pruebadecodigo.Views.UserList.RecyclerViewAdapter;
import com.arstotzka.pruebadecodigo.Views.UserList.UserListInteractor;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Dani on 08/04/2017.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(RecyclerViewAdapter recyclerViewAdapter);

    void inject(NetworkUtils networkUtils);

    void inject(UserListInteractor userListInteractor);

    void inject(UserDetailInteractor userDetailInteractor);
}
