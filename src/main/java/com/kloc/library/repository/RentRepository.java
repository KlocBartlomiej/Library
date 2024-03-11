package com.kloc.library.repository;

import com.kloc.library.model.Rent;
import org.springframework.data.repository.CrudRepository;

public interface RentRepository extends CrudRepository<Rent,Integer> {
}
