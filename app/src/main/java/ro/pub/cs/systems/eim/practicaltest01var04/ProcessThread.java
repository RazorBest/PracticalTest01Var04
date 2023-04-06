package ro.pub.cs.systems.eim.practicaltest01var04;

import android.content.Context;
import android.content.Intent;

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

    private void sendMessage(String text) {
        Intent intent = new Intent();
        intent.setAction(Constants.actionTypes[random.nextInt(Constants.actionTypes.length)]);
        intent.putExtra("text", text);
        context.sendBroadcast(intent);
    }
}