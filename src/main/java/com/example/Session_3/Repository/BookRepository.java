package com.example.Session_3.Repository;

import com.example.Session_3.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthor(String author);
    List<Book> findByPriceGreaterThan(double price);
    @Query("""
             SELECT
            b FROM Book b WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :term, '%'))
            """)
    List<Book> searchByTitle(@Param("term") String term);
}
