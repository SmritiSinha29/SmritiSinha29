package com.lms.project.entity;

import java.util.List;
import jakarta.persistence.EntityManager;

public class BookDao {

    public Book save(Book book) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(book);
            em.getTransaction().commit();
            return book;
        } finally {
            em.close();
        }
    }

    public Book update(Book book) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Book merged = em.merge(book);
            em.getTransaction().commit();
            return merged;
        } finally {
            em.close();
        }
    }

    public void delete(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Book b = em.find(Book.class, id);
            if (b != null) em.remove(b);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<Book> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Book> books = em.createQuery("SELECT b FROM Book b", Book.class)
                             .getResultList();
        em.close();
        return books;
    }

    public Book find(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(Book.class, id);
        } finally {
            em.close();
        }
    }
}
