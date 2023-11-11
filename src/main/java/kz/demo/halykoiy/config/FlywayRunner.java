package kz.demo.halykoiy.config;

import lombok.AllArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class FlywayRunner implements CommandLineRunner {

    private final Flyway flyway;
    private final JdbcTemplate jdbcTemplate;

    public FlywayRunner(Flyway flyway, JdbcTemplate jdbcTemplate) {
        this.flyway = flyway;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        jdbcTemplate.execute("DROP TABLE IF EXISTS public.flyway_schema_history");
        String sql = "CREATE TABLE IF NOT EXISTS \"public\".\"flyway_schema_history\" (" +
                "    \"installed_rank\" INT NOT NULL," +
                "    \"version\" VARCHAR(50)," +
                "    \"description\" VARCHAR(200) NOT NULL," +
                "    \"type\" VARCHAR(20) NOT NULL," +
                "    \"script\" VARCHAR(1000) NOT NULL," +
                "    \"checksum\" INT," +
                "    \"installed_by\" VARCHAR(100) NOT NULL," +
                "    \"installed_on\" TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP," +
                "    \"execution_time\" INT NOT NULL," +
                "    \"success\" BOOLEAN NOT NULL," +
                "    CONSTRAINT \"flyway_schema_history_pk\" PRIMARY KEY (\"installed_rank\")" +
                ");";
        jdbcTemplate.execute(sql);
        flyway.migrate(); // Runs the migrations

    }
}
