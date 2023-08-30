package com.example.notificationwindow;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class MainActivity extends AppCompatActivity {


    private static final String CHANNEL_ID = " My Channel";

    private static final int NOTIFICATION_ID = 100;
    private final NotificationManager nm;

   public MainActivity(NotificationManager nm) {
        this.nm = nm;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.download, null);

        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        assert bitmapDrawable != null;
        Bitmap largeIcon = bitmapDrawable.getBitmap();

        Notification notification;


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.download)
                    .setContentText("New Message ")
                    .setSubText("new Message from version")
                    .setChannelId(CHANNEL_ID)
                    .build();
            nm.createNotificationChannel(
                    new NotificationChannel(CHANNEL_ID, "My Channel",
                            NotificationManager.IMPORTANCE_HIGH));


        } else {
            notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.download)
                    .setContentText("New Message ")
                    .setSubText("new Message from version")
                    .build();


            }
        nm.notify(NOTIFICATION_ID,notification);

        }
    }

