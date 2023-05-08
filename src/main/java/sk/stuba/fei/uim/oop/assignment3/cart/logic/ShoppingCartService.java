package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sk.stuba.fei.uim.oop.assignment3.cart.data.IShoppingCartRepository;
import sk.stuba.fei.uim.oop.assignment3.cart.data.ShoppingCart;
import sk.stuba.fei.uim.oop.assignment3.cart.web.bodies.CartItem;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

@Service
public class ShoppingCartService implements IShoppingCartService {
    @Autowired
    private IShoppingCartRepository repository;

    @Override
    public ShoppingCart create() {
        return this.repository.save(new ShoppingCart());
    }

    @Override
    public ShoppingCart getCart(long id) throws NotFoundException {
        ShoppingCart cart = this.repository.findById(id);
        if (cart == null) {
            throw new NotFoundException();
        }
        return cart;
    }
    
    @Override
    public void deleteCart(long id) throws NotFoundException {
        this.repository.delete(this.getCart(id));
    }

    @Override
    public ShoppingCart addProductToCart(long id, CartItem cartItem) throws NotFoundException, IllegalOperationException {
        return null;
    }
}
