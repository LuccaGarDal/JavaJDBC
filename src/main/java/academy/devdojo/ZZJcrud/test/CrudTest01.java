package academy.devdojo.ZZJcrud.test;

import academy.devdojo.ZZJcrud.service.ProducerService;

import java.util.Scanner;

public class CrudTest01 {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int opt;
        while (true) {
            producerMenu();
            String string = SCANNER.nextLine();
            opt = Integer.parseInt(string);
            if (opt == 0) {
                break;
            }
            ProducerService.menu(opt);

        }

    }

    private static void producerMenu () {
        System.out.println("Type the number of your option");
        System.out.println("1 - Search for producer");
        System.out.println("2 - Delete producer");
        System.out.println("0 - Exit");
    }
}
