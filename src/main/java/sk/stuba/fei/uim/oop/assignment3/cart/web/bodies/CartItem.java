package sk.stuba.fei.uim.oop.assignment3.cart.web.bodies;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CartItem {
    private long productId;
    private long amount;

    public CartItem(sk.stuba.fei.uim.oop.assignment3.cart.data.CartItem cartItem) {
        this.productId = cartItem.getProduct().getId();
        this.amount = cartItem.getAmount();
    }
}
