package com.lms.project.entity;


import jakarta.persistence.*;
import java.util.*;


public class MemberDao {


public void save(Member m) {
EntityManager em = JPAUtil.getEntityManager();
EntityTransaction tx = em.getTransaction();
tx.begin();
em.persist(m);
tx.commit();
em.close();
}


public Member find(int id) {
EntityManager em = JPAUtil.getEntityManager();
Member m = em.find(Member.class, id);
em.close();
return m;
}


public List<Member> findAll() {
EntityManager em = JPAUtil.getEntityManager();
List<Member> list = em.createQuery("SELECT m FROM Member m", Member.class).getResultList();
em.close();
return list;
}
}