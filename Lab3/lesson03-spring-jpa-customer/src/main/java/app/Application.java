package app;

import domain.Book;
import domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repository.BookRepository;
import repository.CustomerRepository;

import java.util.Optional;

@SpringBootApplication
@EnableJpaRepositories("repository")
@EntityScan("domain") 
public class Application implements CommandLineRunner{
	
	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerRepository.save(new Customer("Jack", "Bauer", "jack@acme.com"));
		customerRepository.save(new Customer("Chloe", "O'Brian", "chloe@acme.com"));
		customerRepository.save(new Customer("Kim", "Bauer", "kim@acme.com"));
		customerRepository.save(new Customer("David", "Palmer", "dpalmer@gmail.com"));
		customerRepository.save(new Customer("Michelle", "Dessler", "mich@hotmail.com"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : customerRepository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer by ID
		Optional<Customer> custOpt = customerRepository.findById(1L);
		Customer customer = custOpt.get();
		System.out.println("Customer found with findOne(1L):");
		System.out.println("--------------------------------");
		System.out.println(customer);
		System.out.println();

		//Create 3 new books and save them into DB
		Book book1 = new Book("Book 1 Life", "111", "John Teo", 450.0);
		Book book2 = new Book("Book 2 Life", "222", "Hally Dept", 300.0);
		Book book3 = new Book("Book 3 Life", "333", "Jenifer Cull", 190.0);

		bookRepository.save(book1);
		bookRepository.save(book2);
		bookRepository.save(book3);
		//Retrieve all books from the database and display them in the console
		System.out.println("Books found with findAll():");
		System.out.println("-------------------------------");
		for (Book book : bookRepository.findAll()) {
			System.out.println(book);
		}
		System.out.println();

		//Update a book
		book1.setTitle("If I change");
		bookRepository.save(book1);

		//Delete a book (not the book that was just updated)
		bookRepository.delete(book2);

		//Retrieve all books from the database again and display them in the console
		System.out.println("List of books after updated");
		System.out.println("-------------------------------");
		for (Book book : bookRepository.findAll()) {
			System.out.println(book);
		}
		System.out.println();

	}

}
