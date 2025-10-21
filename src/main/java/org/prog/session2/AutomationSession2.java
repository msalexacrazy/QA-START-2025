package org.prog.session2;

public class AutomationSession2 {

    /**
     * ####Car2.brand=Mazda##################
     * #####[car1]###########################
     * ######################################
     * ###########[car2]#####################
     * #################[]###################
     * ######################################
     * ################[car3]################
     * ########[carService]##################
     *
     * @param args
     */

    public static void main(String[] args) {
        System.out.println(Car.brand);
        //Type verName =
//        int j = 10;
        CarService carService = new CarService();

        String s1 = "something";
        String s2 = "";
        String s3 = null;
        System.out.println(s1.length());
        System.out.println(s2.length());
//        System.out.println(s3.length());

        Car aliceCar = new Car();
        Car myWifesCar = aliceCar;

//        carService.paintCar(aliceCar, null);
//        System.out.println("Alice: " + aliceCar.color);
//        System.out.println("My Wife's Car: " + myWifesCar.color);

        carService.paintCar(myWifesCar, "black");

        System.out.println("Alice: " + aliceCar.color);
        System.out.println("My Wife's Car: " + myWifesCar.color);
    }

    public static void smth(int i) {
        i += 1000;
        System.out.println("i " + i);
    }
}
