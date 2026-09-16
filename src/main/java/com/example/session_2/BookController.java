package com.example.session_2;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import com.example.session_2.Book;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final List<Book> books = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    // GET /api/books — list all
    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    // GET /api/books/{id} — get one, 404 if missing
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return findById(id)
                .map(ResponseEntity::ok)                         // 200 OK
                .orElseGet(() -> ResponseEntity.notFound().build()); // 404
    }

    // POST /api/books — create, 201 + Location header
    @PostMapping
    public ResponseEntity<Book> createBook(@Valid @RequestBody Book book) {
        long newId = idCounter.getAndIncrement();
        Book created = new Book(newId, book.getTitle(), book.getAuthor(), book.getPrice());
        books.add(created);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newId)
                .toUri();

        return ResponseEntity.created(location).body(created); // 201
    }

    // PUT /api/books/{id} — update, 404 if missing
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id,
                                           @Valid @RequestBody Book book) {
        Optional<Book> existing = findById(id);
        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build(); // 404
        }
        Book updated = new Book(id, book.getTitle(), book.getAuthor(), book.getPrice());
        books.replaceAll(b -> b.getId().equals(id) ? updated : b);
        return ResponseEntity.ok(updated); // 200
    }

    // DELETE /api/books/{id} — 204 if removed, 404 otherwise
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        boolean removed = books.removeIf(b -> b.getId().equals(id));
        return removed
                ? ResponseEntity.noContent().build()          // 204
                : ResponseEntity.notFound().build();          // 404
    }

    //demonstrate @RequestParam — filter by author
    // e.g. GET /api/books/search?author=Rowling
    @GetMapping("/search")
    public List<Book> searchByAuthor(@RequestParam String author) {
        return books.stream()
                .filter(b -> b.getAuthor().equalsIgnoreCase(author))
                .toList();
    }

    private Optional<Book> findById(Long id) {
        return books.stream().filter(b -> b.getId().equals(id)).findFirst();
    }
}