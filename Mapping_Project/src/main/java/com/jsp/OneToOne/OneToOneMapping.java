package com.jsp.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneMapping {

    public static void main(String[] args) {

        System.out.println("Project started...");

        Configuration cfg = new Configuration();
        cfg.configure();

        SessionFactory factory = cfg.buildSessionFactory();

        Person p = new Person();
        p.setName("Smriti");

        Passport passport = new Passport();
        passport.setPassportNumber("IND987654");

        // Bi-directional mapping
        p.setPassport(passport);
        passport.setPerson(p);

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(p);
        session.save(passport);

        tx.commit();
        session.close();
        factory.close();

        System.out.println("Data saved successfully!");
    }
}
