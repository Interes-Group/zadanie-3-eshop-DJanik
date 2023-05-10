package sk.stuba.fei.uim.oop.assignment3.cart.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sk.stuba.fei.uim.oop.assignment3.cart.logic.ShoppingCartService;
import sk.stuba.fei.uim.oop.assignment3.cart.web.bodies.CartItemRequest;
import sk.stuba.fei.uim.oop.assignment3.cart.web.bodies.CartResponse;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService service;

    @PostMapping()
    public ResponseEntity<CartResponse> createShoppingCart() {
        return new ResponseEntity<>(new CartResponse(this.service.createCart()), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public CartResponse getCartById(@PathVariable("id") long id) throws NotFoundException {
        return new CartResponse(this.service.getCart(id));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCartById(@PathVariable("id") long id) throws NotFoundException {
        this.service.deleteCart(id);
    }

    @PostMapping(value = "/{id}/add")
    public CartResponse addProductToCart(@PathVariable("id") long id, @RequestBody CartItemRequest cartItem) throws NotFoundException, IllegalOperationException {
        return new CartResponse(this.service.addProductToCart(id, cartItem));
    }

    @GetMapping(value = "/{id}/pay")
    public String payForCart(@PathVariable("id") long id) throws NotFoundException, IllegalOperationException {
        return "" + this.service.payForCart(id);
    }
}
