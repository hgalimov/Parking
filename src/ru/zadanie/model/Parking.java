package ru.zadanie.model;

import ru.zadanie.config.CarType;
import ru.zadanie.logging.Log;

import java.util.*;

public class Parking {
    private int parkingSize;
    private int curLoad;
    private int lightCarCount;
    private int truckCount;
    private int freePlace;
    private List<Car> inParkingList;

    public Parking(int parkingSize) {
        this.parkingSize = parkingSize;
        freePlace = parkingSize;
        inParkingList = new ArrayList<>();
    }

    private Parking() {

    }

    public int getFreePlace() {
        return freePlace;
    }

    public int getSize() {
        return parkingSize;
    }

    public void setSize(int size) {
        this.parkingSize = parkingSize;
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

    public void dltCar(Log log) {
        int size = inParkingList.size();
        if (size > 0) {
            Car car = inParkingList.remove(new Random().nextInt(size));
            curLoad -= car.getSize();
            freePlace += car.getSize();
            CarType carType = car.getType();
            if (carType.equals(CarType.LIGHT_CAR)) {
                lightCarCount--;
            } else if (
                    carType.equals(CarType.TRUCK)) {
                truckCount--;
            }
            log.logInfo(car.getType().toString() + " c id = " +
                    car.getId() + " покинул парковку.");
        }

    }

    public boolean addCar(Car car, Log log) {
        if (car != null) {
            int carSize = car.getSize();
            if (carSize + curLoad <= parkingSize) {
                if (inParkingList.add(car)) {
                    CarType carType = car.getType();
                    if (carType.equals(CarType.LIGHT_CAR)) {
                        lightCarCount++;
                    } else if (
                            carType.equals(CarType.TRUCK)) {
                        truckCount++;
                    }
                    curLoad += carSize;
                    freePlace -= carSize;
                    log.logInfo(carType.toString() + " c id = " +
                            car.getId() + " припарковался.");
                    return true;
                }
            }
        }
        return false;
    }
}
