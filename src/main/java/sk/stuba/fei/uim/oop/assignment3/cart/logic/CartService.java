package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import org.springframework.beans.factory.annotation.Autowired;

public class CartService implements ICartService {
    @Autowired
    private ICartService repository;
}
