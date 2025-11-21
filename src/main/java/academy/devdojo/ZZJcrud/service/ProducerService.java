package academy.devdojo.ZZJcrud.service;

import academy.devdojo.ZZJcrud.dominio.Producer;
import academy.devdojo.ZZJcrud.repository.ProducerRepository;

import java.util.List;
import java.util.Scanner;

public class ProducerService {
    private static Scanner scanner = new Scanner(System.in);

    public static void buildMenu(int op) {
        switch (op) {
            case 1: findByName();break;
            default: throw new IllegalArgumentException("Not a valid option");
        }
    }

    public static void findByName () {
        System.out.println("Type the name you want to search");
        String name = scanner.nextLine();
        List<Producer> producers = ProducerRepository.findByName(name);
        for (int i = 0; i < producers.size(); i++) {
            System.out.printf("[%d] - %s%n",i, producers.get(i).getName());

        }
    }
}
