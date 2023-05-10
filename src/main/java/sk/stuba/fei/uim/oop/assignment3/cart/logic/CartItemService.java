package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sk.stuba.fei.uim.oop.assignment3.cart.data.CartItem;
import sk.stuba.fei.uim.oop.assignment3.cart.data.ICartItemRepository;

@Service
public class CartItemService implements ICartItemService {
    @Autowired
    private ICartItemRepository repository;

    @Override
    public CartItem createCartItem() {
        return this.repository.save(new CartItem());
    }

    @Override
    public CartItem add(CartItem item) {
        return this.repository.save(item);
    }
}
