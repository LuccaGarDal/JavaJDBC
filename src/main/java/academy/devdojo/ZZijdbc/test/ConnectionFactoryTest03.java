package academy.devdojo.ZZijdbc.test;

import academy.devdojo.ZZijdbc.dominio.Producer;
import academy.devdojo.ZZijdbc.service.ProducerService;

import java.util.List;

public class ConnectionFactoryTest03 {
    public static void main(String[] args) {
        Producer producer1 = Producer.builder().name("Studio Ghibli").build();
        Producer producer2 = Producer.builder().name("White fox").build();
        Producer producer3 = Producer.builder().name("Toei animation").build();
        ProducerService.saveTransaction(List.of(producer1, producer2, producer3));
    }
}
