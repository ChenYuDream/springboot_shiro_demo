package org.jypj.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

/**
 * @author ChenYu
 */
@SpringBootApplication
public class SpringbootShiroDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootShiroDemoApplication.class, args);
    }
}
