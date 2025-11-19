package LEVEL_1_CACHE;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FirstLevelCache {
 public static void main(String[] args) {
	
	 SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		
		LibraryBook newBook = new LibraryBook("MONGODB",999.0);
		session.save(newBook);
		session.getTransaction().commit();
		
//		fetch data by id 
		
		System.out.println("Fetching the book first time");
		LibraryBook b1=session.get(LibraryBook.class,newBook.getId());
		
//		System.out.println("Id : "+b1.getId());
		System.out.println("Title : "+b1.getName());
		System.out.println("Fetching book second time ");
		

		System.out.println("Fetching the book second time");
		LibraryBook b2=session.get(LibraryBook.class,newBook.getId());
		
		System.out.println("Title : "+b1.getName());
		System.out.println("Same object ??"+(b1==b2));
		
		session.close();
		factory.close();
		

		
}
}
