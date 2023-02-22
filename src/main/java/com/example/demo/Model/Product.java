package com.example.demo.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name="products")
public class Product implements Serializable{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	Integer productid;
	String productname;
	String productimage;
	Double productprice;
	@Temporal(TemporalType.DATE)
	@Column(name="productcreatedate")
	Date productcreatedate = new Date();
	Boolean available;
	@ManyToOne @JoinColumn(name="categoryid")
	Category category;
	@OneToMany(mappedBy="product")
	List<OrderDetail> orderDetails;
	
	
}
