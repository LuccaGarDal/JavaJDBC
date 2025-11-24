package academy.devdojo.ZZJcrud.service;

import academy.devdojo.ZZJcrud.dominio.Producer;
import academy.devdojo.ZZJcrud.repository.ProducerRepository;

import java.util.List;
import java.util.Scanner;

public class ProducerService {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void menu(int op) {
        switch (op) {
            case 1:
                findByName();
                break;
            case 2:
                delete();
                break;
            default:
                throw new IllegalArgumentException("Not a valid option");
        }
    }

    public static void findByName() {
        System.out.println("Type the name you want to search");
        String name = SCANNER.nextLine();
        ProducerRepository.findByName(name)
                .forEach(producer -> System.out.printf("[%d] - %s%n", producer.getId(), producer.getName()));

    }

    public static void delete() {
        System.out.println("Type the id of the producer you want to delete");
        int id = Integer.parseInt(SCANNER.nextLine());
        System.out.println("Are you sure? S/N");
        String choice = SCANNER.nextLine();
        if ("s".equalsIgnoreCase(choice)) {
            ProducerRepository.delete(id);
        }
    }
}
