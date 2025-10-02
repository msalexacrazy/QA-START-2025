import java.io.*;

public class Test {

    public static void main(String[] args) throws IOException {
        File valueTxtFile = new File("src/main/resources/values.txt");
        System.out.println(valueTxtFile.exists());

        BufferedReader br = new BufferedReader(new FileReader(valueTxtFile));

        String line;
        do {
            line = br.readLine();
            System.out.println(line);
        } while (line != null);

        boolean flag1 = true;
        boolean flag2 = true;

        while ((line = br.readLine()) != null) {
            switch (line) {
                case "VALUE_1":
                    System.out.println("Value 1 found!");
                    break;
                case "VALUE_2":
                    System.out.println("Value 2 found!");
                    break;
                case "VALUE_3":
                    System.out.println("Value 3 found!");
                    break;
                default:
                    System.out.println("Default value!");
            }
        }
    }
}

