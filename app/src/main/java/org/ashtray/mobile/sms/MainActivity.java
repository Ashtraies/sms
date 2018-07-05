/**
 * sms
 * <p>
 * Created by Ash Wu on 1/04/2018 8:37 AM.
 */
package org.ashtray.mobile.sms;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Toast;

import org.ashtray.mobile.sms.permission.PermissionManager;

import java.util.Date;

/**
 * @Description
 * @Author Ash Wu
 * @Date 1/04/2018
 * @Version 1.0
 * @See
 */
public class MainActivity extends Activity {
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    checkPermission();
  }
  
  private void checkPermission() {
    if (!PermissionManager.checkSendSms(this) || !PermissionManager.checkReceiveSms(this)) {
      PermissionManager.requestPermission(this);
    }
  }
  
  @Override
  public void onRequestPermissionsResult(int requestCode,@NonNull String[] permissions,@NonNull int[] grantResults) {
    switch (requestCode) {
      case PermissionManager.REQUEST_PERMISSION_CODE: {
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
          //alright
        } else {
          Toast.makeText(this,"Cannot use this app",Toast.LENGTH_LONG).show();
          finish();
        }
      }
    }
  }
  
  public void Func1(View v) {
  }
  
  public void Func2(View v) {
    if (PermissionManager.checkSendSms(this)) {
      PendingIntent pi = PendingIntent.getActivity(this,0,new Intent(),0);
      SmsManager manager = SmsManager.getSmsManagerForSubscriptionId(4);
      manager.sendTextMessage("+642108194233",null,new Date().toString(),pi,null);
    }
  }
  
  public void Func3(View v) {
    if (PermissionManager.checkSendSms(this)) {
      PendingIntent pi = PendingIntent.getActivity(this,0,new Intent(),0);
      SmsManager manager = SmsManager.getSmsManagerForSubscriptionId(5);
      manager.sendTextMessage("+642108194233",null,new Date().toString(),pi,null);
    }
  }
}