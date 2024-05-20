package efub.toyProject.X;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class XApplication {

	public static void main(String[] args) {
		SpringApplication.run(XApplication.class, args);
	}

}
