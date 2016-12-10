package au.com.happyholidays.happyholidays;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by tco on 2016-12-10.
 */

public class Prefs {
    public static String PIN_DROP_DELTA = "pin_drop_time_delta";



    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences("myprefs", 0);
    }

    public static int getIntPref(Context context, String key) {
        return getPrefs(context).getInt(key, 0);
    }

    public static void setIntPref(Context context, String key, int value) {
        getPrefs(context).edit().putInt(key, value).commit();
    }

    public static String getStringPref(Context context, String key) {
        return getPrefs(context).getString(key, "");
    }

    public static void setStringPref(Context context, String key, String value) {
        getPrefs(context).edit().putString(key, value).commit();
    }

}
