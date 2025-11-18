package academy.devdojo.ZZijdbc.test;

import academy.devdojo.ZZijdbc.dominio.Producer;
import academy.devdojo.ZZijdbc.service.ProducerServiceRowSet;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class ConnectionFactoryTest02 {
    public static void main(String[] args) {
        List<Producer> producers = ProducerServiceRowSet.findByNameJdbcRowSet("NHK");
        log.info("Producers found '{}'", producers);
    }
}
