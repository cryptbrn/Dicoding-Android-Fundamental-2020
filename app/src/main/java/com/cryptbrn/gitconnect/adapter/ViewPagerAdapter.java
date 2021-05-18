package com.cryptbrn.gitconnect.adapter;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.cryptbrn.gitconnect.R;
import com.cryptbrn.gitconnect.ui.fragment.FollowersFragment;
import com.cryptbrn.gitconnect.ui.fragment.FollowingFragment;


public class ViewPagerAdapter extends FragmentPagerAdapter {
    private final Context Context;

    public ViewPagerAdapter(Context mcontext, FragmentManager fm){
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        Context = mcontext;
    }

    @StringRes
    private final int[] TAB_TITLES = new int[]{
            R.string.title_follower,
            R.string.title_following
    };

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragmenttab = null;
        switch (position){
            case 0:
                fragmenttab = new FollowersFragment();
                break;
            case 1:
                fragmenttab = new FollowingFragment();
                break;
        }
        assert fragmenttab != null;
        return fragmenttab;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position){
        return Context.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return 2;
    }
}
