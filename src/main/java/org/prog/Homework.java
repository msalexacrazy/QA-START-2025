package org.prog;

//TODO: 1. Add class Plane which has current passengers count,
// max passengers cound and flight ID as string "AA-1001"
// 2. Create new Plane, set passengers, max passengers and flight id

public class Homework {
    public static void main(String[] args) {
        Car aliceCar = new Car();
        Car bobCar = new Car();

        aliceCar.color = "blue";
        aliceCar.model = "3";
        bobCar.color = "red";

        aliceCar.goTo("Mexico");
        bobCar.goTo("Ukraine");

        Plane boeing747 = new Plane();
        boeing747.flight(525, 660, "103 Pan American");
    }
}