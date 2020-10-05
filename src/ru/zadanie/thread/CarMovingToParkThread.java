package ru.zadanie.thread;

import ru.zadanie.model.Car;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static ru.zadanie.main.App.generatedList;
import static ru.zadanie.main.App.inParkingList;

public class CarMovingToParkThread extends Thread{

    @Override
    public void run() {
        moveCarToPark();
    }
    private synchronized void moveCarToPark(){
        Car car = generatedList.poll();
        inParkingList.add(car);
        System.out.println(car.getId() + "на парковке");
    }
}
