package sk.stuba.fei.uim.oop.assignment3.cart.web.bodies;

import java.util.List;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.cart.data.CartItem;
import sk.stuba.fei.uim.oop.assignment3.cart.data.ShoppingCart;

@Getter
public class CartResponse {
    private long id;
    private boolean payed;
    private List<CartItem> shoppingList;

    public CartResponse(ShoppingCart shoppingCart) {
        this.id = shoppingCart.getId();
        this.shoppingList = shoppingCart.getShoppingList();
        this.payed = shoppingCart.isPayed();
    }
}
