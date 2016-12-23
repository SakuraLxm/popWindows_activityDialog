package com.example.sakuralxm.popwindowsfragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends FragmentActivity  {
    private ViewPager mViewPager;
    private ArrayList<Fragment> arrayList = new ArrayList<>();
    private List<String> strings = new ArrayList<>();
    private Window window;
    private WindowManager.LayoutParams layoutParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_rank_lxm);
        window = getWindow();
        layoutParams = window.getAttributes();
        //设置窗口的大小及透明度
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        layoutParams.alpha = 0.5f;
        window.setAttributes(layoutParams);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_menu);
        mViewPager = (ViewPager) findViewById(R.id.iv_viewPager);
        mViewPager.setScrollContainer(false);
        FragmentPromotion fragmentPromotion = new FragmentPromotion();
        FragmentRank fragmentRank = new FragmentRank();
//        arrayList.add(fragmentPromotion);
//        arrayList.add(fragmentRank);
        arrayList.add( new RankFragment());
        arrayList.add( new UpFragment());
//        arrayList.add (new FragmentPromotion());

        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), arrayList);
        mViewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(mViewPager);


    }

}
