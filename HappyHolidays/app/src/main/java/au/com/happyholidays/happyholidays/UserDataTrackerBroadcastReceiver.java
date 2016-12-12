package au.com.happyholidays.happyholidays;

import android.Manifest;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

/**
 * Created by tco on 2016-12-10.
 */

public class UserDataTrackerBroadcastReceiver extends BroadcastReceiver {

    public UserDataTrackerBroadcastReceiver(){

    }

    public UserDataTrackerBroadcastReceiver(Context context) {

        Intent intent = new Intent(context, UserDataTrackerBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                context, 234324243, intent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(context.ALARM_SERVICE);
//        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
//                + (5 * 1000), pendingIntent);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                + (5 * 1000),5000, pendingIntent);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Alarm triggered",
                Toast.LENGTH_SHORT).show();

        Log.d("RECEIVER", "Recieved a broadcast");
        WebApi.dropPin(context, Double.toString(Util.getLocation(context).getLatitude()),
                Double.toString(Util.getLocation(context).getLongitude()),
                Long.toString(System.currentTimeMillis()));
    }



}
