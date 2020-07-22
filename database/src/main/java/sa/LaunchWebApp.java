package sa;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"sa.jpa"})
@EntityScan(basePackages = {"sa"})
@ComponentScan(basePackages = {"sa"})
public class LaunchWebApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(LaunchWebApp.class, args);
        //context.close();
    }
}
