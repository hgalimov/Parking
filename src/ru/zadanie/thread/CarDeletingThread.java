package ru.zadanie.thread;

import ru.zadanie.logging.Log;
import ru.zadanie.model.Car;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static ru.zadanie.main.App.inParkingList;

public class CarDeletingThread extends Thread{
    private long beginTime;
    private long interval;
    private Log log;


    public CarDeletingThread(long beginTime, long interval) {
        this.interval = interval;
        this.beginTime = beginTime;
        log = new Log();
    }

    @Override
    public void run() {
        while (true) {
            long rndTime = (long) (Math.random() * interval);
            while (true){
                if (beginTime + rndTime <= System.nanoTime() && System.nanoTime() < beginTime + interval) {
                    beginTime = System.nanoTime();
                    deleteCar();
                    break;
                }
            }
        }
    }

    private synchronized void deleteCar() {
        int size = inParkingList.size();
        if (size > 0) {
            Car car = inParkingList.remove(new Random().nextInt(size));
            log.logInfo(car.getType().toString() + " c id = " +
                    car.getId() + " покинул парковку.");
        }
    }
}
