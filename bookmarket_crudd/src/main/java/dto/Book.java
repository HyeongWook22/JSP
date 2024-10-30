package dto;

import java.io.Serializable;

public class Book implements Serializable 
{
	private static final long serialVersionUID = -4274700572038677000L;
	
	private String b_id;
	private String b_name;
	private int b_unitPrice;
	private String b_author;
	private String b_description;
	private String b_publisher;
	private String b_category;
	private long b_unitsInStock;
	private String b_releaseDate;
	private String b_condition;
	private String b_fileName;
	private int quantity;


	public Book()
	{
		super();
	}
		
	public String getB_id() {
		return b_id;
	}

	public void setB_id(String b_id) {
		this.b_id = b_id;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public int getB_unitPrice() {
		return b_unitPrice;
	}

	public void setB_unitPrice(int b_unitPrice) {
		this.b_unitPrice = b_unitPrice;
	}

	public String getB_author() {
		return b_author;
	}

	public void setB_author(String b_author) {
		this.b_author = b_author;
	}

	public String getB_description() {
		return b_description;
	}

	public void setB_description(String b_description) {
		this.b_description = b_description;
	}

	public String getB_publisher() {
		return b_publisher;
	}

	public void setB_publisher(String b_publisher) {
		this.b_publisher = b_publisher;
	}

	public String getB_category() {
		return b_category;
	}

	public void setB_category(String b_category) {
		this.b_category = b_category;
	}

	public long getB_unitsInStock() {
		return b_unitsInStock;
	}

	public void setB_unitsInStock(long b_unitsInStock) {
		this.b_unitsInStock = b_unitsInStock;
	}

	public String getB_releaseDate() {
		return b_releaseDate;
	}

	public void setB_releaseDate(String b_releaseDate) {
		this.b_releaseDate = b_releaseDate;
	}

	public String getB_condition() {
		return b_condition;
	}

	public void setB_condition(String b_condition) {
		this.b_condition = b_condition;
	}

	public String getB_fileName() {
		return b_fileName;
	}

	public void setB_fileName(String b_fileName) {
		this.b_fileName = b_fileName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
