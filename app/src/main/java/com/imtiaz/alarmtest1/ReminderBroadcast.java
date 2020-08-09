package com.imtiaz.alarmtest1;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class ReminderBroadcast  extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent){
        Intent activityIntent = new Intent(context.getApplicationContext(), MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context.getApplicationContext(), 0, activityIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "notifyimti")
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle("The Spidey in Action")
                .setContentText("This is freaking Working")
                .setContentIntent(pendingIntent)
             //   .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_MAX);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(200, builder.build());
    }
}
