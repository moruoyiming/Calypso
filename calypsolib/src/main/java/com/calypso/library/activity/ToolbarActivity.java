package com.calypso.library.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import com.calypso.library.activity.base.BaseActivity;


/**
 * Created by Jian on 2016/12/16.
 * Email: 798774875@qq.com
 * Github: https://github.com/moruoyiming
 */
public abstract class ToolbarActivity extends BaseActivity {

    protected Toolbar mToolbar;
    protected AppBarLayout mAppBarLayout;
    protected FragmentManager mFragmentManager;
    protected boolean mIsHidden = false;

    @Override
    protected void init(Bundle savedInstanceState) {
        mFragmentManager = getSupportFragmentManager();
    }

    @Override
    protected void setUpView() {
        mAppBarLayout = $(R.id.appbar_layout);
        mToolbar = $(R.id.toolbar);
        mToolbar.setTitle(getToolbarTitle());

        setUpToolBar();

    }

    private void setUpToolBar() {
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        getSupportActionBar().setHomeButtonEnabled(true);//决定左上角的图标是否可以点击
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    protected abstract String getToolbarTitle();

    @Override
    protected void setUpData() {
        mFragmentManager.beginTransaction().replace(R.id.fl_content, setFragment()).commit();
    }

    protected abstract Fragment setFragment();


    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_content;
    }

    protected void setAppBarAlpha(float alpha) {
        mAppBarLayout.setAlpha(alpha);
    }


    public void hideOrShowToolbar() {
        mAppBarLayout.animate()
                .translationY(mIsHidden ? 0 : -mAppBarLayout.getHeight())
                .setInterpolator(new DecelerateInterpolator(2))
                .start();

        mIsHidden = !mIsHidden;
    }

    protected void setAppbarVisibility(int visibility) {
        mAppBarLayout.setVisibility(visibility);
    }
}
