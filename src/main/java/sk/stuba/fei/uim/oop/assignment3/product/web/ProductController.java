package sk.stuba.fei.uim.oop.assignment3.product.web;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.logic.ProductService;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.Amount;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.ProductResponse;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping()
    public List<ProductResponse> getAllProducts() {
        return this.service.getAll().stream().map(ProductResponse::new).collect(Collectors.toList());
    }

    @PostMapping()
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest product) {
        return new ResponseEntity<>(new ProductResponse(this.service.create(product)), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ProductResponse getProductById(@PathVariable("id") long id) throws NotFoundException {
        return new ProductResponse(this.service.getProduct(id));
    }

    @PutMapping(value = "/{id}")
    public ProductResponse updateProduct(@PathVariable("id") long id,@RequestBody ProductRequest product) throws NotFoundException {
        return new ProductResponse(this.service.modifyProduct(id,product));
    }
    
    @DeleteMapping(value = "/{id}")
    public void deleteProduct(@PathVariable("id") long id) throws NotFoundException {
        this.service.deleteProduct(id);
    }

    @GetMapping(value = "/{id}/amount")
    public Amount getProductAmount(@PathVariable("id") long id) throws NotFoundException {
        return new Amount(this.service.getAmount(id));
    }

    @PostMapping(value = "/{id}/amount")
    public Amount updateProductAmount(@PathVariable("id") long id,@RequestBody Amount amount) throws NotFoundException {
        return new Amount(this.service.modifyAmount(id, amount.getAmount()));
    }
}
