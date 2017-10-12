import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        String fileName = "test.txt";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj ilość liczb  do wprowadzenia: ");
        int arraySize = scanner.nextInt();
        int[] array = new int[arraySize];

        try (FileWriter fileWriter = new FileWriter(fileName);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {
            for (int temp = 0; temp < array.length; temp++) {
                System.out.println("Podaj liczbę nr:" + (temp + 1));
                array[temp] = scanner.nextInt();

                writer.write(Integer.toString(array[temp]));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader reader = new BufferedReader(fileReader)) {
            String row = null;
            int rowNumber = 1;

            while ((row = reader.readLine()) != null) {
                System.out.println(row);
                rowNumber++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
