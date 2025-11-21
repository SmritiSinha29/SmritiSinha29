package com.te.hibernatejpaapp;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App 
{
    public static void main(String[] args)
    {
        System.out.println("Project Started");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("student_pu");
        EntityManager em = emf.createEntityManager();

        // INSERT
        em.getTransaction().begin();

        Certificate c1 = new Certificate("Java", 6);
        Certificate c2 = new Certificate("Python", 4);
        Certificate c3 = new Certificate("Spring Boot", 2);

        StudentDetails s1 = new StudentDetails( "Rahul", "Hyderabad", c1);
        StudentDetails s2 = new StudentDetails("Sneha", "Pune", c2);
        StudentDetails s3 = new StudentDetails("John", "Paris", c3);

        em.persist(s1);
        em.persist(s2);
        em.persist(s3);

        em.getTransaction().commit();
        System.out.println("Students inserted successfully");

        // FETCH by ID
        StudentDetails fetch = em.find(StudentDetails.class, s2.getId());
        System.out.println("\n fetched student by ID : " + s2.getId());
        System.out.println(fetch);

        // FETCH ALL
        System.out.println("\n all students");
        List<StudentDetails> sList = em.createQuery("SELECT s FROM StudentDetails s", StudentDetails.class).getResultList();
        for (StudentDetails sd : sList) {
            System.out.println(sd);
        }

        // UPDATE
        em.getTransaction().begin();
        StudentDetails update = em.find(StudentDetails.class, s3.getId());
        if (update != null) {
            update.setCity("Delhi");
            update.getCertificate().setCourse("Advanced Spring Boot");
        }
        em.getTransaction().commit();

        System.out.println("\n updated student id : " + s3.getId());
        System.out.println(em.find(StudentDetails.class, s3.getId()));

        // DELETE
        em.getTransaction().begin();
        StudentDetails delete = em.find(StudentDetails.class, s1.getId());
        if (delete != null) {
            em.remove(delete);
            System.out.println("\n deleted student ID : " + s1.getId());
        }
        em.getTransaction().commit();

        // FINAL LIST
        System.out.println("\n Final list after deletion");
        List<StudentDetails> finalList = em.createQuery("SELECT s FROM StudentDetails s", StudentDetails.class).getResultList();
        for (StudentDetails sd : finalList) {
            System.out.println(sd);
        }

        // CLOSE
        em.close();
        emf.close();
    }
}