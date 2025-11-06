package org.prog.session6;

import org.testng.annotations.Test;
import java.util.*;

public class TestNG_Homework {

    public static class HomeworkCar {
        public String color;

        public static String randomColor() {
            Random random = new Random();
            return switch (random.nextInt(5)) {
                case 0 -> "red";
                case 1 -> "green";
                case 2 -> "blue";
                case 3 -> "yellow";
                case 4 -> "pink";
                default -> "black";
            };
        }
    }

    @Test
    public void testHomework() {
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

        for (String owner : owners) {
            List<HomeworkCar> cars = mapCarOwner.get(owner);
            System.out.println("Owner " + owner + " has cars:");
            for (HomeworkCar car : cars) {
                System.out.println("   - color: " + car.color);
            }
        }
    }
}
