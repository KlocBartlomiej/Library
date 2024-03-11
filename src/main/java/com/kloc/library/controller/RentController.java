package com.kloc.library.controller;

import com.kloc.library.repository.RentRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rents")
public class RentController {
    private final RentRepository rentRepository;

    public RentController(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }
}
