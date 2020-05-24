package com.linsc.darkmodedemo;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView tvTitle;
    private Button btnLight, btnDark, btnFollow;
    private ImageView ivPics;
    private RelativeLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTitle = findViewById(R.id.tv_title);
        btnLight = findViewById(R.id.btn_light);
        btnDark = findViewById(R.id.btn_dark);
        btnFollow = findViewById(R.id.btn_follow);
        container = findViewById(R.id.container);
        ivPics = findViewById(R.id.iv_pics);
        btnLight.setOnClickListener(this);
        btnDark.setOnClickListener(this);
        btnFollow.setOnClickListener(this);
        setText();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.w(TAG, "onConfigurationChanged");
        onLightModeChange();
    }


    private void setText() {
        int mode = ModeManager.getInstance.getMode();
        switch (mode) {
            case ModeManager.MODE_LIGHT:
                tvTitle.setText("当前模式：浅色模式");
                break;
            case ModeManager.MODE_DARK:
                tvTitle.setText("当前模式：深色模式");
                break;
            case ModeManager.MODE_FOLLOW:
                tvTitle.setText("当前模式：跟随系统模式");
                break;
        }
    }

    private void onLightModeChange() {
        refreshUI();
    }

    /**
     * 防止recreate导致的黑屏，页面元素不多的情况下可以使用刷新UI的方式
     */
    private void refreshUI() {
        tvTitle.setTextColor(ResUtils.getColor(this, R.color.colorTitle));
        btnLight.setTextColor(ResUtils.getColor(this, R.color.colorTitle));
        btnDark.setTextColor(ResUtils.getColor(this, R.color.colorTitle));
        btnFollow.setTextColor(ResUtils.getColor(this, R.color.colorTitle));
        container.setBackgroundColor(ResUtils.getColor(this, R.color.colorBg));
        ivPics.setImageResource(R.mipmap.pics_address);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_light:
                ModeManager.getInstance.setMode(ModeManager.MODE_LIGHT);
                break;
            case R.id.btn_dark:
                ModeManager.getInstance.setMode(ModeManager.MODE_DARK);
                break;
            case R.id.btn_follow:
                ModeManager.getInstance.setMode(ModeManager.MODE_FOLLOW);
                break;
        }
        setText();
    }
}
