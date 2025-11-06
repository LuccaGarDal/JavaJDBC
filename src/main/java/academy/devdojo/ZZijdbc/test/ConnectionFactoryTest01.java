package academy.devdojo.ZZijdbc.test;

import academy.devdojo.ZZijdbc.conn.ConnectionFactory;
import academy.devdojo.ZZijdbc.dominio.Producer;
import academy.devdojo.ZZijdbc.repository.ProducerRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ConnectionFactoryTest01 {
    public static void main(String[] args) {
        Producer producer = Producer.builder().name("Studio Deen").build();
        ProducerRepository.save(producer);
//        log.info("info");
//        log.warn("warn");
//        log.debug("debug");
//        log.error("error");
//        log.trace("trace");
    }
}
