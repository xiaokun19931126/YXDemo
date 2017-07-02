package com.xiaokun.xiusou.demo6.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebView;

import com.xiaokun.xiusou.demo6.Base.BaseActivity;

/**
 * Created by Administrator on 2016/12/14 0014.
 */

public class HtmlActivity extends BaseActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView webView = new WebView(this);
        webView.loadUrl("file:///android_asset/HtmlDemo.html");
        setContentView(webView);
    }

    @Override
    public int getLayout()
    {
        return 0;
    }
}
