package ru.zadanie.config;

import java.util.UUID;

public class Id {
    private static long id = 0;

    public static synchronized String createID()
    {
        String uniqueId = UUID.randomUUID().toString() + id++;
        return uniqueId;
    }
}
