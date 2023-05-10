package sk.stuba.fei.uim.oop.assignment3.cart.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;

@Entity
@Data
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Product product;
    private long amount;
}
