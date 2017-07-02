package com.xiaokun.xiusou.demo6.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.allen.library.SuperTextView;
import com.xiaokun.xiusou.demo6.Base.BaseActivity;
import com.xiaokun.xiusou.demo6.R;
import com.xiaokun.xiusou.demo6.Utils.DutyDayTool;

import butterknife.Bind;

/**
 * Created by Administrator on 2016/10/31 0031.
 */

public class DutyDayActivity extends BaseActivity
{
    @Bind(R.id.super_tv)
    SuperTextView superTextView;
    @Bind(R.id.super_tv1)
    SuperTextView superTextView1;
    @Bind(R.id.super_tv2)
    SuperTextView superTextView2;
    @Bind(R.id.super_tv3)
    SuperTextView superTextView3;
    @Bind(R.id.super_tv4)
    SuperTextView superTextView4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //        superTextView.setRightString();
        String weekDay = DutyDayTool.getWeekDay();
        String week = DutyDayTool.getWeek();
        superTextView4.setRightString(weekDay);
        superTextView3.setRightString(DutyDayTool.getDate("yyyy-MM-dd") + "    " + "星期" +
                week);
        if (weekDay.equals("本周双休"))
        {
            if (week.equals("六"))
            {
                superTextView1.setRightString("今天休息，哦耶");
                superTextView2.setRightString("明天休息，哦耶");
            } else if (week.equals("天"))
            {
                superTextView1.setRightString("今天休息，哦耶");
                superTextView2.setRightString(DutyDayTool.getNextDuty());
            } else if (week.equals("五"))
            {
                superTextView1.setRightString(DutyDayTool.getDuty());
                superTextView2.setRightString("明天休息，哦耶");
            } else
            {
                superTextView1.setRightString(DutyDayTool.getDuty());
                superTextView2.setRightString(DutyDayTool.getNextDuty());
            }
        } else if (weekDay.equals("本周单休"))
        {
            if (week.equals("天"))
            {
                superTextView1.setRightString("今天休息，哦耶");
                superTextView2.setRightString(DutyDayTool.getNextDuty());
            } else if (week.equals("六"))
            {
                superTextView1.setRightString(DutyDayTool.getDuty());
                superTextView2.setRightString("明天休息，哦耶");
            } else
            {
                superTextView1.setRightString(DutyDayTool.getDuty());
                superTextView2.setRightString(DutyDayTool.getNextDuty());
            }
        }

    }

    @Override
    public int getLayout()
    {
        return R.layout.activity_duty_day;
    }
}
