package ru.zadanie.logging;

public class Log {
    public void logInfo(String msg){
        System.out.println(msg);
    }
    public void logErr(String msg){
        System.err.println(msg);
    }
}
