import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kha2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> validNumbers = new ArrayList<>();
        int invalidCount = 0;

        System.out.println("Nhap danh sach chuoi (nhap 'exit' de ket thuc va xem ket qua):");

        while (true) {
            System.out.print("Nhap gia tri: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                int number = Integer.parseInt(input);
                validNumbers.add(number);

            } catch (NumberFormatException e) {
                invalidCount++;
                System.out.println("-> '" + input + "' khong phai so nguyen hop le.");
            }
        }

        System.out.println("--------------------------------");
        System.out.println("So chuoi hop le: " + validNumbers.size());
        System.out.println("So chuoi khong hop le: " + invalidCount);
        System.out.println("Danh sach so nguyen hop le: " + validNumbers);

        scanner.close();
    }
}