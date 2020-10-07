package ru.zadanie.thread;
import static ru.zadanie.main.App.generatedList;
import static ru.zadanie.main.App.inParkingList;

public class ParkingInfoThread extends Thread{

    @Override
    public void run(){
        printInfo();
    }

    private synchronized void printInfo(){
        while (true) {
            System.out.println(generatedList.size());
            System.out.println(inParkingList.size());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
