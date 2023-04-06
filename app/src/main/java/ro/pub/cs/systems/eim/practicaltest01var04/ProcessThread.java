package ro.pub.cs.systems.eim.practicaltest01var04;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ProcessThread extends Thread {
    private Context context;
    private String text1;
    private String text2;

    public ProcessThread(Context context, String text1, String text2) {
        this.context = context;
        this.text1 = text1;
        this.text2 = text2;
    }

    @Override
    public void run() {
        while(true){
            sendMessage(text1);
            Log.d("Test", "Sent 1");
            sleep();
            sendMessage(text2);
            sleep();
        }
    }

    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    private int a = 0;
    private void sendMessage(String text) {
        String[] actionTypes = {Intent.ACTION_VIEW, Intent.ACTION_WEB_SEARCH};
        Intent intent = new Intent();
        intent.setAction(actionTypes[a]);
        intent.putExtra("text", text);
        context.sendBroadcast(intent);

        a++;
        if (a > 1) {
            a = 0;
        }
    }
}