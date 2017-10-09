package com.example.ben.fitordie.Login.SwipeViews;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

/**
 * Created by Ben on 10/7/2017.
 */

/**
 * Represents each page as a fragment that is kept persistently in memory as long as the user
 * can navigate to the different pages. Used as an adapter to
 */
public class LoginFragmentPagerAdapter extends FragmentPagerAdapter {


    private final static int NUM_ITEMS = 4; // number of fragments in our FragmentPagerAdapter

    public LoginFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * This is only called the first time the fragments are loaded. With FragmentPagerAdapters, the
     * fragments stay in memory and don't get deleted. Should be lightweight pages or not very many.
     * @param position Position of the page that is needed to be loaded. The Page that it is currently
     * on will be called and then the next page as well. (Unless it's the last page).
     * @return Fragment instance corresponding to the position
     */
    @Override
    public Fragment getItem(int position) {
        Log.d("TAG", "getItem: " + position);
        switch(position) {
            case 0: return PageOneFragment.newInstance();
            case 1: return PageTwoFragment.newInstance();
            case 2: return PageThreeFragment.newInstance();
            case 3: return PageFourFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }


}
