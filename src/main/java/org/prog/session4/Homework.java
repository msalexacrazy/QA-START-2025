package org.prog.session4;

import org.prog.session1.HomeworkCar;

public class Homework {
    public static void main(String[] args) {
        HomeworkCar myCar1 = new HomeworkCar();
        myCar1.color = "blue";
        myCar1.model = "Audi";

        HomeworkCar myCar2 = new HomeworkCar();
        myCar2.color = "black";
        myCar2.model = "BMW";

        HomeworkCar myCar3 = new HomeworkCar();
        myCar3.color = "blue";
        myCar3.model = "Audi";

        HomeworkCar myCar4 = new HomeworkCar();
        myCar4.color = "black";
        myCar4.model = "Audi";

        HomeworkCar myCar5 = new HomeworkCar();
        myCar5.color = "blue";
        myCar5.model = "BMW";

        System.out.println(myCar1.equals(myCar2));
        System.out.println(myCar1.equals(myCar3));
        System.out.println(myCar1.equals(myCar4));
        System.out.println(myCar1.equals(myCar5));

        System.out.println(myCar1.hashCode());
        System.out.println(myCar2.hashCode());
        System.out.println(myCar3.hashCode());
        System.out.println(myCar4.hashCode());
        System.out.println(myCar5.hashCode());
    }
}
