package LEVEL_2_CACHE;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SecondLevelCache {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		int courseid;
		
//		Session session = factory.openSession();
//		session.beginTransaction();  // Start transaction
//		
//		Course course = new Course("Java Backend", "Mr.smith", 50);
//		session.save(course);
//		
//		session.getTransaction().commit();  // Commit transaction
//		session.close();
		

		Session session = factory.openSession();
		session.beginTransaction(); 
		Course course = new Course("Java Backend", "Mr.smith", 50);
		session.save(course);
		session.getTransaction().commit();
		
		
		
		
		courseid = course.getId();
		session.close();
		
		       // second fetch
				Session s2 = factory.openSession();
				System.out.println("Fetching from session 1");
				Course c1 = s2.get(Course.class, courseid);
				System.out.println("Title: " + c1.getTitle());

				s2.beginTransaction().commit();
				s2.close();

				// Second time again fetch (new session)
				Session s3 = factory.openSession();
				System.out.println("fetching from session2");
				Course c2 = s3.get(Course.class, courseid);
				System.out.println("Title: " + c2.getTitle());

//				s3.beginTransaction().commit(); // optional if no changes
				s3.close();

				factory.close();

			}

}

