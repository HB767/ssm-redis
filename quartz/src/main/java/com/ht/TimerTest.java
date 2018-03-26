package com.ht;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    public static void main(String[] args) {
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("quick start");
            }
        }, 0, 5 * 1000);
    }


}
