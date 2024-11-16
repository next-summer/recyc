package com.example.myapplication2;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService_music extends Service {
    private MediaPlayer mediaPlayer;
    private boolean ison = false;

    public class LocalBinder extends Binder {
        MyService_music getService() {
            return MyService_music.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("xx", "onCreate()");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("xx", "onBind()");
        return new LocalBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("xx", "onUnbind()");
        // 通常不需要在这里停止音乐，除非你有特殊需求
        // 因为当没有客户端绑定时，服务可能会继续运行（取决于返回的标志）
        // 但在这个例子中，我们会在onDestroy中停止音乐
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("xx", "onDestroy()");
        stopMusic(); // 确保在服务被销毁时停止音乐
    }

    public void playMusic() {
        if (!ison) {
            Log.d("xx", "playMusic()");
            mediaPlayer = MediaPlayer.create(this, R.raw.music2); // 确保您有一个音乐文件在 res/raw 目录下
            mediaPlayer.start();
            ison = true;
        }
    }

    public void stopMusic() {
        if (ison && mediaPlayer != null) {
            Log.d("xx", "stopMusic()");
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
            ison = false;
        }
    }
}