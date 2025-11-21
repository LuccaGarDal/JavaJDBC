package academy.devdojo.ZZJcrud.test;

import academy.devdojo.ZZJcrud.service.ProducerService;

import java.util.Scanner;

public class CrudTest01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opt;
        while (true) {
            producerMenu();
            String string = scanner.nextLine();
            opt = Integer.parseInt(string);
            if (opt == 0) {
                break;
            }
            ProducerService.buildMenu(opt);

        }

    }

    private static void producerMenu () {
        System.out.println("Type the number of your option");
        System.out.println("1 - Search for producer");
        System.out.println("0 - Exit");
    }
}
