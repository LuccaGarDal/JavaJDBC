package academy.devdojo.ZZJcrud.service;

import academy.devdojo.ZZJcrud.dominio.Anime;
import academy.devdojo.ZZJcrud.dominio.Producer;
import academy.devdojo.ZZJcrud.repository.AnimeRepository;

import java.util.Optional;
import java.util.Scanner;

public class AnimeService {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void menu(int op) {
        switch (op) {
            case 1 -> findByName();
            case 2 -> delete();
            case 3 -> save();
            case 4 -> update();
        }
    }

    public static void findByName() {
        System.out.println("Type the name you want to search");
        String name = SCANNER.nextLine();
        AnimeRepository.findByName(name)
                .forEach(anime -> System.out.printf("[%d] - %s %d %s%n", anime.getId(), anime.getName(), anime.getEpisodes(), anime.getProducer().getName()));

    }

    public static void delete() {
        System.out.println("Type the id of the anime you want to delete");
        int id = Integer.parseInt(SCANNER.nextLine());
        System.out.println("Are you sure? Y/N");
        String choice = SCANNER.nextLine();
        if ("y".equalsIgnoreCase(choice)) {
            AnimeRepository.delete(id);
        }
    }

    public static void save() {
        System.out.println("Type the name of the anime");
        String name = SCANNER.nextLine();
        System.out.println("Type the number of episodes");
        int episodes = Integer.parseInt(SCANNER.nextLine());
        System.out.println("Type the id of the producer");
        Integer producerId = Integer.parseInt(SCANNER.nextLine());
        Anime anime = Anime
                .builder()
                .name(name)
                .episodes(episodes)
                .producer(Producer.builder().id(producerId).build())
                .build();
        AnimeRepository.save(anime);
    }

    public static void update () {
        System.out.println("Type the id of the object you want to update");
        int id = Integer.parseInt(SCANNER.nextLine());
        Optional<Anime> animeOptional = AnimeRepository.findById(id);
        if (animeOptional.isEmpty()) {
            System.out.println("Anime not found");
            return;
        }
        Anime animeFromDB = animeOptional.get();
        System.out.println("Anime found " + animeFromDB);
        System.out.println("Type the new name or enter to keep the same");
        String name = SCANNER.nextLine();
        name = name.isEmpty() ? animeFromDB.getName() : name;

        System.out.println("Type the new number");
        int episodes = Integer.parseInt(SCANNER.nextLine());

        Anime animeToUpdate = Anime
                .builder()
                .id(animeFromDB.getId())
                .episodes(episodes)
                .producer(animeFromDB.getProducer())
                .name(name)
                .build();

        AnimeRepository.update(animeToUpdate);
    }


}
