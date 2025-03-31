package clonecoding.velog_clone;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "clonecoding.velog_clone.mapper")
public class VelogCloneApplication {

    public static void main(String[] args) {
        SpringApplication.run(VelogCloneApplication.class, args);
    }

}
