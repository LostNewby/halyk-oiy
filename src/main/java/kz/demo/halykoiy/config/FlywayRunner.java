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
        flyway.repair();  // Recreates the schema history table
        flyway.migrate(); // Runs the migrations

    }
}
