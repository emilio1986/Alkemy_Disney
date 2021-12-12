package alkemy.Disney2.Disney2;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@ComponentScan(basePackages = {"alkemy.Disney2.Disney2.repository.specifications"})      COMPILA CON EL SCAN PERO NO TRAE DATA
@SpringBootApplication
public class Disney2Application {

	public static void main(String[] args) {
		SpringApplication.run(Disney2Application.class, args);
	}

}
