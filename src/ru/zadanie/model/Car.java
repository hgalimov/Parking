package ru.zadanie.model;

import ru.zadanie.config.CarType;

public abstract class Car {

    public abstract String getId();

    public abstract void setId(String id);

    public abstract int getSize();

    public abstract void setSize(int size);

    public abstract CarType getType();

    public abstract void setType(CarType type);
}
