package customers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Lab2PartAApplication {

	public static void main(String[] args) {
		//SpringApplication.run(Lab2PartAApplication.class, args);

		ApplicationContext context = new AnnotationConfigApplicationContext(
				SpringApplication.class);

		CustomerService customerService = context.getBean("customerServiceImpl",
				CustomerService.class);

		customerService.addCustomer("Frank Brown", "fbrown@acme.com",
				"mainstreet 5", "Chicago", "60613");
	}

}
