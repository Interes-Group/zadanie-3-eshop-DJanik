package sk.stuba.fei.uim.oop.assignment3.cart.data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Entity
@Data
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToMany
    private List<CartItem> shoppingList;
    
    private boolean payed;

    public ShoppingCart() {
        this.shoppingList = new ArrayList<CartItem>();
    }
}
