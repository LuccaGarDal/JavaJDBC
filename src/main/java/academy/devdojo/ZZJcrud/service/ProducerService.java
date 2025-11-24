package academy.devdojo.ZZJcrud.service;

import academy.devdojo.ZZJcrud.dominio.Producer;
import academy.devdojo.ZZJcrud.repository.ProducerRepository;

import java.util.Optional;
import java.util.Scanner;

public class ProducerService {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void menu(int op) {
        switch (op) {
            case 1 -> findByName();
            case 2 -> delete();
            case 3 -> save();
            case 4 -> update();
            default -> throw new IllegalArgumentException("Not a valid option");
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
        System.out.println("Are you sure? Y/N");
        String choice = SCANNER.nextLine();
        if ("y".equalsIgnoreCase(choice)) {
            ProducerRepository.delete(id);
        }
    }

    public static void save() {
        System.out.println("Type the name of the producer");
        String name = SCANNER.nextLine();
        Producer producer = Producer.builder().name(name).build();
        ProducerRepository.save(producer);
    }

    public static void update () {
        System.out.println("Type the id of the object you want to update");
        int id = Integer.parseInt(SCANNER.nextLine());
        Optional<Producer> producerOptional = ProducerRepository.findById(id);
        if (producerOptional.isEmpty()) {
            System.out.println("Producer not found");
            return;
        }
        Producer producerFromDB = producerOptional.get();
        System.out.println("Producer found " + producerFromDB);
        System.out.println("Type the new name or enter to keep the same");
        String name = SCANNER.nextLine();
        name = name.isEmpty() ? producerFromDB.getName() : name;

        Producer producerToUpdate = Producer
                .builder()
                .id(producerFromDB.getId())
                .name(name)
                .build();

        ProducerRepository.update(producerToUpdate);
    }


}
