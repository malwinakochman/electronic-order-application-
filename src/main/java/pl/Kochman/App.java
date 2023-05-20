package pl.Kochman;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.Kochman.productCatalog.HashMapProductStorage;
import pl.Kochman.productCatalog.ProductCatalog;

import java.util.Collections;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(App.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "9090"));
        app.run(args);
    }


}
