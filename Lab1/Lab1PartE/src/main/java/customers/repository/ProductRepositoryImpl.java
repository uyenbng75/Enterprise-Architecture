package customers.repository;

import customers.Logger;
import customers.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

    @Autowired
    private Logger logger;

    public void save(Product product) {
        try {
            Thread.sleep(350);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ProductRepository: Save new product "+ product.getName());
        logger.log("Product is saved in the DB: "+ product.getName() );
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
