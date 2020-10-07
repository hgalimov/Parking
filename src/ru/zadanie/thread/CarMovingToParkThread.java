package ru.zadanie.thread;

import ru.zadanie.logging.Log;
import ru.zadanie.model.Car;

import static ru.zadanie.main.App.generatedList;
import static ru.zadanie.main.App.inParkingList;

public class CarMovingToParkThread extends Thread {
    private Log log;

    public CarMovingToParkThread(){
        log = new Log();
    }

    @Override
    public void run() {
        while (true) {
            moveCarToPark();
        }
    }

    private synchronized void moveCarToPark() {
        if (generatedList.peek() != null) {
            Car car = generatedList.poll();
            inParkingList.add(car);
            log.logInfo(car.getType().toString() + " c id = " +
                    car.getId() + " встал в очередь на въезд.");
        }
    }
}
