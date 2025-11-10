package academy.devdojo.ZZijdbc.test;

import academy.devdojo.ZZijdbc.conn.ConnectionFactory;
import academy.devdojo.ZZijdbc.dominio.Producer;
import academy.devdojo.ZZijdbc.repository.ProducerRepository;
import academy.devdojo.ZZijdbc.service.ProducerService;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class ConnectionFactoryTest01 {
    public static void main(String[] args) {
        Producer producer = Producer.builder().name("Studio Deen").build();
        Producer producer1 = Producer.builder().id(1).name("MADHOUSE").build();
        Producer producer2 = Producer.builder().id(2).name("NhK").build();
//        ProducerService.save(producer);
//        ProducerService.delete(13);
//        ProducerService.update(producer1);
        List<Producer> producers = ProducerService.findByName("deen");
        log.info("Producers found {}",producers);
        List<Producer> producers1 = ProducerService.findAll();
        log.info("Producers found {}",producers1);



    }
}
