package com.example.Test.repositories;
import com.example.Test.models.Passport;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PassportRepository extends CrudRepository<Passport, Long> {
    public List<Passport> findByName(String name);

}