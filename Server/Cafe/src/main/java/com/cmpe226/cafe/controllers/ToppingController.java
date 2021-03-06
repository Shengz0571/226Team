package com.cmpe226.cafe.controllers;

import com.cmpe226.cafe.models.Message;
import com.cmpe226.cafe.models.Topping;
import com.cmpe226.cafe.repositories.ToppingRowMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ToppingController {

    @Autowired
    ToppingRowMapper toppingRowMapper;

    @GetMapping("/toppings")
    public Message listAllToppings() {
        List<Topping> result = toppingRowMapper.findAllTps();

        String data;
        ObjectMapper mapper = new ObjectMapper();
        try {
            data = mapper.writeValueAsString(result);
        } catch (Exception e) {
            data = "";
        }

        return new Message(200, "Success", data);
    }
}
