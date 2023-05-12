package sk.stuba.fei.uim.oop.assignment3.cart.web.bodies;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.cart.data.CartItem;

@Getter
@Setter
@NoArgsConstructor
public class CartItemRequest {
    private long productId;
    private int amount;

    public CartItemRequest(CartItem cartItem) {
        this.productId = cartItem.getProduct().getId();
        this.amount = cartItem.getAmount();
    }
}
