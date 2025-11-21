package com.lms.project.entity;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class JPAUtil {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("lmbs_pu");


	public static EntityManager getEntityManager() {
	return emf.createEntityManager();
	}
}