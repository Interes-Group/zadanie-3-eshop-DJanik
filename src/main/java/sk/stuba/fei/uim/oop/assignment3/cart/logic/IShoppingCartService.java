package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import sk.stuba.fei.uim.oop.assignment3.cart.data.ShoppingCart;
import sk.stuba.fei.uim.oop.assignment3.cart.web.bodies.CartItemRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

public interface IShoppingCartService {
    ShoppingCart createCart();

    ShoppingCart getCart(Long id) throws NotFoundException;

    void deleteCart(Long id) throws NotFoundException;

    ShoppingCart addProductToCart(Long id, CartItemRequest cartItem) throws NotFoundException, IllegalOperationException;

    double payForCart(Long id) throws NotFoundException, IllegalOperationException;
}
