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
@Table(name="members")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;


	private String name;
	private String email;
	private String contact;

	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private List<Borrow> borrows = new ArrayList<>();

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", email=" + email + ", contact=" + contact + ", borrows="
				+ borrows + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public List<Borrow> getBorrows() {
		return borrows;
	}

	public void setBorrows(List<Borrow> borrows) {
		this.borrows = borrows;
	}

	public Member(String name, String email, String contact) {
		this.name = name;
		this.email = email;
		this.contact = contact;
	}

	public Member() {
	
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
