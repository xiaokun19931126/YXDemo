package com.xiaokun.xiusou.demo6.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.xiaokun.xiusou.demo6.Application.MyApplication;
import com.xiaokun.xiusou.demo6.Base.BaseActivity;
import com.xiaokun.xiusou.demo6.CustomView.RoundIndicatorView;
import com.xiaokun.xiusou.demo6.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/30 0030.
 */

public class CustomViewActivity extends BaseActivity
{
    @Bind(R.id.my_view)
    RoundIndicatorView roundIndicatorView;
    @Bind(R.id.edit)
    EditText editText;
    @Bind(R.id.btn)
    Button button;
    @Bind(R.id.activity_main)
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int a = Integer.valueOf(editText.getText().toString());
                roundIndicatorView.setCurrentNumAnim(a);
            }
        });
    }

    @Override
    public int getLayout()
    {
        return R.layout.activity_custom;
    }

    private void reCreate()
    {
        MyApplication.toastUtils.showToast("hah");
        //        setContentView(R.layout.activity_custom);
    }

}
