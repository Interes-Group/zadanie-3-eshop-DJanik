package sk.stuba.fei.uim.oop.assignment3.product.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.data.IProductRepository;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.ProductRequest;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository repository;

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public Product create(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setAmount(request.getAmount());
        product.setUnit(request.getUnit());
        product.setPrice(request.getPrice());
        return this.repository.save(product);
    }

    @Override
    public Product getProduct(long id) throws NotFoundException {
        Product product = this.repository.findById(id);
        if (product == null) {
            throw new NotFoundException();
        }
        return product;
    }
    
    @Override
    public Product modifyProduct(long id, ProductRequest request) throws NotFoundException {
        Product product = this.getProduct(id);
        if (request.getName() != null) {
            product.setName(request.getName());
        }
        if (request.getDescription() != null) {
            product.setDescription(request.getDescription());
        }
        return this.repository.save(product);
    }

    @Override
    public void deleteProduct(long id) throws NotFoundException {
        this.repository.delete(this.getProduct(id));
    }

    @Override
    public long getAmount(long id) throws NotFoundException {
        return this.getProduct(id).getAmount();
    }

    @Override
    public long modifyAmount(long id, long amount) throws NotFoundException {
        Product product = this.getProduct(id);
        product.setAmount(product.getAmount() + amount);
        this.repository.save(product);
        return product.getAmount();
    }
}
