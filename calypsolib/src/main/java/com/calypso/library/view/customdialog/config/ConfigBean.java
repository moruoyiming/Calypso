package com.calypso.library.view.customdialog.config;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.mrym.common.view.customdialog.StyledDialog;
import com.mrym.common.view.customdialog.Tool;
import com.mrym.common.view.customdialog.adapter.SuperLvAdapter;
import com.mrym.common.view.customdialog.bottomsheet.BottomSheetBean;
import com.mrym.common.view.customdialog.interfaces.MyDialogBuilder;
import com.mrym.common.view.customdialog.interfaces.MyDialogListener;
import com.mrym.common.view.customdialog.interfaces.MyItemDialogListener;
import com.mrym.common.view.customdialog.interfaces.Styleable;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
public class ConfigBean extends MyDialogBuilder implements Styleable {

    public int type;

    public Context context;
    public boolean isVertical;

    public View customView;

    public int gravity;

    public CharSequence title;
    public CharSequence msg;
    public CharSequence text1 = "确定";
    public CharSequence text2 = "取消";
    public CharSequence text3;

    public CharSequence hint1;
    public CharSequence hint2;



    public MyDialogListener listener;
    public MyItemDialogListener itemListener;

    public boolean cancelable = true;//默认可以点击后退键来dismiss对话框
    public boolean outsideTouchable = false;//默认外部半透明处点击不消失

    public Dialog dialog;
    public AlertDialog alertDialog;





    public int viewHeight;


    //各类对话框特有的参数
    public CharSequence[] wordsMd;
    public  int defaultChosen;//
    public boolean[] checkedItems;

    public List<? extends CharSequence> wordsIos;
    //bottom sheet
    public  CharSequence bottomTxt = "取消";

    //bottomsheet
    public SuperLvAdapter mAdapter;
    public List<BottomSheetBean> lvDatas;
    public int gridColumns = 4;



    //样式

    //三个以下按钮,颜色按此顺序
    public  @ColorRes
    int btn1Color = DefaultConfig.iosBtnColor;
    public  @ColorRes
    int btn2Color= DefaultConfig.iosBtnColor;
    public  @ColorRes
    int btn3Color= DefaultConfig.iosBtnColor;



    public @ColorRes
    int titleTxtColor = DefaultConfig.titleTxtColor;
    public @ColorRes
    int msgTxtColor = DefaultConfig.msgTxtColor;

    public  @ColorRes
    int lvItemTxtColor = DefaultConfig.lvItemTxtColor;
    public Map<Integer,Integer> colorOfPosition;//listview 的item的特殊颜色:ColorRes

    public  @ColorRes
    int inputTxtColor = DefaultConfig.inputTxtColor;


    /*可能需要拓展的功能，支持当个item字体大小和颜色设置 (比如底部弹出 ，有的item是红色字这种，有的是蓝色)
支持填充自定义布局
支持gridview 或者recylerview*/

    //字体大小
    public  int btnTxtSize = DefaultConfig.btnTxtSize;// in sp
    public  int titleTxtSize = DefaultConfig.titleTxtSize;
    public  int msgTxtSize = DefaultConfig.msgTxtSize;
    public  int itemTxtSize = DefaultConfig.itemTxtSize;
    public  int inputTxtSize = DefaultConfig.inputTxtSize;


    @Override
    public ConfigBean setBtnColor(@ColorRes int btn1Color, @ColorRes int btn2Color, @ColorRes int btn3Color) {
        if (btn1Color>0)
        this.btn1Color = btn1Color;
        if (btn2Color>0)
        this.btn2Color = btn2Color;
        if (btn3Color>0)
            this.btn3Color = btn3Color;
        return this;
    }

    @Override
    public ConfigBean setListItemColor(@ColorRes int lvItemTxtColor, Map<Integer, Integer> colorOfPosition) {
        if (lvItemTxtColor>0)
            this.lvItemTxtColor = lvItemTxtColor;
        if (colorOfPosition  != null && colorOfPosition.size()>0){
            this.colorOfPosition = colorOfPosition;
        }
        return this;
    }

    @Override
    public ConfigBean setTitleColor(@ColorRes int colorRes) {
        if (colorRes>0){
            this.titleTxtColor = colorRes;
        }
        return this;
    }

    @Override
    public ConfigBean setMsgColor(@ColorRes int colorRes) {
        if (colorRes >0){
            this.msgTxtColor = colorRes;
        }
        return this;
    }

    @Override
    public ConfigBean seInputColor(@ColorRes int colorRes) {
        if (colorRes >0){
            this.inputTxtColor = colorRes;
        }
        return this;
    }

    @Override
    public ConfigBean setTitleSize(int sizeInSp) {
        if (sizeInSp >0 && sizeInSp < 30){
            this.titleTxtSize = sizeInSp;
        }
        return this;
    }

    @Override
    public ConfigBean setMsgSize(int sizeInSp) {
        if (sizeInSp >0 && sizeInSp < 30){
            this.msgTxtSize = sizeInSp;
        }
        return this;
    }

    @Override
    public ConfigBean setBtnSize(int sizeInSp) {
        if (sizeInSp >0 && sizeInSp < 30){
            this.btnTxtSize = sizeInSp;
        }
        return this;
    }

    @Override
    public ConfigBean setLvItemSize(int sizeInSp) {
        if (sizeInSp >0 && sizeInSp < 30){
            this.itemTxtSize = sizeInSp;
        }
        return this;
    }

    @Override
    public ConfigBean setInputSize(int sizeInSp) {
        if (sizeInSp >0 && sizeInSp < 30){
            this.inputTxtSize = sizeInSp;
        }
        return this;
    }

    @Override
    public Dialog show() {

        //Build dialog by tyle :




        buildByType(this);
        //内部保存loadingdialog对象
        if(type == DefaultConfig.TYPE_LOADING || type == DefaultConfig.TYPE_MD_LOADING){
            StyledDialog.setLoadingObj(dialog);
        }


        if (dialog != null && !dialog.isShowing()){
            Tool.showDialog(dialog);
            return dialog;
        }else if (alertDialog != null && !alertDialog.isShowing()){
            Tool.showDialog(alertDialog);
            return alertDialog;
        }
        return null;
    }

    @Override
    public ConfigBean setBtnText(CharSequence btn1Text, @Nullable CharSequence btn2Text, @Nullable CharSequence btn3Text) {
        this.text1 = btn1Text;
        this.text2 = btn2Text;
        this.text3 = btn3Text;

        return this;
    }

    @Override
    public ConfigBean setBtnText(CharSequence positiveTxt, @Nullable CharSequence negtiveText) {
        return setBtnText(positiveTxt,negtiveText,"");
    }

    @Override
    public ConfigBean setListener(MyDialogListener listener) {
        if (listener!= null){
            this.listener = listener;
        }
        return this;
    }

    @Override
    public ConfigBean setCancelable(boolean cancelable, boolean outsideCancelable) {
        this.cancelable = cancelable;
        this.outsideTouchable = outsideCancelable;
        return this;
    }


}
