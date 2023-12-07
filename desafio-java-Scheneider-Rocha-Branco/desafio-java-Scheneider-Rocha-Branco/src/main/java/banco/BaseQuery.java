package banco;

import org.springframework.jdbc.core.JdbcTemplate;

public class BaseQuery {
    private JdbcTemplate connection;

    public BaseQuery(JdbcTemplate connection) {
        this.connection = connection;
    }

}
