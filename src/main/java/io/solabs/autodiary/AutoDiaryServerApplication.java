package io.solabs.autodiary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("io.solabs")
@SpringBootApplication
public class AutoDiaryServerApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(AutoDiaryServerApplication.class, args);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
