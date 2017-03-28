package com.calypso.library.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Project：Calypso
 * Created：jianz
 * Date：2017/3/28 11:15
 * Summry：
 * <receiver android:name=".receiver.BootCompleteReceiver">
 * <intent-filter>
 * <action android:name="android.intent.action.BOOT_COMPLETED"/>
 * </intent-filter>
 * </receiver>
 */

public class BootCompleteReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
    }


}
