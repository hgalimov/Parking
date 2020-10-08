package ru.zadanie.thread;

import ru.zadanie.logging.Log;
import ru.zadanie.model.Car;
import ru.zadanie.model.Parking;

import static ru.zadanie.main.App.generatedList;

public class CarMovingToParkThread extends Thread {
    private Log log;
    private Parking parking;

    private CarMovingToParkThread(){

    }
    public CarMovingToParkThread(Parking parking) {
        this.parking = parking;
        log = new Log();
    }

    @Override
    public void run() {
        while (true) {
            moveCarToPark();
        }
    }

    private synchronized void moveCarToPark() {
        Car car = generatedList.peek();
        if (car!= null) {
            if (parking.addCar(car, log)) {
                generatedList.remove(car);
            }
        }
    }
}
