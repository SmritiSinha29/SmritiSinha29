package com.lms.project.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "borrows")
public class Borrow {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;


	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;


	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;


	private LocalDate borrowDate;
	private LocalDate returnDate;


	// BORROWED hai ya check krna h RETURNED
	private String status;


	public Borrow(Member member, Book book, LocalDate borrowDate, LocalDate returnDate, String status) {
		super();
		this.member = member;
		this.book = book;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
		this.status = status;
	}


	public Borrow() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Member getMember() {
		return member;
	}


	public void setMember(Member member) {
		this.member = member;
	}


	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}


	public LocalDate getBorrowDate() {
		return borrowDate;
	}


	public void setBorrowDate(LocalDate borrowDate) {
		this.borrowDate = borrowDate;
	}


	public LocalDate getReturnDate() {
		return returnDate;
	}


	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Borrow [id=" + id + ", member=" + member + ", book=" + book + ", borrowDate=" + borrowDate
				+ ", returnDate=" + returnDate + ", status=" + status + "]";
	}
	
}
