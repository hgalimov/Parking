package ru.zadanie.thread;

import ru.zadanie.logging.Log;
import ru.zadanie.model.Parking;

import java.util.concurrent.ThreadLocalRandom;

public class CarDeletingThread extends Thread {
    private long beginTime;
    private long interval;
    private Log log;
    private Parking parking;

    private CarDeletingThread() {

    }

    public CarDeletingThread(long beginTime, long interval,Parking parking) {
        this.interval = interval;
        this.beginTime = beginTime;
        this.parking = parking;
        log = new Log();
    }

    @Override
    public void run() {
        while (true) {
            long rndTime = ThreadLocalRandom.current().nextLong(interval);
            while (true) {
                if (beginTime + rndTime <= System.nanoTime() && System.nanoTime() < beginTime + interval) {
                    beginTime = System.nanoTime();
                    deleteCar();
                    break;
                }
            }
        }
    }

    private synchronized void deleteCar() {
        parking.dltCar(log);
    }
}
