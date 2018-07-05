/**
 * sms org.ashtray.mobile.sms.receiver
 * <p>
 * Created by Ash Wu on 1/04/2018 3:30 PM.
 * Copyright (c) 2018 ashtray.org
 */
package org.ashtray.mobile.sms.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

import org.ashtray.mobile.sms.Utils;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SmsBroadcastReceiver extends BroadcastReceiver {
  
  @Override
  public void onReceive(Context context,Intent intent) {
    Bundle bundle = intent.getExtras();
    Utils.Log(bundle.keySet());
    Utils.Log(bundle);
    
    Object[] objects = (Object[])bundle.get("pdus");
    for (Object object : objects) {
      
      SmsMessage sms = SmsMessage.createFromPdu((byte[])object);
      Utils.Log(new String(sms.getUserData(),Charset.forName("UTF8")));
      long t = sms.getTimestampMillis();
      String messageBody = sms.getDisplayMessageBody();
      String message = sms.getMessageBody();
      String from1 = sms.getDisplayOriginatingAddress();
      String from2 = sms.getOriginatingAddress();
      String center = sms.getServiceCenterAddress();
      Utils.Log("index " + sms.getIndexOnIcc());
      Utils.Log("getPseudoSubject " + sms.getPseudoSubject());
      Utils.Log("getTimestampMillis " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(t)));
      Utils.Log("getDisplayMessageBody " + messageBody);
      Utils.Log("getMessageBody " + message);
      Utils.Log("getDisplayOriginatingAddress " + from1);
      Utils.Log("getOriginatingAddress " + from2);
      Utils.Log(center);
    }
  }
}