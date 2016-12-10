package au.com.happyholidays.happyholidays;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by tco on 2016-12-10.
 */

public class Util {

    public static long dayInMilliseconds() {
        return 60000; //One minute
//        return 86400000; //One Day
    }


    public static String millisecondsToDate(long milliseconds, String dateFormat) {
        // Create a DateFormatter object for displaying date in specified format.
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);

        // Create a calendar object that will convert the date and time value in milliseconds to date.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliseconds);
        return formatter.format(calendar.getTime());
    }

    public static void createAlarmNotification(Context context, String title, String message, int id) {

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setOngoing(true)
                        .setSmallIcon(R.drawable.ic_announcement_18pt_3x)
                        .setContentTitle(title)
                        .setContentText(message);

        // Creates an explicit intent for an Activity in your app
        Intent resultIntent = new Intent(context, PinActivity.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        //// Adds the back stack for the Intent (but not the Intent itself)
        //        stackBuilder.addParentStack(ResultActivity.class);
        //// Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
//        // mId allows you to update the notification later on.
        mNotificationManager.notify(id, mBuilder.build());

    }


}