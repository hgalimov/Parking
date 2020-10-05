package ru.zadanie.thread;

import ru.zadanie.config.CarType;
import ru.zadanie.model.Car;
import ru.zadanie.model.LightCar;
import ru.zadanie.model.Truck;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static ru.zadanie.config.RandomCarType.generateCarType;
import static ru.zadanie.main.App.generatedList;
import static ru.zadanie.main.App.inParkingList;

public class CarDeletingThread extends Thread{
    private long beginTime;
    private long interval;


    public CarDeletingThread(long beginTime, long interval) {
        this.interval = interval;
        this.beginTime = beginTime;
    }

    @Override
    public void run() {
        while (true) {
            long rndTime = ThreadLocalRandom.current().nextLong(interval);
            if (System.currentTimeMillis() >= rndTime && System.currentTimeMillis() <= beginTime + interval) {
                deleteCar();
                beginTime = System.currentTimeMillis() + rndTime;
                System.out.println(rndTime + " " +System.currentTimeMillis());
            }
        }
    }

    private synchronized void deleteCar() {
        int num = new Random().nextInt(inParkingList.size());
        inParkingList.remove(num);
    }
}
