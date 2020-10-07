package ru.zadanie.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Parking {
    private int size;
    private int curLoad;
    private int lightCarCount;
    private int truckCount;
    private List<Car> inParkingList = new ArrayList<>();

    public Parking(int size, List<Car> inParkingList) {
        this.size = size;
        this.inParkingList = inParkingList;
    }

    private Parking() {

    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCurLoad() {
        return curLoad;
    }

    public void setCurLoad(int curLoad) {
        this.curLoad = curLoad;
    }

    public int getLightCarCount() {
        return lightCarCount;
    }

    public void setLightCarCount(int lightCarCount) {
        this.lightCarCount = lightCarCount;
    }

    public int getTruckCount() {
        return truckCount;
    }

    public void setTruckCount(int truckCount) {
        this.truckCount = truckCount;
    }
    public void dltCar(){

    }
    public void crtCar(){

    }
}
