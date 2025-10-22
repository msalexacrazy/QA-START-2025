package org.prog.session3.phones;

import org.prog.session3.poly.ICar;

//TODO: Add interface ICamera for phones to take photos. Implement in Adnroid and iPhoine
//TODO: take two photos :)

public class Homework {
    public static void photo(InterfacePhone googlePixel) {
        googlePixel.takePhotos(0);
        googlePixel.takePhotos(1);
        googlePixel.takePhotos(2);
        googlePixel.takePhotos(3);
    }

    public static void main(String[] args) {
        AndroidPhone googlePixel = new AndroidPhone();
        IPhone myIPhone = new IPhone();
        IPhoneProMax myIPhoneProMax = new IPhoneProMax();

        photo(googlePixel);
        photo(myIPhone);
        photo(myIPhoneProMax);
    }
}
