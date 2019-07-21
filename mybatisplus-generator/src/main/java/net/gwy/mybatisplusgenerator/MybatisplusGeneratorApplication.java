package net.gwy.mybatisplusgenerator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@MapperScan("net.gwy.mybatisplusgenerator.mapper")
public class MybatisplusGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisplusGeneratorApplication.class, args);
    }

}
