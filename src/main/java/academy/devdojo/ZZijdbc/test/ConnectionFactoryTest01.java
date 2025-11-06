package academy.devdojo.ZZijdbc.test;

import academy.devdojo.ZZijdbc.conn.ConnectionFactory;
import academy.devdojo.ZZijdbc.dominio.Producer;
import academy.devdojo.ZZijdbc.repository.ProducerRepository;

public class ConnectionFactoryTest01 {
    public static void main(String[] args) {
        Producer producer = Producer.ProducerBuilder.builder()
                .name("NHK")
                .build();
        ProducerRepository.save(producer);
    }
}
