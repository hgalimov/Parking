package ru.zadanie.thread;

import ru.zadanie.config.CarType;
import ru.zadanie.logging.Log;
import ru.zadanie.model.Car;
import ru.zadanie.model.LightCar;
import ru.zadanie.model.Truck;

import java.util.concurrent.ThreadLocalRandom;

import static ru.zadanie.config.RandomCarType.generateCarType;
import static ru.zadanie.main.App.generatedList;

public class CarGeneratorThread extends Thread {

    private long beginTime;
    private long interval;
    private Log log;


    public CarGeneratorThread(long beginTime, long interval) {
        this.interval = interval;
        this.beginTime = beginTime;
        log = new Log();
    }

    @Override
    public void run() {
        while (true) {
            long rndTime = ThreadLocalRandom.current().nextLong(interval);
            while (true) {
                if (beginTime + rndTime <= System.nanoTime() && System.nanoTime() < beginTime + interval) {
                    beginTime = System.nanoTime();
                    generateCar();
                    break;
                }
            }
        }
    }

    private synchronized void generateCar() {
        CarType carType = generateCarType();
        switch (carType) {
            case LIGHT_CAR:
                Car lightCar = new LightCar();
                log.logInfo(lightCar.getType().toString() +
                        " c id = " + lightCar.getId() + " встал в очередь на въезд.");
                generatedList.add(lightCar);
                break;
            case TRUCK:
                Car truck = new Truck();
                log.logInfo(truck.getType().toString() + " c id = " +
                        truck.getId() + " встал в очередь на въезд.");
                generatedList.add(truck);
                break;
        }
    }
}
