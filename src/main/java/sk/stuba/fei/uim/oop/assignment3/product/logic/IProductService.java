package sk.stuba.fei.uim.oop.assignment3.product.logic;

import java.util.List;

import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.ProductRequest;

public interface IProductService {
    List<Product> getAll();
    Product create(ProductRequest request);
    Product getProduct(long id) throws NotFoundException;
    Product modifyProduct(long id, ProductRequest request) throws NotFoundException;
    void deleteProduct(long id) throws NotFoundException;
    long getAmount(long id) throws NotFoundException;
    long modifyAmount(long id, long amount) throws NotFoundException;
}
