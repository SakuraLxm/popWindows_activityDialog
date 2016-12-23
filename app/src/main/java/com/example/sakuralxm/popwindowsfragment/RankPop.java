package com.example.sakuralxm.popwindowsfragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import com.facebook.drawee.view.SimpleDraweeView;
import com.gavin.demo_indicator.ViewPagerIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by sakura on 2016/9/29.
 * <p>
 * 排名的PopWindows
 */
public class RankPop {
    private Context context;
    private ViewGroup viewRankPopupView;
    private PopupWindow popupWindow;
    private LayoutInflater inflater;
    private SimpleDraweeView idPalyHeadSdv;
    private ViewPager mViewPager;
    private ArrayList<Fragment> arrayList = new ArrayList<>();
    private FragmentManager fm;
    private List<String> strings = new ArrayList<>();
    private ViewPagerIndicator indicator;
    private RadioGroup activity_group_radioGroup;
    private FragmentTransaction mTransaction = null;


    public RankPop(Context context, FragmentManager fm) {
        this.context = context;
        this.fm = fm;
        strings.add("本场排名");
        strings.add("晋级学员");

    }

    /**
     * @return popWindow实例化对象
     * <p>
     * 这里是初始化PopupWindow 绑定布局 绑定Fragment
     */
    public PopupWindow init() {
        if (viewRankPopupView == null) {
////            inflater= LayoutInflater.from(context);
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            viewRankPopupView = (ViewGroup) inflater.inflate(R.layout.pop_rank_lxm, null);
//            activity_group_radioGroup = (RadioGroup) viewRankPopupView.findViewById(R.id.activity_group_radioGroup);


//            int size = viewRankPopupView.getChildCount();
//            for (int i = 0; i < size; i++) {
//                View view = viewRankPopupView.getChildAt(i);
//                if (view instanceof ViewPagerIndicator){
//                    indicator = (ViewPagerIndicator)view;
//                }else if (view instanceof ViewPager){
//                    mViewPager=(ViewPager)view;
//                }else if (view instanceof SimpleDraweeView)
//                {
//                    idPalyHeadSdv= (SimpleDraweeView) view;
//                }
//                Log.i("---",String.format(Locale.CHINA,"%d,%s",i,view.getClass().getSimpleName()));
//            }
//            ViewPagerIndicator indicator = (ViewPagerIndicator) viewRankPopupView.findViewById(R.id.indicator);
//////            tabLayout = (TabLayout) viewRankPopupView.findViewById(R.id.rank_tab);
//            mViewPager= (ViewPager) viewRankPopupView.findViewById(R.id.iv_viewPager);


//            TextView textView = (TextView) viewRankPopupView.findViewById(R.id.text);
//            TextView textView2 = (TextView) viewRankPopupView.findViewById(R.id.text2);

            mTransaction = fm.beginTransaction();
            FragmentPromotion fragmentPromotion = new FragmentPromotion();
            FragmentRank fragmentRank = new FragmentRank();
            arrayList.add(fragmentPromotion);

            mTransaction.add(R.id.fitCenter,fragmentPromotion);
            mTransaction.add(R.id.fitCenter,fragmentRank);
            mTransaction.commit();

            arrayList.add(fragmentRank);
//            FragmentAdapter adapter = new FragmentAdapter(fm, arrayList);
//            mViewPager.setAdapter(adapter);
//////            tabLayout.setupWithViewPager(mViewPager);
//            indicator.setViewPager(mViewPager);
            activity_group_radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {

                    for (int i = 0; i < arrayList.size(); i++) {
                        RadioButton radioButton = (RadioButton) group.getChildAt(i);
                        if (radioButton.isChecked()) {
                            Fragment fragment = arrayList.get(i);
                            if (fragment != null) {
                                mTransaction.show(fragment);
                            }
                        } else {
                            Fragment fragment = arrayList.get(i);
                            if (fragment != null) {
                                mTransaction.hide(fragment); //隐藏
                                fragment.setUserVisibleHint(false);
                            }

                        }
                    }
                    mTransaction.commit();
                }
            });
            // 设置选中和非选中文字的大小
//            indicator.setItemTextSize(14, 14);
//            // 设置选中和非选中文字的颜色
//            indicator.setItemTextColor(Color.BLACK, 0xffED0148);
//            // 一屏显示多少项
////            int size = 2;
//            indicator.setItemCount(2);
//            indicator.setTabItemTitles(strings);
//            indicator.setCurrentItem(0);
// TODO 到这里应该
        }
        /**
         * 点击外面消失
         */
        if (popupWindow == null) {
            popupWindow = new PopupWindow(viewRankPopupView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            popupWindow.setFocusable(true);
            popupWindow.setOutsideTouchable(true);
            popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        return popupWindow;
    }

    /**
     * @param view            点击的控件弹出window
     * @param dismissListener 设置消失之前的回调
     */
    public void show(View view, PopupWindow.OnDismissListener dismissListener) {
        init().showAtLocation(view, Gravity.CENTER, 0, 0);
        popupWindow.setOnDismissListener(dismissListener);

    }

}
