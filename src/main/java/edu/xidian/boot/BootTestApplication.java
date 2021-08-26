package edu.xidian.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@SpringBootApplication
@MapperScan("edu.xidian.boot.dao")
public class BootTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootTestApplication.class, args);
    }

}
