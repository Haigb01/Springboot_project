package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Product;
import com.example.demo.Model.Report;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
//	@Query(value = "select p from Product p where p.productprice between ?1 and ?2")
//	public List<Product> searchByPrice(double minPrice, double maxPrice);
	
	//Cach 2
	List<Product> findByProductpriceBetween(double minPrice, double maxPrice);

//	@Query("select p from Product p where p.productname like ?1")
//	Page<Product> searchByName(String keyWords, Pageable pageble);
	
	//Cach 2
	Page<Product> findAllByProductnameLike(String keyWords, Pageable pageable);

	@Query("select new com.example.demo.Model.Report(p.category.categoryid,sum(p.productprice),count(p))" + " from Product p" + " group by p.category.categoryid"
			+ " order by sum(p.productprice) DESC")
	List<Report> getInventoryByCategory();

}
