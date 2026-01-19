package com.example.session8;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class CounterService extends Service {
    private static final String TAG = "CounterServiceDemo";
    private boolean isRunning = false;
    private int counter = 0;
    private Thread backgroundThread;

    public CounterService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        if(!isRunning){
            isRunning = true;
            Log.d(TAG, "Service started. Start background counter");
            backgroundThread = new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            while(isRunning){
                                try{
                                    Thread.sleep(1000);
                                    counter++;
                                    Log.d(TAG, "Counter : "+counter);
                                }catch (Exception e){
                                    Thread.currentThread().interrupt();
                                    Log.d(TAG, "Exception Thread Interrupted");
                                }
                            }
                        }
                    }
            );
            backgroundThread.start();
        }
        return START_STICKY;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        Log.d(TAG, "Service Created");
    }

    @Override
    public void onDestroy(){
        isRunning = false;
        if(backgroundThread != null){
            backgroundThread.interrupt();
        }
        Log.d(TAG, " Service is Destroyed. Final Count: "+ counter);
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
       return null;
    }
}