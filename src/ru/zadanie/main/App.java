package ru.zadanie.main;
import ru.zadanie.model.Car;
import ru.zadanie.thread.CarGeneratorThread;

import java.util.ArrayList;
import java.util.List;


public class App {

    public static List<Car> generatedList = new ArrayList<>();
    public static List<Car> inParkingList = new ArrayList<>();


    public static void main(String[] args) {
        long interval = 900L;
        CarGeneratorThread carGeneratorThread = new CarGeneratorThread(System.currentTimeMillis(), interval);
        carGeneratorThread.setName("Th");
        carGeneratorThread.start();
        try {
            carGeneratorThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(generatedList.size());
    }
}
