/**
 * sms org.ashtray.mobile.sms
 * <p>
 * Created by Ash Wu on 1/04/2018 1:23 PM.
 * Copyright (c) 2018 ashtray.org
 */
package org.ashtray.mobile.sms;

import android.util.Log;

import org.ashtray.mobile.sms.cons.Const;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
  
  public final static String toString(Object obj) {
    if (obj == null) {
      return Const.NULL_STR;
    }
    if (obj instanceof Date) {
      return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(obj);
    }
    return obj.toString();
  }
  
  public final static void Log(Object content) {
    Log.d(Const.TAG,toString(content));
  }
}
