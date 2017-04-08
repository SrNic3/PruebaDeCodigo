package com.arstotzka.pruebadecodigo.Views.UserList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.arstotzka.pruebadecodigo.Model.User;
import com.arstotzka.pruebadecodigo.R;
import com.arstotzka.pruebadecodigo.Utils.ADB;
import com.arstotzka.pruebadecodigo.Utils.RecyclerViewDelegate;
import com.arstotzka.pruebadecodigo.Views.UserDetail.UserDetailActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements UserListContract.View , RecyclerViewDelegate{

    @BindView(R.id.rv_users)
    RecyclerView rvUsers;

    private UserListContract.Presenter presenter;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        presenter = new UserListPresenter(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvUsers.setLayoutManager(layoutManager);
        adapter = new RecyclerViewAdapter(this);
        rvUsers.setAdapter(adapter);

        presenter.getUsers();
    }

    @Override
    public void onGetUsers(final List<User> users) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter.setUsers(users);
            }
        });
    }

    @Override
    public void onClick(View v) {
        User user =  adapter.getUser(rvUsers.getChildAdapterPosition(v));
        ADB.setObject(user);

        Intent intent =  new Intent(this, UserDetailActivity.class);
        startActivity(intent);
    }

    @Override
    public void loadMore() {
        presenter.getUsers();
    }
}
