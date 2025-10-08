package org.prog;

public class Plane {

    public int currentPassengersCount;
    public int maxPassengersCount;
    public String flightID;

    public void flight(int currentPassengersCount, int maxPassengersCount, String flightID) {
        System.out.println("Flight " + flightID + " includes passengers " + currentPassengersCount + " at maximum possible occupancy " + maxPassengersCount);
    }
}