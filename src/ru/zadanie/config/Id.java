package ru.zadanie.config;

import java.util.UUID;

public class Id {
    private static long id = 0;

    public static synchronized String createID()
    {
        String uniqueId =  id++ + "_" + UUID.randomUUID().toString();
        return uniqueId;
    }
}
