package ManyToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private double price;
   
	
	@ManyToMany(mappedBy ="products")
	private List<Orders> orders= new ArrayList<Orders>();


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public List<Orders> getOrders() {
		return orders;
	}


	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}


	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", price=" + price + ", orders=" + orders + "]";
	}
	
}
