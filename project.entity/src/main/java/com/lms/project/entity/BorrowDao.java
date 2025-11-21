package com.lms.project.entity;
import jakarta.persistence.*;
import java.util.*;


public class BorrowDao {


public void save(Borrow b) {
EntityManager em = JPAUtil.getEntityManager();
EntityTransaction tx = em.getTransaction();
tx.begin();
em.persist(b);
tx.commit();
em.close();
}


public List<Borrow> activeBorrows() {
EntityManager em = JPAUtil.getEntityManager();
List<Borrow> list = em.createQuery("SELECT bo FROM Borrow bo WHERE bo.status='BORROWED'", Borrow.class).getResultList();
em.close();
return list;
}
}