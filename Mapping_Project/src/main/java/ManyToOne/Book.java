package ManyToOne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titile;
	private double price;
	
	@ManyToOne
	@JoinColumn(name="publisher_id")
	private Publisher publisher;

	public Book(String titile, double price, Publisher publisher) {
		this.titile = titile;
		this.price = price;
		this.publisher = publisher;
	}

	public String getTitile() {
		return titile;
	}

	public void setTitile(String titile) {
		this.titile = titile;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", titile=" + titile + ", price=" + price + ", publisher=" + publisher + "]";
	}

	public Book() {
		
	}
}
