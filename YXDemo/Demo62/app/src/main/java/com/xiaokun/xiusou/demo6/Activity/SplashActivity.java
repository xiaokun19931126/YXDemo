package com.xiaokun.xiusou.demo6.Activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.xiaokun.xiusou.demo6.Base.BaseActivity;
import com.xiaokun.xiusou.demo6.R;

/**
 * Created by Administrator on 2016/12/6 0006.
 */

public class SplashActivity extends BaseActivity
{
    private int mDelayTime = 1500;
    private Runnable mGotoMainRunnable = new Runnable()
    {
        public void run()
        {
            Intent localIntent = new Intent(SplashActivity.this, FirstActivity.class);
            SplashActivity.this.startActivity(localIntent);
            SplashActivity.this.finish();
            //            SplashActivity.this.overridePendingTransition(0, 0);
        }
    };

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            findViewById(R.id.linear).setBackground(getDrawable(R.drawable.color_blue));
        }
    }

    @Override
    public int getLayout()
    {
        return R.layout.activity_splash;
    }

    protected void onPause()
    {
        super.onPause();
        getWindow().getDecorView().removeCallbacks(this.mGotoMainRunnable);
    }

    protected void onResume()
    {
        super.onResume();
        getWindow().getDecorView().postDelayed(this.mGotoMainRunnable, this.mDelayTime);
    }
}
