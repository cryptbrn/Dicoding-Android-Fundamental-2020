package com.cryptbrn.connected.ui;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.cryptbrn.connected.R;
import com.cryptbrn.connected.model.User;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView avatar = findViewById(R.id.aa_thumbnail);
        TextView username = findViewById(R.id.username_dtl);
        TextView location = findViewById(R.id.location_dtl);
        TextView company = findViewById(R.id.company_dtl);
        TextView repository = findViewById(R.id.repository_dtl);
        TextView following = findViewById(R.id.following_dtl);
        TextView follower = findViewById(R.id.follower_dtl);

        User user = getIntent().getParcelableExtra("user");

        int avatars = user.getAvatar();
        avatar.setImageResource(avatars);

        String usernames = user.getUsername();
        username.setText(usernames);

        String locations = user.getLocation();
        location.setText(locations);

        String companys = user.getCompany();
        company.setText(companys);

        String repositorys = user.getRepository();
        repository.setText(repositorys);

        String followings = user.getFollowing();
        following.setText(followings);

        String followers = user.getFollowers();
        follower.setText(followers);

        String names = user.getName();
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);
        collapsingToolbarLayout.setTitle(names);
    }
}
