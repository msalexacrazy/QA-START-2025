import java.io.*;

//TODO: reverse this string: "this string will be reversed"
public class Homework {

    public static void main(String[] args) throws IOException {
        File valueTxtFile = new File("src/main/resources/values.txt");
        BufferedReader br = new BufferedReader(new FileReader(valueTxtFile));

        String line;
        String lastLine = null;

        while ((line = br.readLine()) != null) {
            lastLine = line;
        }

        System.out.println("Останній рядок файла: " + lastLine);

        char[] charsLastLine = lastLine.toCharArray();
        char[] charsLastLineRevers = new char [charsLastLine.length];

        for (int count = 0; count < charsLastLine.length; count++) {
            charsLastLineRevers[count] = charsLastLine[(charsLastLine.length - 1) - count];
        }
        System.out.println(charsLastLineRevers);
    }
}

