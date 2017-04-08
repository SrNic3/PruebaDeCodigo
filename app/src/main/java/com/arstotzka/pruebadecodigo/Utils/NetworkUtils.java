package com.arstotzka.pruebadecodigo.Utils;

import android.util.Log;

import com.arstotzka.pruebadecodigo.App;
import com.arstotzka.pruebadecodigo.Model.User;
import com.arstotzka.pruebadecodigo.Model.UserDetail;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.arstotzka.pruebadecodigo.Utils.Commons.USERS_ENDPOINT;

/**
 * Created by Dani on 08/04/2017.
 */

public class NetworkUtils {


    @Inject
    OkHttpClient okHttpClient;
    @Inject
    Gson gson;

    public NetworkUtils () {
        App.getmComponent().inject(this);
    }


    public void requestUserList(int lastUserId, final NetCallback<List<User>> netCallback) {

        Request request = new Request.Builder().url(USERS_ENDPOINT+"?since="+lastUserId).build();

        okHttpClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    Type listType = new TypeToken<List<User>>() {}.getType();
                    List<User> users = gson.fromJson(response.body().string(), listType);
                    netCallback.onSuccess(users);
                }
            }

            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("NETWORK ERROR", e.getLocalizedMessage());
                e.printStackTrace();
            }
        });
    }

    public void requestUser(String userUrl,final NetCallback<UserDetail> netCallback) {
        Request request = new Request.Builder().url(userUrl).build();

        okHttpClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    UserDetail user= gson.fromJson(response.body().string(), UserDetail.class);
                    netCallback.onSuccess(user);
                }
            }

            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("NETWORK ERROR", e.getLocalizedMessage());
                e.printStackTrace();
            }
        });
    }


}
