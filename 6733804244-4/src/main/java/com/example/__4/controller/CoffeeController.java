package com.example.__4.controller;

import com.example.__4.model.Coffee;
import com.example.__4.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coffees")
public class CoffeeController {

    @Autowired
    private CoffeeService service;

    @GetMapping
    public List<Coffee> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Coffee getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Coffee add(@RequestBody Coffee coffee) {
        return service.add(coffee);
    }

    @PutMapping("/{id}")
    public Coffee update(@PathVariable Long id,
                         @RequestBody Coffee coffee) {
        return service.update(id, coffee);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {

        if (service.delete(id)) {
            return "Deleted";
        }

        return "Not Found";
    }
}