package com.example.Session_3.Controller;

import com.example.Session_3.Entity.Book;
import com.example.Session_3.Repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookRepository repo;

    public BookController(BookRepository repo) {
        this.repo = repo;
    }

    // GET /api/books
    @GetMapping
    public List<Book> list() {
        return repo.findAll();
    }

    // GET /api/books/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Book> getOne(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/books
    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book) {
        book = new Book( book.getId(),book.getTitle(), book.getAuthor(),
                book.getPrice());
        Book saved = repo.save(book);
        return ResponseEntity
                .created(URI.create("/api/books/" + saved.getId()))
                .body(saved);
    }

    // PUT /api/books/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id,
                                       @RequestBody Book incoming) {
        return repo.findById(id)
                .map(existing -> {
                    existing.setTitle(incoming.getTitle());
                    existing.setAuthor(incoming.getAuthor());
                    existing.setId(incoming.getId());
                    existing.setPrice(incoming.getPrice());
                    return ResponseEntity.ok(repo.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/books/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    // GET /api/books?author={author}.
    @GetMapping("/api/books?author={author}")
    public List<Book> findByAuthor(@RequestParam String author) {
        return repo.findByAuthor(author);
    }
    // GET /api/books?minPrice={price}.

    @GetMapping("/api/books?minPrice={price}")
    public List<Book> byMinPrice(@RequestParam double minPrice) {
        return repo.findByPriceGreaterThan(minPrice);
    }
}
