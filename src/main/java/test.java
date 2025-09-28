//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class test {
    public static void main(String[] args) {
        float f1 = 10.0F;
        float f2 = 3.0F;
        System.out.print("Hello world!");
        System.out.println("Hello Java!");
        System.out.println("1");
        System.out.println(2);
        System.out.println(2);
        System.out.println(0);
        System.out.println(5);
        System.out.println(20);
        System.out.println(2);
        System.out.println(Math.round(Math.sin(Math.PI)));
        System.out.println(f1 / f2);
        System.out.println(6.6666665F);
        int i = 1;
        System.out.println(i);
        ++i;
        System.out.println(i);
        --i;
        System.out.println(i);
        i += 5;
        System.out.println(i);
        boolean b1 = true;
        boolean b2 = false;
        System.out.println(true);
        System.out.println(false);
        System.out.println(true);
        System.out.println(false);
        System.out.println(b1);
        System.out.println(!b1);
        boolean isTrue1 = true;
        boolean isTrue2 = true;
        boolean isFalse1 = false;
        boolean isFalse2 = false;
        System.out.println(isTrue1 && isTrue2);
        System.out.println(isFalse1 && isTrue2);
        System.out.println(isTrue1 && isFalse2);
        System.out.println(isFalse1 && isFalse2);
        System.out.println("--------------------------");
        System.out.println(isTrue1 || isTrue2);
        System.out.println(isFalse1 || isTrue2);
        System.out.println(isTrue1 || isFalse2);
        System.out.println(isFalse1 || isFalse2);
        System.out.println("--------------------------");
        int j = 20;
        System.out.println(j > 19);
        System.out.println(j < 19);
        System.out.println(j == 19);
        System.out.println(j != 19);
        System.out.println(j >= 19);
        System.out.println(j <= 19);
        int[] hotelRoom = new int[]{10, 12, 14, 16, 16, 17, 17, 17, 17, 17};
        System.out.println(hotelRoom[2]);
        String[] hotelRoomNames = new String[10];
        hotelRoomNames[0] = "Mivina";
        System.out.println(hotelRoomNames[0]);

        String[] hotelRoomsNames = new String[] {
                "Hotel Room 1","Hotel Room 2","Hotel Room 3","Hotel Room 4"
        };

        for ( int a = 0; a < hotelRoomsNames.length; a+=2) {
            System.out.println(hotelRoomsNames[a]);
        }

        for ( int b = hotelRoom.length - 1; b >= 0; b-=2) {
            System.out.println(hotelRoom[b]);
        }
    }
}
