package Fonctionnalitées;

import java.util.Timer;
import java.util.TimerTask;

public class Sablier {
    Timer timer;

    public Sablier(int seconds) {
        timer = new Timer();
        timer.schedule(new StopTask(), seconds * 1000);
    }

    public static void main(String[] args) {
        new Sablier(30);
        System.out.println("Timer just Started.");
    }

    class StopTask extends TimerTask {
        public void run() {
            System.out.println("Time Up!");
            timer.cancel();
        }
    }
}
