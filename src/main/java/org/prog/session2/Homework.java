package org.prog.session2;

public class Homework {
    public static void main(String[] args) {
        CarService carService = new CarService();
        Car myCar = new Car();

        myCar.color = "blue";
        carService.polishСar(myCar);
    }
}
