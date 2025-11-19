package com.jsp.OneToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Teacher {
  

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int teacherID;
	
	@OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
	private List<Course> courses = new ArrayList<>();
	
	private String teacherName;
	
	public int getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Teacher(int teacherID, List<Course> courses, String teacherName) {
	
		this.teacherID = teacherID;
		this.courses = courses;
		this.teacherName = teacherName;
	}
     
	
	
}
