package com.example.__4.service;
import org.springframework.stereotype.Service;

import com.example.__4.model.Coffee;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoffeeService {

    private final List<Coffee> coffees = new ArrayList<>();

    public CoffeeService() {
        coffees.add(new Coffee(1L, "Espresso", 45.0));
        coffees.add(new Coffee(2L, "Latte", 55.0));
    }

    public List<Coffee> getAll() {
        return coffees;
    }

    public Coffee getById(Long id) {
        return coffees.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Coffee add(Coffee coffee) {
        coffee.setId((long) (coffees.size() + 1));
        coffees.add(coffee);
        return coffee;
    }

    public Coffee update(Long id, Coffee coffee) {
        Coffee old = getById(id);

        if (old != null) {
            old.setName(coffee.getName());
            old.setPrice(coffee.getPrice());
        }

        return old;
    }

    public boolean delete(Long id) {
        Coffee coffee = getById(id);

        if (coffee != null) {
            coffees.remove(coffee);
            return true;
        }

        return false;
    }
}
