package OneToMany;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyMapping {
 public static void main(String[] args) {
	
	Configuration cfg = new Configuration();
	cfg.configure();
	
	SessionFactory sf = cfg.buildSessionFactory();
	
	Department dept = new Department();
	dept.setName("IT DEPARTMENT");
	
	Employee emp1 = new Employee();
	emp1.setName("Alice");
	emp1.setDepartment(dept);

	Employee emp2 = new Employee();
	emp2.setName("Bob");
	emp2.setDepartment(dept);
	
	
	dept.setEmployees(Arrays.asList(emp1,emp2));
	
	Session session = sf.openSession();
	session.beginTransaction();
	session.save(dept);
	session.getTransaction().commit();
	session.close();
	sf.close();
	
	
	
	 
}
}
