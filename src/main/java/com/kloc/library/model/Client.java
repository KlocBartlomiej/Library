package com.kloc.library.model;

import org.springframework.data.annotation.Id;

public record Client(
        @Id
        Integer id,
        String name,
        String surname,
        String email
) {
}
