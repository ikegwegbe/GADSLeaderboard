package com.example.gadsleaderboard.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.gadsleaderboard.UiComponents.LearnerHoursFragment;
import com.example.gadsleaderboard.UiComponents.SkillIQFragment;

public class PageViewerAdapter extends FragmentPagerAdapter {
    int behaviour;
    public PageViewerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.behaviour = behavior;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new LearnerHoursFragment();
            case 1:
                return new SkillIQFragment();
            default:
                return null;

        }

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        switch (position){
            case 0:
                return "Learning leaders";
            case 1:
                return "skill iq leaders";
            default:
                return "";

        }
    }

    @Override
    public int getCount() {
        return behaviour;
    }
}
