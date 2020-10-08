package ru.zadanie.thread;
import ru.zadanie.logging.Log;
import ru.zadanie.model.Parking;

import static ru.zadanie.main.App.generatedList;

public class ParkingInfoThread extends Thread{
    private Parking parking;
    private Log log;

    public ParkingInfoThread(Parking parking) {
        this.parking = parking;
        log = new Log();
    }

    @Override
    public void run(){
        printInfo();
    }

    private synchronized void printInfo(){
        while (true) {
            log.logInfo("Свободных мест: " + parking.getFreePlace());
            log.logInfo("Занято мест: " + parking.getCurLoad() + " (" +
                    parking.getLightCarCount() + " легков.авто и " + parking.getTruckCount() + " груз.авто" +")");
            log.logInfo("Количество автомобилей, ожидающих в очереди: " + generatedList.size());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
