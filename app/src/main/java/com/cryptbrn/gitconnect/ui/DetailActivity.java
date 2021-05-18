package com.cryptbrn.gitconnect.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.bumptech.glide.Glide;
import com.cryptbrn.gitconnect.R;
import com.cryptbrn.gitconnect.adapter.UsersAdapter;
import com.cryptbrn.gitconnect.adapter.ViewPagerAdapter;
import com.cryptbrn.gitconnect.api.Client;
import com.cryptbrn.gitconnect.model.Detail;
import com.cryptbrn.gitconnect.model.User;
import com.google.android.material.tabs.TabLayout;
import org.jetbrains.annotations.NotNull;
import org.parceler.Parcels;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    Detail detaildata;
    User userdata;
    TextView repositorytv ,nametv, usernametv, locationtv, companytv;
    ImageView avatarciv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle getbundle = getIntent().getBundleExtra(UsersAdapter.DATA_EXTRA);
        assert getbundle != null;
        userdata = Parcels.unwrap(getbundle.getParcelable(UsersAdapter.DATA_USER));

        avatarciv = findViewById(R.id.avatar_detail_civ);
        usernametv = findViewById(R.id.username_detail_tv);
        nametv = findViewById(R.id.name_detail_tv);
        repositorytv = findViewById(R.id.repository_detail_tv);
        locationtv = findViewById(R.id.location_detail_tv);
        companytv = findViewById(R.id.company_detail_tv);

        final ProgressDialog progressbar = new ProgressDialog(DetailActivity.this);
        progressbar.setMessage(getString(R.string.progress));
        progressbar.show();

        Glide.with(DetailActivity.this)
                .load(userdata.getAvatarUrl())
                .into(avatarciv);
        usernametv.setText(userdata.getLogin());

        Call<Detail> requests = Client.getService().getDetailUser(userdata.getLogin());
        requests.enqueue(new Callback<Detail>() {
            @Override
            public void onResponse(@NotNull Call<Detail> call, @NotNull Response<Detail> responses) {
                detaildata = responses.body();

                assert detaildata != null;
                nametv.setText(detaildata.getName());
                locationtv.setText(detaildata.getLocation());
                repositorytv.setText(detaildata.getPublicRepos());
                companytv.setText(detaildata.getCompany());
                progressbar.dismiss();
            }

            @Override
            public void onFailure(@NotNull Call<Detail> call, @NotNull Throwable t) {

            }
        });

        //Tablayout dan ViewPager
        ViewPagerAdapter adapter = new ViewPagerAdapter(this, getSupportFragmentManager());
        ViewPager vp = findViewById(R.id.view_pager);
        vp.setAdapter(adapter);
        TabLayout tl = findViewById(R.id.tab_detail);
        tl.setupWithViewPager(vp);

    }
}
