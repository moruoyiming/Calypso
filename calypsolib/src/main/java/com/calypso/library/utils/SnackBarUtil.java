package com.calypso.library.utils;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by Jian on 2016/12/19.
 * Email: 798774875@qq.com
 * Github: https://github.com/moruoyiming
 */
public class SnackBarUtil {
    private static final int color_danger = 0XFFA94442;
    private static final int color_success = 0XFF3C763D;
    private static final int color_info = 0XFF31708F;
    private static final int color_warning = 0XFF8A6D3B;

    private static final int color_action = 0XFFCDC5BF;

    private Snackbar mSnackbar;

    private SnackBarUtil(Snackbar snackbar) {
        mSnackbar = snackbar;
    }

    public static SnackBarUtil makeShort(View view, String text) {
        Snackbar snackbar = Snackbar.make(view, text, Snackbar.LENGTH_SHORT);
        return new SnackBarUtil(snackbar);
    }

    public static SnackBarUtil makeLong(View view, String text) {
        Snackbar snackbar = Snackbar.make(view, text, Snackbar.LENGTH_LONG);
        return new SnackBarUtil(snackbar);
    }

    private View getSnackBarLayout(Snackbar snackbar) {
        if (snackbar != null) {
            return snackbar.getView();
        }
        return null;

    }


    private Snackbar setSnackBarBackColor(int colorId) {
        View snackBarView = getSnackBarLayout(mSnackbar);
        if (snackBarView != null) {
            snackBarView.setBackgroundColor(colorId);
        }
        return mSnackbar;
    }

    public void info() {
        setSnackBarBackColor(color_info);
        show();
    }

    public void info(String actionText, View.OnClickListener listener) {
        setSnackBarBackColor(color_info);
        show(actionText, listener);
    }

    public void warning() {
        setSnackBarBackColor(color_warning);
        show();
    }

    public void warning(String actionText, View.OnClickListener listener) {
        setSnackBarBackColor(color_warning);
        show(actionText, listener);
    }

    public void danger() {
        setSnackBarBackColor(color_danger);
        show();
    }

    public void danger(String actionText, View.OnClickListener listener) {
        setSnackBarBackColor(color_danger);
        show(actionText, listener);
    }

    public void success() {
        setSnackBarBackColor(color_success);
        show();
    }

    public void success(String actionText, View.OnClickListener listener) {
        setSnackBarBackColor(color_success);
        show(actionText, listener);
    }

    public void show() {
        mSnackbar.show();
    }

    public void show(String actionText, View.OnClickListener listener) {
        mSnackbar.setActionTextColor(color_action);
        mSnackbar.setAction(actionText, listener).show();
    }
}
