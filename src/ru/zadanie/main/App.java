package ru.zadanie.main;

import ru.zadanie.logging.Log;
import ru.zadanie.model.Car;
import ru.zadanie.thread.CarDeletingThread;
import ru.zadanie.thread.CarGeneratorThread;
import ru.zadanie.thread.CarMovingToParkThread;
import ru.zadanie.thread.ParkingInfoThread;

import java.util.*;

import static ru.zadanie.config.Constants.*;


public class App {

    public static Queue<Car> generatedList = new LinkedList<>();
    public static List<Car> inParkingList = new ArrayList<>();
    private static int parkingSize;
    private static int maxSizeGen;
    private static long genInterval;
    private static long dltInterval;
    private static Log log;


    public static void main(String[] args) {
        log = new Log();
        inputData();
        CarGeneratorThread carGeneratorThread = new CarGeneratorThread(System.nanoTime(), genInterval);
        carGeneratorThread.start();
        CarMovingToParkThread carMovingToParkThread = new CarMovingToParkThread();
        carMovingToParkThread.start();
        CarDeletingThread carDeletingThread = new CarDeletingThread(System.currentTimeMillis(), dltInterval);
        carDeletingThread.start();
        ParkingInfoThread parkingInfoThread = new ParkingInfoThread();
        parkingInfoThread.start();

        synchronized (generatedList) {
            if (generatedList.size() >= maxSizeGen) {
                log.logErr("CARMAGEDDON!!!");
            }
        }
    }

    private static void inputData() {
        Scanner scan = new Scanner(System.in);
        log = new Log();
        try {
            log.logInfo(INPUT_PARKING_SIZE);
            parkingSize = scan.nextInt();
            log.logInfo(INPUT_MAX_SIZE_GEN);
            maxSizeGen = scan.nextInt();
            log.logInfo(INPUT_GEN_INTERVAL);
            genInterval = scan.nextLong() * 1_000_000_000;
            log.logInfo(INPUT_DLT_INTERVAL);
            dltInterval = scan.nextLong() * 1_000_000_000;
        } catch (Exception e) {
            log.logErr(INPUT_DATA_ERROR);
            System.exit(0);
        } finally {
            scan.close();
        }
    }
}
