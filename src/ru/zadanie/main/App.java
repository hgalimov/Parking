package ru.zadanie.main;

import ru.zadanie.config.Id;
import ru.zadanie.model.Car;
import ru.zadanie.model.LightCar;
import ru.zadanie.model.Truck;

public class App {
    public static void main(String[] args) {
        Car truck = new Truck();
        truck.setSize(2);
        truck.setId(Id.createID());
        System.out.println(truck.getId() + " " + truck.getSize());

        Car lightCar = new LightCar();
        lightCar.setSize(1);
        lightCar.setId(Id.createID());
        System.out.println(lightCar.getId() + " " + lightCar.getSize());
    }
}
