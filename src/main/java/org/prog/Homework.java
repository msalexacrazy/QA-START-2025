package org.prog;
//TODO: Add second car, make it blue, make red car got to Kyiv, blue car go to Odessa

public class Homework {
    public static void main(String[] args) {
        Car firstCar = new Car();
        Car secondCar = new Car();

        firstCar.color = "red";
        secondCar.color = "blue";

        firstCar.goTo("Kyiv");
        secondCar.goTo("Odessa");
    }

}
