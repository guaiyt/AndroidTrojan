package com.example.gx.androidtrojan;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class BootCompleteReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        // 开启子进程
        new StartUpThread(context).start();
    }
}

class StartUpThread extends Thread{
    private Context context;

    public StartUpThread(Context context) {
        super();
        this.context=context;//从BootCompleteReceiver类传入参数
    }

    //子进程执行的操作
    public void run(){
        Intent bootintent = new Intent(context, MainActivity.class);
        bootintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(bootintent);//开始主活动
    }

}