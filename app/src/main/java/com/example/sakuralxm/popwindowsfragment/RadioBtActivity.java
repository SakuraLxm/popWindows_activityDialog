package com.example.sakuralxm.popwindowsfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioGroup;

import com.gavin.demo_indicator.ViewPagerIndicator;

public class RadioBtActivity extends AppCompatActivity {
    private RadioGroup tab_menu;
    Fragment rankFragemnt; //排行
    Fragment upFragment; //晋级

    private ViewPagerIndicator indicator;
    private Window window;
    private WindowManager.LayoutParams layoutParams;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_bt);
        window = getWindow();
        layoutParams = window.getAttributes();
        //设置窗口的大小及透明度
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.height =800;
        layoutParams.alpha = 0.5f;
        window.setAttributes(layoutParams);

        setSelect(0);
        initView();

    }

    private void initView() {
        tab_menu= (RadioGroup) findViewById(R.id.tab_menu);
        tab_menu.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.first_page:
                setSelect(0);
                break;
            case R.id.first_user:
                setSelect(1);
                break;
            default:
                break;


        }
            }
        });

    }


    private void hideFragment(FragmentTransaction transaction) {
        if (rankFragemnt != null) {
            transaction.hide(rankFragemnt);
        }
        if (upFragment != null) {
            transaction.hide(upFragment);
        }


    }

    private void setSelect(int i) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        hideFragment(transaction);//先隐藏所有界面
        switch (i) {
            case 0:
                if (rankFragemnt == null) {
                    rankFragemnt = new RankFragment();
                    transaction.add(R.id.main_content, rankFragemnt);
                } else {
                    transaction.show(rankFragemnt);
                }
                break;
            case 1:
                if (upFragment == null) {
                    upFragment = new UpFragment();
                    transaction.add(R.id.main_content, upFragment);
                } else {
                    transaction.show(upFragment);
                }
                break;
            default:
                break;
        }
        transaction.commit();
    }
}
