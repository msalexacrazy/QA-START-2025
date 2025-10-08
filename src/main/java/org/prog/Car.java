package org.prog;

public class Car {

    public String color;
    public String model;

    //TODO: Add method parameter with destination
    public void goTo(String destination) {
        System.out.println(color + " car is going to " + destination);
    }

    public void refuel(int amount, String fuelType) {
        System.out.println(color + " car is refueling " + amount + " liters of " + fuelType);
    }
}
