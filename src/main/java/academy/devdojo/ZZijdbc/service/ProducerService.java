package academy.devdojo.ZZijdbc.service;

import academy.devdojo.ZZijdbc.dominio.Producer;
import academy.devdojo.ZZijdbc.repository.ProducerRepository;

import java.util.List;

public class ProducerService {
    public static void save (Producer producer) {
        ProducerRepository.save(producer);
    }

    public static void delete(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid value for id");
        }
        ProducerRepository.delete(id);
    }

    public static void update (Producer producer) {
        requireValidId(producer.getId());
        ProducerRepository.update(producer);
    }

    private static void requireValidId (Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid valur for id");
        }
    }

    public static List<Producer> findAll () {
        return ProducerRepository.findAll();
    }

    public static List<Producer> findByName (String name) {
        return ProducerRepository.findByName(name);
    }

    public static void showProducerMetaData() {
        ProducerRepository.showProducerMetaData();
    }

    public static void showDriverMetaData () {
        ProducerRepository.showDriverMetaData();
    }

    public static void showTypeScrollWorking () {
        ProducerRepository.showTypeScrollWorking();
    }

    public static List<Producer> findByNameAndUpdateToUpperCase (String name) {
        return ProducerRepository.findByNameAndUpdateToUpperCase(name);
    }



}
