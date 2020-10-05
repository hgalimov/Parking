package ru.zadanie.main;
import ru.zadanie.model.Car;
import ru.zadanie.thread.CarDeletingThread;
import ru.zadanie.thread.CarGeneratorThread;
import ru.zadanie.thread.CarMovingToParkThread;

import java.util.*;

import static ru.zadanie.config.Constants.*;


public class App {

    public static Queue<Car> generatedList = new LinkedList<>();
    public static List<Car> inParkingList = new ArrayList<>();
    private static int parkingSize;
    private static int maxSizeGen;
    private static long genInterval;
    private static long dltInterval;



    public static void main(String[] args) {
        inputData();
        CarGeneratorThread carGeneratorThread = new CarGeneratorThread(System.currentTimeMillis(), genInterval);
        carGeneratorThread.start();
        /*CarDeletingThread deletingThread = new CarDeletingThread(System.currentTimeMillis(), dltInterval);
        deletingThread.start();
        CarMovingToParkThread carMovingToParkThread = new CarMovingToParkThread();
        carMovingToParkThread.start();*/
        System.out.println(generatedList.size());
    }

    private static void inputData() {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println(INPUT_PARKING_SIZE);
            parkingSize = scan.nextInt();
            System.out.println(INPUT_MAX_SIZE_GEN);
            maxSizeGen = scan.nextInt();
            System.out.println(INPUT_GEN_INTERVAL);
            genInterval = scan.nextLong() * 1000L;
            System.out.println(INPUT_DLT_INTERVAL);
            dltInterval = scan.nextLong() * 1000L;
        }
        catch (Exception e) {
            System.err.println(INPUT_DATA_ERROR);
            System.exit(0);
        }
        finally {
            scan.close();
        }
    }
}
