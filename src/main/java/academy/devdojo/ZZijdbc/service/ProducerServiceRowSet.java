package academy.devdojo.ZZijdbc.service;

import academy.devdojo.ZZijdbc.dominio.Producer;
import academy.devdojo.ZZijdbc.repository.ProducerRepositoryRowSet;

import java.util.List;

public class ProducerServiceRowSet {

    public static List<Producer> findByNameJdbcRowSet (String name) {
        return ProducerRepositoryRowSet.findByNameJdbcRowSet(name);
    }

    public static void updateJdbcRowSet (Producer producer) {
        ProducerRepositoryRowSet.updateJdbcRowSet(producer);
    }
}
