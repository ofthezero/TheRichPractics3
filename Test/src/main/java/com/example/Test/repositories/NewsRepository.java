package com.example.Test.repositories;
import java.util.List;
import com.example.Test.models.News;
import org.springframework.data.repository.CrudRepository;

public interface NewsRepository extends CrudRepository<News, Long> {
    public List<News> findByTitle(String title);
    public List<News> findByTitleContains(String title);
}
