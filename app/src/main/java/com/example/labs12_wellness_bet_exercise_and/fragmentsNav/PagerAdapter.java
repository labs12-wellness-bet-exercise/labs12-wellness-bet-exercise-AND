package com.example.labs12_wellness_bet_exercise_and.fragmentsNav;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public PagerAdapter(FragmentManager fm, int NumberOfTabs)
    {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        switch(position)
        {

            case 0:
                RankingsFragment rankingsFragment = new RankingsFragment();
                return rankingsFragment;
            case 1:
                StatsFragment statsFragment = new StatsFragment();
                return  statsFragment;
            case 2:
                InfoFragment infoFragment = new InfoFragment();
                return  infoFragment;
            case 3:
                PendingFragment pendingFragment = new PendingFragment();
                return  pendingFragment;
            case 4:
                ApprovedFragment approvedFragment = new ApprovedFragment();
                return  approvedFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
