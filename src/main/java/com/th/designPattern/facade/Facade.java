package com.th.designPattern.facade;

/**
 * Created by tianhui on 16/9/5.
 */
public class Facade {
    private static Camara c1, c2;
    private static Light l1, l2, l3;
    private static Sensor s;

    static {
        c1 = new Camara();
        c2 = new Camara();
        l1 = new Light();
        l2 = new Light();
        l3 = new Light();
        s = new Sensor();
    }

    public static void activate() {
        c1.turnOn();
        c2.turnOn();

        l1.turnOn();
        l2.turnOn();
        l3.turnOn();

        s.activate();
    }

    public static void deactivate() {
        c1.turnOff();
        c2.turnOff();

        l1.turnOff();
        l2.turnOff();
        l3.turnOff();

        s.deactivate();
    }
}
