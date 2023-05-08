package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sk.stuba.fei.uim.oop.assignment3.cart.data.CartItem;
import sk.stuba.fei.uim.oop.assignment3.cart.data.ICartItemRepository;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

@Service
public class CartItemService implements ICartItemService {
    @Autowired
    private ICartItemRepository repository;

    @Override
    public CartItem getCart(long id) throws NotFoundException {
        CartItem item = this.repository.findById(id);
        if (item == null) {
            throw new NotFoundException();
        }
        return item;
    }
}
