package com.calypso.library;

import android.app.Application;
import android.os.Build;
import android.os.Environment;

import com.mrym.common.activity.base.AppManager;
import com.mrym.common.utils.CrashHandler;

import java.io.File;

/**
 * Created by Jian on 2016/12/19.
 * Email: 798774875@qq.com
 * Github: https://github.com/moruoyiming
 */
public class BaseApplication extends Application {

    private static BaseApplication mInstance;
    public static boolean isDebug=true;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        CrashHandler.getInstance().init(mInstance);
    }

    public static BaseApplication getInstance() {
        return mInstance;
    }


    public void exit() {
        AppManager.getAppManager().AppExit(mInstance, false);
    }

    @Override
    public File getCacheDir() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File cacheDir = getExternalCacheDir();
            if (cacheDir != null && (cacheDir.exists() || cacheDir.mkdirs())) {
                return cacheDir;
            }
        }
        return super.getCacheDir();
    }

    public String getLogSavePath() {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                return BaseApplication.getInstance().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS).getPath() + File.separator;
            } catch (NullPointerException e) {
                return Environment.getExternalStorageDirectory() + File.separator + "Documents" + File.separator;
            }
        }
        return Environment.getExternalStorageDirectory() + File.separator + "Documents" + File.separator;
    }
}
