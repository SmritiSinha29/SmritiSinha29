package ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToManyMapping {
 public static void main(String[] args) {
	SessionFactory factory = new Configuration().configure().buildSessionFactory();
	Session session = factory.openSession();
	
	Products p1 = new Products();
	p1.setName("Laptop");
	p1.setPrice(55000.0);
	
	Products p2 = new Products();
	p2.setName("Mouse");
	p2.setPrice(55000.0);
	
	Orders o1 = new Orders();
	o1.setCustomername("Alice");
	
	
	Orders o2 = new Orders();
	o1.setCustomername("Bob");
	
	o1.getProducts().add(p1);
	o1.getProducts().add(p2);
	
	o2.getProducts().add(p1);
	
	p1.getOrders().add(o1);
	p1.getOrders().add(o2);
	p2.getOrders().add(o1);
	
	session.beginTransaction();
	session.save(o2);
	session.save(o1);
	session.save(p2);
	session.save(p1);
	
	
	session.getTransaction().commit();
	session.close();
	factory.close();
	
	
}
}
