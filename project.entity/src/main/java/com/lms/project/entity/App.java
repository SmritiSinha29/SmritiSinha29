package com.lms.project.entity;

/**
 * Hello world!
 */
public class App {
		public static void main(String[] args) {


			BookService bs = new BookService();
			MemberService ms = new MemberService();
			BorrowService bor = new BorrowService();


			Book b1 = new Book();
			b1.setTitle("Java");
			b1.setAuthor("James");
			b1.setCategory("Programming");
			b1.setStatus("AVAILABLE");
			bs.addBook(b1);


			Member m1 = new Member();
			m1.setName("Smriti");
			m1.setEmail("smriti@gmail.com");
			m1.setContact("999999");
			ms.addMember(m1);


			bor.borrowBook(m1, b1);


			System.out.println("All Books: " + bs.getAllBooks());
			}
}
