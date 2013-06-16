package com.wemakestuff.httptester.core;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.SystemClock;
import com.squareup.otto.Bus;
import com.squareup.otto.Produce;
import com.squareup.otto.Subscribe;
import com.wemakestuff.httptester.BootstrapApplication;
import com.wemakestuff.httptester.util.Ln;

import javax.inject.Inject;

public class TimerService extends Service {

    @Inject protected Bus BUS;
    @Inject NotificationManager notificationManager;

    private boolean timerRunning = false;
    private boolean timerStarted;
    private long base;
    private long currentRunningTimeInMillis;
    private long pausedBaseTime;
    private boolean isPaused;

    public static final int TICK_WHAT = 2;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        BootstrapApplication.getInstance().inject(this);

        // Register the bus so we can send notifications.
        BUS.register(this);

    }

    @Override
    public void onDestroy() {

        // Unregister bus, since its not longer needed as the service is shutting down
        BUS.unregister(this);

        Ln.d("Service has been destroyed");

        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if(timerStarted == false) {

            timerStarted = true;

            startTimer();
        }

        return START_NOT_STICKY;
    }

    @Produce
    public TimerTickEvent produceTickEvent() {
        return new TimerTickEvent(currentRunningTimeInMillis);
    }

    @Produce
    public TimerPausedEvent produceTimerIsPausedEvent() {
        return new TimerPausedEvent(isPaused);
    }

    @Subscribe
    public void onStopEvent(StopTimerEvent stopEvent) {

        timerHandler.removeMessages(TICK_WHAT);
        stopSelf();
    }

    @Subscribe
    public void onPauseEvent(PauseTimerEvent pauseEvent) {
        pauseTimer();
    }

    /**
     * Pauses the active running timer and updates the notification in the status bar.
     */
    private void pauseTimer() {
        timerHandler.removeMessages(TICK_WHAT);
        pausedBaseTime = SystemClock.elapsedRealtime() - base;
        timerRunning = false;
        isPaused = true;

        produceTimerIsPausedEvent();
    }

    @Subscribe
    public void onResumeTimerEvent(ResumeTimerEvent resumeTimerEvent) {
        startTimer();
    }

    private void startTimer() {
        startChronoTimer();
    }

    private void startChronoTimer() {
        base = SystemClock.elapsedRealtime();

        // If coming from a paused state, then find our true base.
        if(pausedBaseTime > 0)
            base = base - pausedBaseTime;

        isPaused = false;

        updateRunning();
    }

    /**
     * Starts the generic timer.
     */
    private void updateRunning() {
        if (timerStarted != timerRunning) {
            if (timerStarted) {
                dispatchTimerUpdate(SystemClock.elapsedRealtime());
                timerHandler.sendMessageDelayed(Message.obtain(timerHandler, TICK_WHAT), 1000);
            } else {
                timerHandler.removeMessages(TICK_WHAT);
            }
            timerRunning = timerStarted;
        }
    }

    private Handler timerHandler = new Handler() {
        public void handleMessage(Message m) {
            if (timerRunning) {
                dispatchTimerUpdate(SystemClock.elapsedRealtime());
                sendMessageDelayed(Message.obtain(this, TICK_WHAT), 1000);
            }
        }
    };

    private void dispatchTimerUpdate(long now) {

        currentRunningTimeInMillis = now - base;
        Ln.d("Elapsed Seconds: " + currentRunningTimeInMillis / 1000);

        BUS.post(produceTickEvent());

    }
}
