package com.example.sakuralxm.popwindowsfragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void _onClick(View view) {
 startActivity(new Intent(MainActivity.this,Main2Activity.class));

//        RankPop rankPop = new RankPop(getApplicationContext(),getSupportFragmentManager());
//        rankPop.init();
//        Log.i("--","点击了");
//        rankPop.show(view, new PopupWindow.OnDismissListener() {
//            @Override
//            public void onDismiss() {
//            }
//        });
    }
}
