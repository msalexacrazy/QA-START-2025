package org.prog.oop;

import java.util.Random;

public class Plane {

    public int currentPassengersCount;
    public int maxPassengersCount;
    public String flightID;
    public String namePlane;
    public int percentageOfSeatsTakes;

    public String[] arrayNamesPlane = new String[]{
            "Airbus A320neo", "Boeing 787 Dreamliner", "Boeing 777-300ER/777X", "Airbus A380", "Boeing 747-8i"
    };

    public void randomNamePlane() {
        Random rand = new Random();
        namePlane = arrayNamesPlane[rand.nextInt(arrayNamesPlane.length)];
    }

    public void flight() {
        System.out.println("");
        System.out.println("Flight " + namePlane + " " + flightID + " includes passengers " + currentPassengersCount + " at maximum possible occupancy " + maxPassengersCount);
    }

    public void currentPercentageOfSeatsTakes() {
        System.out.println("Plane " + namePlane + " " + flightID + " includes " + percentageOfSeatsTakes + " seat occupancy.");
    }
}