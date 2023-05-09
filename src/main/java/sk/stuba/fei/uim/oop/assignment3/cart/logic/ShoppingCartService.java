package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sk.stuba.fei.uim.oop.assignment3.cart.data.CartItem;
import sk.stuba.fei.uim.oop.assignment3.cart.data.IShoppingCartRepository;
import sk.stuba.fei.uim.oop.assignment3.cart.data.ShoppingCart;
import sk.stuba.fei.uim.oop.assignment3.cart.web.bodies.CartItemRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.logic.ProductService;

@Service
public class ShoppingCartService implements IShoppingCartService {
    @Autowired
    private IShoppingCartRepository repository;
    @Autowired
    private ICartItemService cartItemService;
    @Autowired
    private ProductService productService;

    @Override
    public ShoppingCart createCart() {
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
    public ShoppingCart addProductToCart(long id, CartItemRequest cartItem) throws NotFoundException, IllegalOperationException {
        ShoppingCart cart = this.getCart(id);
        if (cart.isPayed()) {
            throw new IllegalOperationException();
        }
        CartItem requestedItem = null;
        for (CartItem item : cart.getShoppingList()) {
            if (item.getProduct().getId() == cartItem.getProductId()) {
                requestedItem = item;
                break;
            }
        }

        if (productService.getProduct(cartItem.getProductId()).getAmount() - cartItem.getAmount() < 0) {
            throw new IllegalOperationException();
        }

        if (requestedItem == null) {
            requestedItem = cartItemService.createCartItem();
            requestedItem.setProduct(productService.getProduct(cartItem.getProductId()));
            requestedItem.setAmount(cartItem.getAmount());
            cart.getShoppingList().add(cartItemService.add(requestedItem));
        } else {
            requestedItem.setAmount(requestedItem.getAmount() + cartItem.getAmount());
            cartItemService.add(requestedItem);
        }
        productService.removeAmount(requestedItem.getProduct().getId(), requestedItem.getAmount());
        return this.repository.save(cart);
    }

    @Override
    public double payForCart(long id) throws NotFoundException, IllegalOperationException {
        ShoppingCart cart = this.getCart(id);
        if (cart.isPayed()) {
            throw new IllegalOperationException();
        }
        double charge = 0;
        for (CartItem item : cart.getShoppingList()) {
            charge += (double) (item.getAmount() * item.getProduct().getPrice());
        }
        cart.setPayed(true);
        this.repository.save(cart);
        return charge;
    }
}
