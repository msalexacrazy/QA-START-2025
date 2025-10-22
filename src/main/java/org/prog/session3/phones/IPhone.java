package org.prog.session3.phones;

public class IPhone extends Phone implements InterfacePhone {

    @Override
    public void call(String subscriber) {
        System.out.println("Iphone calling " + subscriber);
    }

    @Override
    public void takePhotos(int countPhotos) {
        if (countPhotos <= 0) {
            System.out.println("Cool iPhone photo not taken");
        }

        for (int i = 1; i <= countPhotos; i++) {
            System.out.println("Cool iPhone photo taken");
        }

        System.out.println("Total number of cool iPhone photo " + countPhotos);
        System.out.println("===========================================");
    }

    @Override
    public void settings() {

    }
};
