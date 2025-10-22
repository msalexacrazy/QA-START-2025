package org.prog.session3.poly;

//TODO: write overloaded drive to to contain:
//TODO: - amount of passengers  def: 0
//TODO: - is payment for gas split def: no

public class Homework {
    public static void main(String[] args) {
        Renault renault = new Renault();

        renault.driveTo("Kyiv");
        System.out.println("===================================");
        renault.driveTo("Lviv", "Odessa");
        System.out.println("===================================");
        renault.driveTo("Lviv", "Odessa", "Dnipro");
        System.out.println("===================================");
        renault.driveTo("Lviv", "Odessa", "Dnipro", 2);
        System.out.println("===================================");
        renault.driveTo("Lviv", "Odessa", "Dnipro", 2, "yes");
    }
}
