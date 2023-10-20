package th.co.pt.ptgapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan(basePackages = "th.co.pt")
@SpringBootApplication
@EnableScheduling
public class PtgappApplication {

   public static void main(String[] args) {
        SpringApplication.run(PtgappApplication.class, args);
    }
//   public static void main(String[] args) throws Exception {
//       SpringApplication.run(PtgappApplication.class, args);
//   }
}
