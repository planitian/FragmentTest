package com.admin.plani.languageswitch;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Button change;
    private String last;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Test test = new Test();
        test.getName();
        change = findViewById(R.id.button);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLanguage("z");
                //第一种刷新 ，创建一个新的activity
//                freshView();
                //第二种刷新   原activity 重新调用 onCreate

                change.setText("dianji");
                getSupportActionBar().setTitle("变化");
                last = "模拟请求数据";
                recreate();
            }
        });
        if (savedInstanceState == null) {
            BlankFragment fragment = (BlankFragment) getSupportFragmentManager().findFragmentById(R.id.content);
            if (fragment == null) {
                fragment = BlankFragment.newInstance("s", "s");
                Zprint.log(this, "fragment 为空");
                getSupportFragmentManager().beginTransaction().add(R.id.content, fragment).commit();
            } else {
                Zprint.log(this, "fragment hashcode", fragment.hashCode());
            }
        } else {
            last = savedInstanceState.getString("last");
            change.setText(last);

        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("last", last);
        super.onSaveInstanceState(outState);
        Zprint.log(this, "保存的内容", outState.toString());
    }

    //设置配置语言
    protected void showLanguage(String language) {
        //设置应用语言类型
        Resources resources = getResources();
        Configuration config = resources.getConfiguration();
        DisplayMetrics dm = resources.getDisplayMetrics();
        if (language.equals("zh")) {
            config.locale = Locale.SIMPLIFIED_CHINESE;
        } else {
            config.locale = Locale.ENGLISH;
        }
        resources.updateConfiguration(config, dm);
    }

    //重新启动activity
    private void freshView() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

    }


}
