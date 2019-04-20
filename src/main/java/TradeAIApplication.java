import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.iampravo.project.tradeAi")
public class TradeAIApplication {

    public static void main(String... args) {
        SpringApplication.run(TradeAIApplication.class, args);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
}
