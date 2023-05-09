package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import sk.stuba.fei.uim.oop.assignment3.cart.data.CartItem;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

public interface ICartItemService {
    
    CartItem getCartItem(long id) throws NotFoundException;
    CartItem createCartItem() throws NotFoundException;
    void removeCartItem(long id) throws NotFoundException;
    CartItem add(CartItem item) throws NotFoundException;
}
