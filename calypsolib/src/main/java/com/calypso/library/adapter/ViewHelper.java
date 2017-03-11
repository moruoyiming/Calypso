package com.calypso.library.adapter;

import android.support.v4.view.ViewCompat;
import android.view.View;

/**
 * 项目名称：SigmaClassBoard
 * 类描述：
 * 创建人：jianruilin
 * 创建时间：12/26/2016 11:31 AM
 * 修改备注：
 */
public class ViewHelper {
    public static void clear(View v) {
        ViewCompat.setAlpha(v, 1);
        ViewCompat.setScaleY(v, 1);
        ViewCompat.setScaleX(v, 1);
        ViewCompat.setTranslationY(v, 0);
        ViewCompat.setTranslationX(v, 0);
        ViewCompat.setRotation(v, 0);
        ViewCompat.setRotationY(v, 0);
        ViewCompat.setRotationX(v, 0);
        v.setPivotY(v.getMeasuredHeight() / 2);
        ViewCompat.setPivotX(v, v.getMeasuredWidth() / 2);
        ViewCompat.animate(v).setInterpolator(null);
    }
}