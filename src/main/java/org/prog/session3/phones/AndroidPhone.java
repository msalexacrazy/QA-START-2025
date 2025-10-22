package org.prog.session3.phones;

public class AndroidPhone extends Phone implements InterfacePhone {

    @Override
    public void takePhotos(int countPhotos) {
        if (countPhotos <= 0) {
            System.out.println("Photo not taken");
        }

        for (int i = 1; i <= countPhotos; i++) {
            System.out.println("Photo taken");
        }

        System.out.println("Total number of photos taken " + countPhotos);
        System.out.println("===========================================");
    }

    @Override
    public void settings() {

    }
}
