package pl.Kochman;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.Kochman.productCatalog.HashMapProductStorage;
import pl.Kochman.productCatalog.ProductCatalog;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    ProductCatalog createProductCatalog() {
        return new ProductCatalog(new HashMapProductStorage());
    }
}
