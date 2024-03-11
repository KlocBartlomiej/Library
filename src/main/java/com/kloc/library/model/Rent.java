package com.kloc.library.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.util.Date;

public record Rent(
        @Id
        Integer id,
        Integer bookId,
        Integer clientId,
        @CreatedDate
        Date dateOfRent
) {
}
