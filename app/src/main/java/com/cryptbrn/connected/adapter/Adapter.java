package com.cryptbrn.connected.adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cryptbrn.connected.R;
import com.cryptbrn.connected.model.User;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {
    private final Context context;
    private ArrayList<User> userslist;

    public Adapter(Context context) {
        this.context = context;
        userslist = new ArrayList<>();
    }

    public void setUser(ArrayList<User> userslist) {
        this.userslist = userslist;
    }

    @Override
    public int getCount() {
        return userslist.size();
    }

    @Override
    public Object getItem(int position) {
        return userslist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View view, ViewGroup parent) {

        view = LayoutInflater.from(context).inflate(R.layout.cardview, parent, false);

        ImageView avatar = view.findViewById(R.id.avatar_crd);
        TextView name = view.findViewById(R.id.name_crd);
        TextView username = view.findViewById(R.id.username_crd);
        TextView repository = view.findViewById(R.id.repository_crd);
        TextView followers = view.findViewById(R.id.follower_crd);
        TextView following = view.findViewById(R.id.following_crd);

        User user = (User) getItem(position);
        avatar.setImageResource(user.getAvatar());
        name.setText(user.getName());
        username.setText(user.getUsername());
        repository.setText(user.getRepository());
        followers.setText(user.getFollowers());
        following.setText(user.getFollowing());

        return view;
    }
}
