package org.prog.oop;

//TODO: Create new Plane, set passengers, max passengers and flight id
// 1. write method that will tell how many seats are still available.
// 2. Write code which will fill plane with:
// - random max passengers from [100 to 200]
// - random passengers on board up to maxPassengers;
// - random flight id as UUID
// 3. print number of planes with half or less seats taken

import java.util.Random;
import java.util.UUID;

public class Homework {
    public static void main(String[] args) {

        Plane[] airplanes = new Plane[10];
        Random rand = new Random();
        int countPlanesWithHalfOrLessSeatsTaken = 0;

        for (int i = 0; i < airplanes.length; i++) {
            airplanes[i] = new Plane();
            airplanes[i].maxPassengersCount = rand.nextInt(100,200);
            airplanes[i].currentPassengersCount = rand.nextInt(0,airplanes[i].maxPassengersCount);
            airplanes[i].flightID = UUID.randomUUID().toString();
            airplanes[i].flight();

            if((airplanes[i].maxPassengersCount - airplanes[i].currentPassengersCount)<=(airplanes[i].maxPassengersCount/2)) {
                countPlanesWithHalfOrLessSeatsTaken++;
            }
        }
        System.out.println("");
        System.out.println("Planes with half or less seats taken " + countPlanesWithHalfOrLessSeatsTaken);
    }
}