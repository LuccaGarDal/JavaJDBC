package academy.devdojo.ZZJcrud.test;

import academy.devdojo.ZZJcrud.service.AnimeService;
import academy.devdojo.ZZJcrud.service.ProducerService;

import java.util.Scanner;

public class CrudTest01 {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int opt;
        while (true) {
            menu();
            String string = SCANNER.nextLine();
            opt = Integer.parseInt(string);
            if (opt == 0) {
                break;
            }
            switch (opt) {
                case 1 -> {
                    producerMenu();
                    int op = Integer.parseInt(SCANNER.nextLine());
                    ProducerService.menu(op);
                }
                case 2 -> {
                    animeMenu();
                    int op = Integer.parseInt(SCANNER.nextLine());
                    AnimeService.menu(op);
                }
            }

        }

    }

    private static void menu() {
        System.out.println("Type the number of your option");
        System.out.println("1 - Producer");
        System.out.println("2 - Anime");
        System.out.println("0 - Exit");
    }

    private static void producerMenu () {
        System.out.println("Type the number of your option");
        System.out.println("1 - Search for producer");
        System.out.println("2 - Delete producer");
        System.out.println("3 - Save producer");
        System.out.println("4 - Update producer");
        System.out.println("9 - Go back");
    }

    private static void animeMenu () {
        System.out.println("Type the number of your option");
        System.out.println("1 - Search for anime");
        System.out.println("2 - Delete anime");
        System.out.println("3 - Save anime");
        System.out.println("4 - Update anime");
        System.out.println("9 - Go back");
    }
}
