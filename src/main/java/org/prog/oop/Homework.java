package org.prog.oop;

//TODO: Create new Plane, set passengers, max passengers and flight id
// 1. write method that will tell how many seats are still available.
// 2. Write code which will fill plane with:
// - random max passengers from [100 to 200]
// - random passengers on board up to maxPassengers;
// - random flight id as UUID
// 3. print number of planes with half or less seats taken
// 4. * - make at least 50 planes in array
//    * - sort planes by percentage of seats takes

import java.util.Random;
import java.util.UUID;

public class Homework {
    public static void main(String[] args) {

        Plane[] airplanes = new Plane[50];
        Random rand = new Random();
        int countPlanesWithHalfOrLessSeatsTaken = 0;

        for (int countForPlanes = 0; countForPlanes < airplanes.length; countForPlanes++) {
            airplanes[countForPlanes] = new Plane();
            airplanes[countForPlanes].randomNamePlane();
            airplanes[countForPlanes].maxPassengersCount = rand.nextInt(100,201);
            airplanes[countForPlanes].currentPassengersCount = rand.nextInt(0,airplanes[countForPlanes].maxPassengersCount);
            airplanes[countForPlanes].flightID = UUID.randomUUID().toString();
            airplanes[countForPlanes].flight();

            if(airplanes[countForPlanes].currentPassengersCount<=(airplanes[countForPlanes].maxPassengersCount/2)) {
                countPlanesWithHalfOrLessSeatsTaken++;
            }

            airplanes[countForPlanes].percentageOfSeatsTakes = (airplanes[countForPlanes].currentPassengersCount * 100)/ airplanes[countForPlanes].maxPassengersCount;
            airplanes[countForPlanes].currentPercentageOfSeatsTakes();

            System.out.println("");
        }

        System.out.println("Planes with half or less seats taken " + countPlanesWithHalfOrLessSeatsTaken);

        //SORT
            boolean unsorted = airplanes.length > 1;

            while (unsorted) {
                unsorted = false;
                for (int countForSort = 0; countForSort < (airplanes.length - 1); countForSort++) {
                    int currentElement = airplanes[countForSort].percentageOfSeatsTakes;
                    int nextElement = airplanes[countForSort + 1].percentageOfSeatsTakes;

                    if (nextElement < currentElement) {
                        unsorted = true;
                        Plane temp = airplanes[countForSort];
                        airplanes[countForSort] = airplanes[countForSort + 1];
                        airplanes[countForSort + 1] = temp;
                    }
                }
                System.out.println(" ");
                for (int countForPlanes = 0; countForPlanes < airplanes.length; countForPlanes++) {
                    System.out.print(airplanes[countForPlanes].percentageOfSeatsTakes + " ");
                }
            }
    }
}