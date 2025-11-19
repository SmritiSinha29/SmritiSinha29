package OneToOne;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneMapping {
 public static void main(String[] args) {
	System.out.println("project started....");
	Configuration cfg = new Configuration();
	
	SessionFactory factory = cfg.configure().buildSessionFactory();
	
	Question q1 = new Question();
	q1.setQuestion("WHAT IS JAVA ? ");
	
	Answer answer = new Answer();
	answer.setAnswer("JAVA IS A PROGRAMMING LANGUAGE.");
	
	answer.setQuestion(q1); //bi-directional mapping
	q1.setAnswer(answer);
	
	Session session = factory.openSession();
	Transaction tx= session.beginTransaction();
	session.save(q1);
	session.save(answer);
	tx.commit();
	
	//fetching data from db
	Question question = session.get(Question.class,1);
	System.out.println(question.getQuestion());
	
	System.out.println(question.getAnswer());
	
	session.close();
	factory.close();
}
}
