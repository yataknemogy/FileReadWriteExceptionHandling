import java.io.*;
import java.util.Scanner;

class FileHandler {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Выберите действие: ");
            System.out.println("1. Чтение текста из файла");
            System.out.println("2. Запись текста в файл");
            System.out.println("3. Завершить программу");
            int chooseInput = scanner.nextInt();
            scanner.nextLine();
            switch (chooseInput){
                case 1:
                    readFromFile(scanner);
                    break;
                case 2:
                    writeToFile(scanner);
                    break;
                case 3:
                    System.out.println("Программа завершена");
                    return;
                default:
                    System.err.println("Неверный выбор, попробуйте еще раз");
            }
        }

    }
    public static void readFromFile(Scanner scanner){
        System.out.println("Введите имя файла для чтения");
        String nameFile = scanner.nextLine();
        try(BufferedReader reader = new BufferedReader(new FileReader(nameFile))){
            String line;
            System.out.println("Содержимое файла");
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeToFile(Scanner scanner){
        System.out.println("Введите имя файла для записи");
        String fileName = scanner.nextLine();
        System.out.println("Введите текст для файла");
        String fileText = scanner.nextLine();
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            writer.write(fileText);
            System.out.println("Текст был успешно записан!");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
