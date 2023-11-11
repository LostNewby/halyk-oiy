package kz.demo.halykoiy.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FlywayConfiguration {
    @Bean
    public Flyway flyway(DataSource dataSource) {
        Flyway flyway = Flyway.configure().baselineOnMigrate(true).dataSource(dataSource).load();
        return flyway;
    }
}