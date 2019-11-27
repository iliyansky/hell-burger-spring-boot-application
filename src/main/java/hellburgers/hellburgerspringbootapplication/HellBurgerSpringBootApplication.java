package hellburgers.hellburgerspringbootapplication;

import hellburgers.hellburgerspringbootapplication.entities.Burger;
import hellburgers.hellburgerspringbootapplication.entities.Meat;
import hellburgers.hellburgerspringbootapplication.repositories.BurgerRepository;
import hellburgers.hellburgerspringbootapplication.repositories.MeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

@SpringBootApplication
public class HellBurgerSpringBootApplication extends SpringBootServletInitializer {



    public static void main(String[] args) {
        SpringApplication.run(HellBurgerSpringBootApplication.class, args);


    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(HellBurgerSpringBootApplication.class);
    }

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/HellBurgers");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
    }
}
