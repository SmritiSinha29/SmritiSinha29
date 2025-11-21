package com.lms.project.entity;

import java.util.List;

public class BookService {

    private BookDao dao = new BookDao();

    public Book addBook(Book b) {
        return dao.save(b);
    }

    public List<Book> getAllBooks() {
        return dao.findAll();
    }

    public Book getBook(int id) {
        return dao.find(id);
    }

    public Book updateBook(Book b) {
        return dao.update(b);
    }

    public void deleteBook(int id) {
        dao.delete(id);
    }
}
