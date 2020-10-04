package ru.zadanie.model;

import ru.zadanie.config.CarType;
import ru.zadanie.config.Constants;
import ru.zadanie.config.Id;

public class LightCar extends Car {
    private String id;
    private int size;
    private CarType type;

    public LightCar(){
        id = Id.createID();
        size = Constants.LIGHT_CAR_SIZE;
        type = CarType.LIGHT_CAR;
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
