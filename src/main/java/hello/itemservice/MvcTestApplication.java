package hello.itemservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("hello.itemservice.domain.item.repository")
public class MvcTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MvcTestApplication.class, args);
    }

}
