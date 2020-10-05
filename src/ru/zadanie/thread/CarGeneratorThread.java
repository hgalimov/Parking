package ru.zadanie.thread;

import ru.zadanie.config.CarType;
import ru.zadanie.model.Car;
import ru.zadanie.model.LightCar;
import ru.zadanie.model.Truck;

import java.util.concurrent.ThreadLocalRandom;

import static ru.zadanie.config.RandomCarType.generateCarType;
import static ru.zadanie.main.App.generatedList;

public class CarGeneratorThread extends Thread {

    private long beginTime;
    private long interval;


    public CarGeneratorThread(long beginTime, long interval) {
        this.interval = interval;
        this.beginTime = beginTime;
    }

    @Override
    public void run() {
        while (true) {
            long rndTime = ThreadLocalRandom.current().nextLong(interval);
            if (beginTime + rndTime < System.currentTimeMillis() && System.currentTimeMillis() < beginTime + interval) {
                generateCar();
                beginTime = System.currentTimeMillis();
                System.out.println(rndTime + " " +System.currentTimeMillis());
                try {
                    Thread.sleep(rndTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private synchronized void generateCar() {
        CarType carType = generateCarType();
        switch (carType) {
            case LIGHT_CAR:
                Car lightCar = new LightCar();
                System.out.println(lightCar.getId() + " " + lightCar.getSize() + " " + lightCar.getType());
                generatedList.add(lightCar);
                break;
            case TRUCK:
                Car truck = new Truck();
                System.out.println(truck.getId() + " " + truck.getSize() + " " + truck.getType());
                generatedList.add(truck);
                break;
        }
        //System.out.println(generatedList.size() + " " + getName() + " " + carType);*/
    }
}
