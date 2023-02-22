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
@Table(name="orders")
public class Order implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long orderid;
	private String address;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="orderCreateDate")
	Date ordercreatedate = new Date();
	@ManyToOne@JoinColumn(name="username")
	Account account;
	@OneToMany(mappedBy="order")
	List<OrderDetail> orderDetails;
}
