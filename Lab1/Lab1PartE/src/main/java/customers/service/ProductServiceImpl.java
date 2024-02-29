package customers.service;

import customers.Product;
import customers.repository.CustomerRepository;
import customers.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    EmailSender emailSender;

    public void addProduct(String name, Double price, String email) {
        Product product = new Product(name, price, email);
        product.setName(name);
        product.setPrice(price);
        product.setEmail(email);
        productRepository.save(product);
        emailSender.sendEmail(email, "Add new product with name:" + name + " and price: " + price);
    }

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void setEmailSender(EmailSender emailSender) {
        this.emailSender = emailSender;
    }
}
