/**
 * sms org.ashtray.mobile.sms.permission
 * <p>
 * Created by Ash Wu on 3/04/2018 9:42 AM.
 * Copyright (c) 2018 ashtray.org
 */
package org.ashtray.mobile.sms.permission;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

public class PermissionManager {
  
  public static final int REQUEST_PERMISSION_CODE = 0;
  
  private static boolean checkPermission(Context context,String permission) {
    int g = ContextCompat.checkSelfPermission(context,permission);
    return g == PackageManager.PERMISSION_GRANTED;
  }
  
  public static boolean checkReceiveSms(Context context) {
    return checkPermission(context,Manifest.permission.RECEIVE_SMS);
  }
  
  public static boolean checkSendSms(Context context) {
    return checkPermission(context,Manifest.permission.SEND_SMS);
  }
  
  public static void requestPermission(Activity context) {
    ActivityCompat.requestPermissions(context,
            new String[] {
                    Manifest.permission.RECEIVE_SMS,Manifest.permission.SEND_SMS},REQUEST_PERMISSION_CODE);
  }
}
