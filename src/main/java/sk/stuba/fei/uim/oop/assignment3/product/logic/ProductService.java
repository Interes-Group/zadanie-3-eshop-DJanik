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
        Product p = new Product();
        p.setName(request.getName());
        p.setDescription(request.getDescription());
        p.setAmount(request.getAmount());
        p.setUnit(request.getUnit());
        p.setPrice(request.getPrice());
        return this.repository.save(p);
    }

    @Override
    public Product getProduct(long id) throws NotFoundException {
        for (Product product : this.getAll()) {
            if (product.getId() == id) {
                return product;
            }
        }
        throw new NotFoundException();
    }
    
}
