package in.handyman.chidori;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ChidoriApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChidoriApplication.class, args);
    }

}
