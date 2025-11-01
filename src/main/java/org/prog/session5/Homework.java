package org.prog.session5;

import java.sql.Array;
import java.util.*;

//TODO: write Map with car owners as keys and owned cars as values
//TODO: assign each car random color using randomColor() from this class

public class Homework {
    public static void main(String[] args) {
        Map<String, List<HomeworkCar>> mapCarOwner = new HashMap<>();

        String[] owners = new String[]{"Anton", "Sveta", "Serg", "Nina", "Sasha"};

        for (String owner : owners) {
            mapCarOwner.put(owner, new ArrayList<>());
            List<HomeworkCar> cars = mapCarOwner.get(owner);
            Random random = new Random();
            int carsCount = random.nextInt(5) + 1;

            for (int i = 0; i < carsCount; i++) {
                HomeworkCar car = new HomeworkCar();
                car.color = HomeworkCar.randomColor();
                cars.add(car);
            }
        }

        for (int i = 0; i < owners.length; i++) {
            String owner = owners[i];
            List<HomeworkCar> cars = mapCarOwner.get(owner);

            System.out.println("Owner " + owner + " has cars:");
            for (int j = 0; j < cars.size(); j++) {
                HomeworkCar car = cars.get(j);
                System.out.println("   - color: " + car.color);
            }
        }
    }
}

