package com.lms.project.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;


private String title;
private String author;
private String category;
private String status;


@OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
private List<Borrow> borrows = new ArrayList<>();




public Book() {
	super();
	// TODO Auto-generated constructor stub
}




public Book(Integer id, String title, String author, String category, String status, List<Borrow> borrows) {
	super();
	this.id = id;
	this.title = title;
	this.author = author;
	this.category = category;
	this.status = status;
	this.borrows = borrows;
}




public Integer getId() {
	return id;
}




public void setId(Integer id) {
	this.id = id;
}




public String getTitle() {
	return title;
}




public void setTitle(String title) {
	this.title = title;
}




public String getAuthor() {
	return author;
}




public void setAuthor(String author) {
	this.author = author;
}




public String getCategory() {
	return category;
}




public void setCategory(String category) {
	this.category = category;
}




public String getStatus() {
	return status;
}




public void setStatus(String status) {
	this.status = status;
}




public List<Borrow> getBorrows() {
	return borrows;
}




public void setBorrows(List<Borrow> borrows) {
	this.borrows = borrows;
}




@Override
public String toString() {
return "Book{" + "id=" + id + ", title='" + title + '\'' + ", author='" + author + '\'' + ", category='" + category + '\'' + ", status='" + status + '\'' + '}';
}
}