package com.lms.project.entity;


import java.time.*;
import java.util.*;


public class BorrowService {


BorrowDao dao = new BorrowDao();


public void borrowBook(Member m, Book b) {
if (!b.getStatus().equals("AVAILABLE")) {
System.out.println("Book already borrowed!");
return;
}


Borrow bo = new Borrow();
bo.setMember(m);
bo.setBook(b);
bo.setBorrowDate(LocalDate.now());
bo.setStatus("BORROWED");


b.setStatus("BORROWED");


dao.save(bo);
System.out.println("Book borrowed: " + b.getTitle());
}


public void returnBook(Borrow bo) {
bo.setStatus("RETURNED");
bo.setReturnDate(LocalDate.now());
bo.getBook().setStatus("AVAILABLE");
dao.save(bo);
System.out.println("Book returned!");
}


public List<Borrow> getActiveBorrows() {
return dao.activeBorrows();
}
}