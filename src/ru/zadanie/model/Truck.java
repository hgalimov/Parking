package ru.zadanie.model;

import ru.zadanie.config.CarType;
import ru.zadanie.config.Constants;
import ru.zadanie.config.Id;

public class Truck extends Car {
    private String id;
    private int size;
    private CarType type;

    public Truck() {
        id = Id.createID();
        size = Constants.TRUCK_SIZE;
        type = CarType.TRUCK;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public CarType getType() {
        return type;
    }

    @Override
    public void setType(CarType type) {
        this.type = type;
    }
}
