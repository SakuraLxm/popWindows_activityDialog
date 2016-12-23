package com.example.sakuralxm.popwindowsfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sakuraLxm on 2016/12/21.
 */
public class FragmentAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragmentList = new ArrayList<Fragment>();

        public FragmentAdapter(FragmentManager fm, List<Fragment> mFragmentList) {
            super(fm);
            this.fragmentList = mFragmentList;


        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "本场排名";
                case 1:
                    return "晋级学员";
//                case 2:
//                    return "晋级学员";
//                case 3:
//                    return "晋级学员";
//                case 4:
//                    return "晋级学员";
            }
            return super.getPageTitle(position);
        }

        @Override
        public Fragment getItem(int i) {
            return fragmentList.get(i);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
}
