package academy.devdojo.ZZijdbc.service;

import academy.devdojo.ZZijdbc.dominio.Producer;
import academy.devdojo.ZZijdbc.repository.ProducerRepository;

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
}
