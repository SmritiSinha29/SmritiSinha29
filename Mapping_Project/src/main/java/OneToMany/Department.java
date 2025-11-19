package OneToMany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
	
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)	
  private int id;
  private String name;
  
  @OneToMany(cascade=CascadeType.ALL)
  private List<Employee> employees;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public List<Employee> getEmployees() {
	return employees;
}

public void setEmployees(List<Employee> employees) {
	this.employees = employees;
}

public Department(int id, String name, List<Employee> employees) {
	super();
	this.id = id;
	this.name = name;
	this.employees = employees;
}

public Department() {
	super();
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "Department [id=" + id + ", name=" + name + ", employees=" + employees + "]";
}
  
  
  
  
}
