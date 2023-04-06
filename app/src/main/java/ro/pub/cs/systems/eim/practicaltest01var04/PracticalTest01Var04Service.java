package ro.pub.cs.systems.eim.practicaltest01var04;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class PracticalTest01Var04Service extends Service {
    public PracticalTest01Var04Service() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        String text1 = intent.getStringExtra("text1");
        String text2 = intent.getStringExtra("text2");

        ProcessThread processingThread = new ProcessThread(this, text1, text2);
        processingThread.start();
        return Service.START_REDELIVER_INTENT;
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}