package customers;

public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;
	private EmailSender emailSender;


	public void addCustomer(String name, String email, String street,
			String city, String zip) {
		Customer customer = new Customer(name, email);
		Address address = new Address(street, city, zip);
		customer.setAddress(address);
		customerRepository.save(customer);
		emailSender.sendEmail(email, "Welcome " + name + " as a new customer");
	}

	//Setter Injection
	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	public void setEmailSender(EmailSender emailSender) {
		this.emailSender = emailSender;
	}


}
