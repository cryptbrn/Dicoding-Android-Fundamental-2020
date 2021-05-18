package com.cryptbrn.connected.ui;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.cryptbrn.connected.adapter.Adapter;
import com.cryptbrn.connected.R;
import com.cryptbrn.connected.model.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listusers;
    Adapter useradpt;
    TypedArray avatar;
    String[] name, username, repository, followers, following, company, location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        useradpt = new Adapter(this);
        listusers = findViewById(R.id.list_user);
        listusers.setAdapter(useradpt);
        avatar = getResources().obtainTypedArray(R.array.avatar);
        name = getResources().getStringArray(R.array.name);
        username = getResources().getStringArray(R.array.username);
        repository = getResources().getStringArray(R.array.repository);
        followers = getResources().getStringArray(R.array.followers);
        following = getResources().getStringArray(R.array.following);
        company = getResources().getStringArray(R.array.company);
        location = getResources().getStringArray(R.array.location);

        final ArrayList<User> listuser = new ArrayList<>();

        for (int x = 0; x < name.length; x++) {
            User user = new User();
            user.setAvatar(avatar.getResourceId(x, -1));
            user.setName(name[x]);
            user.setUsername(username[x]);
            user.setLocation(location[x]);
            user.setCompany(company[x]);
            user.setRepository(repository[x]);
            user.setFollowing(following[x]);
            user.setFollowers(followers[x]);
            listuser.add(user);
        }
        useradpt.setUser(listuser);

        listusers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("user", listuser.get(i));
                startActivity(intent);
            }
        });
    }
}
