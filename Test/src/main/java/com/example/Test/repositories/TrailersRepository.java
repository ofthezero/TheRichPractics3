package com.example.Test.repositories;
import com.example.Test.models.Trailers;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface TrailersRepository extends CrudRepository<Trailers, Long> {

    public List<Trailers> findByNameTContains(String nameT);
}