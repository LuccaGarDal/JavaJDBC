package academy.devdojo.ZZijdbc.repository;

import academy.devdojo.ZZijdbc.conn.ConnectionFactory;
import academy.devdojo.ZZijdbc.dominio.Producer;
import academy.devdojo.ZZijdbc.listener.CustomRowSetListener;

import javax.sql.rowset.JdbcRowSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProducerRepositoryRowSet {

    public static List<Producer> findByNameJdbcRowSet (String name) {
        String sql = "SELECT * from anime_store.producer WHERE name like ?;";
        List<Producer> producers = new ArrayList<>();
        try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()) {
            jrs.addRowSetListener(new CustomRowSetListener());
            jrs.setCommand(sql);
            jrs.setString(1, String.format("%%%s%%", name));
            jrs.execute();
            while(jrs.next()) {
                Producer producer = Producer.builder()
                        .name(jrs.getString("name"))
                        .id(jrs.getInt("id"))
                        .build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return producers;
    }

    public static void updateJdbcRowSet (Producer producer) {
        String sql = "SELECT * FROM anime_store.producer WHERE (id = ?);";
        try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()) {
            jrs.addRowSetListener(new CustomRowSetListener());
            jrs.setCommand(sql);
            jrs.setInt(1, producer.getId());
            jrs.execute();
            if (!jrs.next()) return;
            jrs.updateString("name", producer.getName());
            jrs.updateRow();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
