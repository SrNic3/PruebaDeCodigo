package com.arstotzka.pruebadecodigo.Views.UserList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arstotzka.pruebadecodigo.App;
import com.arstotzka.pruebadecodigo.Model.User;
import com.arstotzka.pruebadecodigo.R;
import com.arstotzka.pruebadecodigo.Utils.RecyclerViewDelegate;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Dani on 08/04/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.UserViewHolder> implements View.OnClickListener {

    private List<User> users;
    private RecyclerViewDelegate delegate;

    @Inject
    Context context;

    public RecyclerViewAdapter(RecyclerViewDelegate delegate) {
        App.getmComponent().inject(this);
        this.delegate = delegate;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_viewholder, parent, false);
        view.setOnClickListener(this);
        UserViewHolder viewHolder = new UserViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        Picasso.with(context).load(users.get(position).getAvatarUrl()).into(holder.avatar);
        holder.userName.setText(users.get(position).getLogin());
        holder.url.setText(users.get(position).getHtmlUrl());
        if (position >= users.size() - 1)
            delegate.loadMore();
    }

    @Override
    public int getItemCount() {
        if (users != null)
            return users.size();
        return 0;
    }

    @Override
    public void onClick(View v) {
        delegate.onClick(v);
    }

    public void setUsers(List<User> users) {
        if (this.users == null)
            this.users = users;
        else
            this.users.addAll(users);
        notifyDataSetChanged();
    }

    public User getUser(int pos) {
        return  users.get(pos);
    }


    public static class UserViewHolder extends RecyclerView.ViewHolder {

        ImageView avatar;
        TextView userName;
        TextView url;

        public UserViewHolder(View itemView) {
            super(itemView);

            avatar = (ImageView) itemView.findViewById(R.id.ivAvatar);
            userName = (TextView) itemView.findViewById(R.id.tvName);
            url = (TextView) itemView.findViewById(R.id.tvUrl);
        }
    }
}
