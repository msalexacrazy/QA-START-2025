import java.util.Random;

public class homework {
    public static void main(String[] args) {

        int[] hotelRooms = new int[15];
        Random rand = new Random();

        for (int i = 0; i < hotelRooms.length; i++) {
            hotelRooms[i] = rand.nextInt(25);
        }

        //1. ми не знаємо скільки разів ми будем пробігати масивом
        //2. ми знаємо, що масив відсортовано тоді, коли ми не поміняли місцями жодних двох елементів
        //3. елементи порівнюються попарно, почнаючи з індексу 1, і "озираючись" назад. Тобто 1 і 0, 2 і 1
        //4. якщо поточний елемент менший за попередній, поміняти їх місцями
        //5. ДЗ в тому, щоб починати сортування з нульового елементу, а не з першого

        boolean unsorted = hotelRooms.length > 1;

        while (unsorted) {

            for (int i = 0; i < hotelRooms.length; i++) {
                System.out.print(hotelRooms[i] + ",");
            }

            boolean elementsSwitched = false;

            for (int i = 0; i < (hotelRooms.length - 1); i++) {

                int currentElement = hotelRooms[i];
                int nextElement = hotelRooms[i + 1];

                if (currentElement > nextElement) {
                    elementsSwitched = true;
                    unsorted = true;
                    hotelRooms[i] = nextElement;
                    hotelRooms[i + 1] = currentElement;
                }

                if (!elementsSwitched) {
                    unsorted = false;
                }
            }
            System.out.println();
        }
    }
}
