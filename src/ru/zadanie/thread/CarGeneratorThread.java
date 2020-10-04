package ru.zadanie.thread;

import ru.zadanie.config.CarType;
import ru.zadanie.main.App;
import ru.zadanie.model.Car;
import ru.zadanie.model.LightCar;
import ru.zadanie.model.Truck;
import static ru.zadanie.main.App.*;

import java.util.List;

import static ru.zadanie.config.RandomCarType.generateCarType;

public class CarGeneratorThread extends Thread {

    private long beginTime;
    private long interval;


    public CarGeneratorThread(long beginTime, long interval) {
        this.interval = interval;
        this.beginTime = beginTime;
    }

    @Override
    public void run() {
        while (System.currentTimeMillis() < beginTime + interval) {
            generateCar();
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
        System.out.println(generatedList.size() + " " + getName() + " " + carType);
    }
}
