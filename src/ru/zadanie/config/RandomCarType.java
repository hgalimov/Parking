package ru.zadanie.config;

import java.util.Random;

public class RandomCarType {
    public static CarType generateCarType(){
        Random random = new Random();
        int num = random.nextInt(100);
        if (num > 20) {
            return CarType.LIGHT_CAR;
        }
        else {
            return CarType.TRUCK;
        }
    }
}
