Books REST API
A small Spring Boot REST API for managing a catalogue of books, 
backed by an in-memory list. It supports full CRUD, input validation, 
and returns proper HTTP status codes.

Base URL: http://localhost:8080

Book ID type: Long (auto-assigned, starting at 1)

Endpoints
1. GET /api/books — List all books
   Returns every book in the catalogue. Returns an empty array when none exist.

Request body: none

Response: 200 OK

2. GET /api/books/{id} — Get one book
   Fetches a single book by its id.

Path variable: id (Long) — required

Request body: none

Response: 200 OK with the book, or 404 Not Found if no such book exists.

3. POST /api/books — Create a book
   Creates a new book. The server assigns the id.

Request body: JSON. id is ignored if provided.

Response: 201 Created with the created book (including the new id) and 
a Location header pointing to the new resource. Returns 400 Bad Request
if validation fails.

4. PUT /api/books/{id} — Update a book
   Replaces an existing book. The id in the path is authoritative; 
the id in the body (if any) is ignored.

Path variable: id (Long) — required

Request body: JSON with the new values.

Response: 200 OK with the updated book, 404 Not Found if the book does not 
exist, or 400 Bad Request if validation fails.

5. DELETE /api/books/{id} — Delete a book
   Deletes a book by id.

Path variable: id (Long) — required

Request body: none

Response: 204 No Content on success, or 404 Not Found if the book does not 
exist. No response body.