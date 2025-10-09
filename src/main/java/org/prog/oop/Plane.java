package org.prog.oop;

public class Plane {

    public int currentPassengersCount;
    public int maxPassengersCount;
    public String flightID;

    public void flight() {
        System.out.println("Flight " + flightID + " includes passengers " + currentPassengersCount + " at maximum possible occupancy " + maxPassengersCount);
    }
}