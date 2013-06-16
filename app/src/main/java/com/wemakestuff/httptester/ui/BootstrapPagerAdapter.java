

package com.wemakestuff.httptester.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.wemakestuff.httptester.R;

/**
 * Pager adapter
 */
public class BootstrapPagerAdapter extends FragmentPagerAdapter {

    private final Resources resources;

    /**
     * Create pager adapter
     *
     * @param resources
     * @param fragmentManager
     */
    public BootstrapPagerAdapter(Resources resources, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.resources = resources;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        switch (position) {
        case 0:
            TestFragment testFragment = new TestFragment();
            testFragment.setArguments(bundle);
            return testFragment;
        case 1:
            TestHistoryListFragment testHistoryListFragment = new TestHistoryListFragment();
            testHistoryListFragment.setArguments(bundle);
            return testHistoryListFragment;
        default:
            return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
        case 0:
            return resources.getString(R.string.app_name);
        case 1:
            return resources.getString(R.string.output);
        default:
            return null;
        }
    }
}
