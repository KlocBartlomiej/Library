package com.kloc.library.model;

import org.springframework.data.annotation.Id;

public record Book(
        @Id
        Integer id,
        String title,
        String author,
        Integer yearOfPrint,
        boolean isAvailable
) {
}
