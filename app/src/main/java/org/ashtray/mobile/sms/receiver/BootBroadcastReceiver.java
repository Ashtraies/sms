/**
 * sms org.ashtray.mobile.sms.receiver
 * <p>
 * Created by Ash Wu on 1/04/2018 2:16 PM.
 * Copyright (c) 2018 ashtray.org
 */
package org.ashtray.mobile.sms.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import org.ashtray.mobile.sms.Utils;
import org.ashtray.mobile.sms.cons.Const;

public class BootBroadcastReceiver extends BroadcastReceiver {
  
  @Override
  public void onReceive(Context context,Intent intent) {
    if (intent.getAction().equals(Const.BOOT_COMPLETED)) {
      Utils.Log("Boot completed!");
//      Intent serviceIntent = new Intent(context, StartOnBootService.class);
//      context.startService(serviceIntent);
    }
  }
}
