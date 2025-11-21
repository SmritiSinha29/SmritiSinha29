package com.te.hibernatejpaapp;

import jakarta.persistence.Embeddable;

@Embeddable
public class Certificate {
	
	private String course;
	private int duratuon;
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getDuratuon() {
		return duratuon;
	}
	public void setDuratuon(int duratuon) {
		this.duratuon = duratuon;
	}
	@Override
	public String toString() {
		return "Certificate [course=" + course + ", duratuon=" + duratuon + "]";
	}
	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Certificate(String course, int duratuon) {
		super();
		this.course = course;
		this.duratuon = duratuon;
	}
	


}
