package com.xiaokun.xiusou.demo6.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xiaokun.xiusou.demo6.Adapter.HomeAdapter1;
import com.xiaokun.xiusou.demo6.Application.MyApplication;
import com.xiaokun.xiusou.demo6.Base.BaseActivity;
import com.xiaokun.xiusou.demo6.R;

import butterknife.Bind;

/**
 * Created by Administrator on 2016/10/27 0027.
 */

public class FirstActivity extends BaseActivity
{

    @Bind(R.id.first_recyclerView)
    RecyclerView recyclerView;
    String[] strings = {"秀搜新闻", "Zaker新闻", "秀搜值日", "Zaker精选", "懒加载demo", "外卖云神算",
            "登录模块", "16和10互转", "引导帮助案例", "事件冲突案例", "清空缓存", "顶部悬浮案例",
            "自定义View之芝麻信用", "自定义View之转盘", "自定义View之时钟", "自定义View之搜索",
            "app间跳转案例", "html赏析", "下载app测试", "我的收藏", "高价下载", "测试热更新", "textviewDemo"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        final Intent intent = new Intent();
        //        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        final HomeAdapter1 adapter = new HomeAdapter1(strings);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new HomeAdapter1.onItemClickListener()
        {
            @Override
            public void onItemClick(int position)
            {
                switch (position)
                {
                    case 0:
                        intent.setClass(FirstActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent.setClass(FirstActivity.this, ZakerNewsListActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent.setClass(FirstActivity.this, DutyDayActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent.setClass(FirstActivity.this, FangZakerActivity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent.setClass(FirstActivity.this, ViewPagerActivity.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent.setClass(FirstActivity.this, WMActivity.class);
                        startActivity(intent);
                        break;
                    case 6:
                        intent.setClass(FirstActivity.this, PassWordActivity.class);
                        startActivity(intent);
                        break;
                    case 7:
                        intent.setClass(FirstActivity.this, sixteenToTenActivity.class);
                        startActivity(intent);
                        break;
                    case 8:
                        intent.setClass(FirstActivity.this, GuideHelperActivity.class);
                        startActivity(intent);
                        break;
                    case 9:
                        intent.setClass(FirstActivity.this, EventConflictActivity.class);
                        startActivity(intent);
                        break;
                    case 10:
                        MyApplication.aCache.clear();
                        MyApplication.toastUtils.showToast("缓存清除成功");
                        //                        intent.setClass(FirstActivity.this, EventConflictActivity.class);
                        //                        startActivity(intent);
                        break;
                    case 11:
                        intent.setClass(FirstActivity.this, TopFloatActivity.class);
                        //                        startActivity(intent);
                        break;
                    case 12:
                        intent.setClass(FirstActivity.this, CustomViewActivity.class);
                        startActivity(intent);
                        break;
                    case 13:
                        intent.setClass(FirstActivity.this, LuckPanActivity.class);
                        startActivity(intent);
                        break;
                    case 14:
                        intent.setClass(FirstActivity.this, SmartTimeActivity.class);
                        startActivity(intent);
                        break;
                    case 15:
                        intent.setClass(FirstActivity.this, SearchViewActivity.class);
                        startActivity(intent);
                        break;
                    case 16:
                        intent.setClass(FirstActivity.this, Intent2Activity.class);
                        startActivity(intent);
                        break;
                    case 17:
                        intent.setClass(FirstActivity.this, HtmlActivity.class);
                        startActivity(intent);
                        break;
                    case 18:
                        intent.setClass(FirstActivity.this, DownLoadActivity.class);
                        startActivity(intent);
                        break;
                    case 19:
                        intent.setClass(FirstActivity.this, MyCollectionActivity.class);
                        startActivity(intent);
                        break;
                    case 20:
                        intent.setClass(FirstActivity.this, DownTaskActivity.class);
                        startActivity(intent);
                        break;
                    case 21:
                        intent.setClass(FirstActivity.this, HotUpdateActivity.class);
                        startActivity(intent);
                        break;
                    case 22:
                        intent.setClass(FirstActivity.this, TextViewActivity.class);
                        startActivity(intent);
                        break;

                }
            }
        });
    }

    @Override
    public int getLayout()
    {
        return R.layout.activity_first;
    }
}
