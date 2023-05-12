package sk.stuba.fei.uim.oop.assignment3.product.logic;

import java.util.List;

import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.ProductRequest;

public interface IProductService {
    List<Product> getAll();

    Product create(ProductRequest request);

    Product getProduct(Long id) throws NotFoundException;

    Product modifyProduct(Long id, ProductRequest request) throws NotFoundException;

    void deleteProduct(Long id) throws NotFoundException;

    int getAmount(Long id) throws NotFoundException;

    int modifyAmount(Long id, int amount) throws NotFoundException;
}
