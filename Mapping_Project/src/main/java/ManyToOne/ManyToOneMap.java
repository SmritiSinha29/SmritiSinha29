package ManyToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToOneMap {
public static void main(String[] args) {
	Configuration cfg= new Configuration();
	cfg.configure();
	SessionFactory sf = cfg.buildSessionFactory();
	
	Publisher publisher = new Publisher();
	publisher.setName("penguin book");
	publisher.setLocation("New York");

	Book book1 = new Book();
	book1.setPrice(499.9);
	book1.setTitile("Hibernate Basics");
	book1.setPublisher(publisher);
	
	Book book2 = new Book();
	book2.setPrice(599.9);
	book2.setTitile("JAVA IN DEPTH");
	book2.setPublisher(publisher);
	
	Session session = sf.openSession();
	session.beginTransaction();
	session.save(publisher);
	session.save(book1);
	session.save(book2);
	
	session.getTransaction().commit();
	session.close();
	sf.close();
}
}
