package com.xiaokun.xiusou.demo6.Activity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import com.xiaokun.xiusou.demo6.Base.BaseActivity;
import com.xiaokun.xiusou.demo6.R;

import butterknife.Bind;

/**
 * Created by Administrator on 2016/12/12 0012.
 */

public class Intent2Activity extends BaseActivity
{
    private static final String TAG = "Intent2Activity";
    @Bind(R.id.web_view)
    WebView webView;
    @Bind(R.id.btn2)
    Button button;
    @Bind(R.id.btn3)
    Button button3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        webView.loadUrl("file:///android_asset/intentToActivity.html");
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //                Intent intent = getApplicationContext().getPackageManager()
                //                        .getLaunchIntentForPackage("com.xiaokun.xiusou.intent2demo");
                Intent intent = new Intent();
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent
                        .FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                //                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );//这种方式会多一个页面重复出现
                //                Intent intent = new Intent(Intent.ACTION_MAIN);
                //                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                // 这里的packname就是从上面得到的目标apk的包名
                // Intent resolveIntent = packManager.getLaunchIntentForPackage(packname);
                ComponentName cn = new ComponentName("com.xiaokun.xiusou.intent2demo",
                        "com.xiaokun.xiusou.intent2demo.Intent2Activity");
                intent.setComponent(cn);
                //                intent.putExtra("article", "1");
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent();
                i.setPackage("com.xiusou.activity");
                i.setAction("android.intent.action.VIEW");
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent
                        .FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                i.addCategory("android.intent.category.DEFAULT");
                i.addCategory("android.intent.category.BROWSABLE");
                i.setData(Uri.parse("xs://jaq.xiusou.com"));
                i.putExtra("article", "1");
                Log.d(TAG, i.toURI());
                startActivity(i);
            }
        });
    }

    @Override
    public int getLayout()
    {
        return R.layout.activity_intent;
    }
}
