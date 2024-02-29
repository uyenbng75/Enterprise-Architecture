package customers;

import customers.service.CustomerService;
import customers.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Application {
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		CustomerService customerService = context.getBean("customerServiceImpl",
				CustomerService.class);

		customerService.addCustomer("Frank Brown", "fbrown@acme.com",
				"mainstreet 5", "Chicago", "60613");

		//-------
		System.out.println("-------");

		ProductService productService = context.getBean("productServiceImpl",
				ProductService.class);

		productService.addProduct("Macbook M3 Pro", 1999.00, "productemail@acme.com");

	}
}

