package com.arstotzka.pruebadecodigo.Views.UserDetail;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.arstotzka.pruebadecodigo.Model.UserDetail;
import com.arstotzka.pruebadecodigo.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserDetailActivity extends AppCompatActivity implements UserDetailContract.View {

    private UserDetailContract.Presenter presenter;

    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvCompany)
    TextView tvCompany;
    @BindView(R.id.tvEmail)
    TextView tvEmail;
    @BindView(R.id.tvLoc)
    TextView tvLoc;
    @BindView(R.id.ivAvatar)
    ImageView ivAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        presenter = new UserDetailPresenter(this);

        presenter.getUser();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onGetUser(final UserDetail user) {
        final Context context = this.getApplicationContext();
        if (user != null) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Picasso.with(context).load(user.getAvatarUrl()).into(ivAvatar);
                    tvName.setText(user.getName());
                    tvEmail.setText(user.getEmail());
                    tvCompany.setText(user.getCompany());
                    tvLoc.setText(user.getLocation());

                    getSupportActionBar().setTitle(user.getName());
                }
            });
        }
    }
}
