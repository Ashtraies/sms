/**
 * sms org.ashtray.mobile.sms.app
 * <p>
 * Created by Ash Wu on 1/04/2018 1:20 PM.
 * Copyright (c) 2018 ashtray.org
 */
package org.ashtray.mobile.sms.app;

import android.app.Application;
import android.content.Context;

import org.ashtray.mobile.sms.Utils;

/**
 * @Description
 * 
 *
 * @Author Ash Wu
 * @Date 1/04/2018
 * @Version 1.0
 * @See
 */
public class SmsApplication extends Application {
  
  private static Context context;
  
  @Override
  public void onCreate() {
    super.onCreate();
    Utils.Log("Application on create!");
    context = getApplicationContext();
  }
  
  public static Context getInstance() {
    return context;
  }
}
