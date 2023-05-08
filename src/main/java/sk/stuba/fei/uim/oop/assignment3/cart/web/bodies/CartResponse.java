package sk.stuba.fei.uim.oop.assignment3.cart.web.bodies;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.cart.data.ShoppingCart;

@Getter
public class CartResponse {
    private long id;
    private boolean payed;
    private List<CartItemRequest> shoppingList;

    public CartResponse(ShoppingCart shoppingCart) {
        this.id = shoppingCart.getId();
        this.shoppingList = shoppingCart.getShoppingList().stream().map(CartItemRequest::new).collect(Collectors.toList());;
        this.payed = shoppingCart.isPayed();
    }
}
