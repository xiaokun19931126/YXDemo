package com.xiaokun.xiusou.demo6.Fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.czy1121.view.RoundButton;
import com.xiaokun.xiusou.demo6.R;
import com.xiaokun.xiusou.demo6.Utils.ACache;
import com.yuyh.library.AppUtils;
import com.yuyh.library.utils.DimenUtils;
import com.yuyh.library.utils.toast.ToastUtils;
import com.yuyh.library.view.text.EmailAutoCompleteTextView;
import com.yuyh.library.view.text.PasswordEditText;

/**
 * Created by Administrator on 2016/11/18 0018.
 */

public class LoginFragment extends LazyFragment
{
    private static final String LOG_TAG = "LoginFragment";

    ACache aCache;
    private ToastUtils toastUtils;
    private PasswordEditText editText;
    private EmailAutoCompleteTextView username;
    private RoundButton roundButton;
    private View v;

    public static LoginFragment newInstance(Bundle args)
    {
        LoginFragment fragment = new LoginFragment();
        //        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState)
    {
        super.onCreateView(inflater, container, savedInstanceState);
        return v;
    }

    @Override
    protected void initView(LayoutInflater inflater, ViewGroup container)
    {
        toastUtils = new ToastUtils();
        aCache = ACache.get(AppUtils.getAppContext());
        v = inflater.from(AppUtils.getAppContext()).inflate(R.layout.fragment_login,
                container, false);
        editText = (PasswordEditText) v.findViewById(R.id.passEdit);
        username = (EmailAutoCompleteTextView) v.findViewById(R.id.username);
        roundButton = (RoundButton) v.findViewById(R.id.btn_register);
    }

    public void getData()
    {
        final String s = aCache.getAsString("password");
        final String s1 = aCache.getAsString("username");
        if (TextUtils.isEmpty(s))
        {
            toastUtils.getSingleToast("你还未设置密码，请先在注册页面设置密码", 0).show();
        }
        roundButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ViewWrapper viewWrapper = new ViewWrapper(roundButton);
                ObjectAnimator width = ObjectAnimator.ofInt(viewWrapper, "width", DimenUtils.dpToPxInt(300), DimenUtils.dpToPxInt(50));
                ObjectAnimator cornerRadius = ObjectAnimator.ofInt(viewWrapper, "cornerRadius", DimenUtils.dpToPxInt(10), DimenUtils.dpToPxInt(50));
                width.setRepeatMode(ValueAnimator.RESTART);
                cornerRadius.setRepeatMode(ValueAnimator.RESTART);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(cornerRadius).with(width);
                animatorSet.setDuration(500);
                animatorSet.start();
                animatorSet.addListener(new AnimatorListenerAdapter()
                {
                    @Override
                    public void onAnimationEnd(Animator animation)
                    {
                    }
                });
                String s = aCache.getAsString("password");
                String s1 = aCache.getAsString("username");
                String e = editText.getText().toString();
                String e1 = username.getText().toString();
                if (TextUtils.isEmpty(e) || TextUtils.isEmpty(e1))
                {
                    toastUtils.getSingleToast("用户名和密码不能为空", 0).show();
                } else
                {
                    if (TextUtils.isEmpty(s))
                    {
                        toastUtils.getSingleToast("你还未注册，请先注册", 0).show();
                    } else
                    {
                        if (e.equals(s) && e1.equals(s1))
                        {

                            toastUtils.getSingleToast("登录成功", 0).show();

                        } else
                        {
                            editText.setText("");
                            toastUtils.getSingleToast("用户名或密码错误", 0).show();
                        }
                    }
                }
            }
        });

    }

    private static class ViewWrapper
    {
        private View mTargetView;

        public ViewWrapper(View target)
        {
            mTargetView = target;
        }

        public int getWidth()
        {
            return mTargetView.getLayoutParams().width;
        }

        public void setWidth(int width)
        {
            mTargetView.getLayoutParams().width = width;
            mTargetView.requestLayout();
        }

        @RequiresApi(api = Build.VERSION_CODES.N)
        public int getCornerRadius()
        {
            return (int) ((GradientDrawable) mTargetView.getBackground()).getCornerRadius();
        }

        public void setCornerRadius(int cornerRadius)
        {
            ((GradientDrawable) mTargetView.getBackground()).setCornerRadius(cornerRadius);
        }
    }

}
