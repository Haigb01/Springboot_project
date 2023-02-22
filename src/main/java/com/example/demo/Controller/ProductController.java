package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Service.SessionService;

@Controller
@RequestMapping("product")
public class ProductController {

	@Autowired
	ProductRepository dao;

	@Autowired
	SessionService session;

	@RequestMapping("sort")
	public String sort(Model model, @RequestParam("field") Optional<String> field) {
		Sort sort = Sort.by(Direction.DESC, field.orElse("productprice"));
		model.addAttribute("field", field.orElse("productprice").toUpperCase());

		List<Product> items = dao.findAll(sort);
		model.addAttribute("items", items);
		return "product/sort";

	}

	@RequestMapping("page")
	public String paginate(Model model, @RequestParam("p") Optional<Integer> p) {
		// so 1 la 1 trang 1sp
		Pageable pageable = PageRequest.of(p.orElse(0), 1);

		Page<Product> page = dao.findAll(pageable);
		model.addAttribute("page", page);
		return "product/page";

	}

	@RequestMapping("search")
	public String search(Model model, @RequestParam("min")Optional<Double> min, @RequestParam("max")Optional<Double> max){
		double minPrice = min.orElse(Double.MAX_VALUE);
		double maxPrice= max.orElse(Double.MAX_VALUE);
//		List<Product> items= dao.searchByPrice(minPrice, maxPrice);
		//cach 2
		List<Product> items= dao.findByProductpriceBetween(minPrice, maxPrice);
		model.addAttribute("items",items);
		return "product/sort";
	}

	@RequestMapping("searchName")
	public String searchName(Model model,
			@RequestParam("keyWords") Optional<String> kw,
			@RequestParam("p") Optional<Integer> p) {
		
		String kwords = kw.orElse(session.get("keyWords"));
		session.set("keyWords", kwords);
		
		Pageable pageable = PageRequest.of(p.orElse(0), 1);
//		Page<Product> page = dao.searchByName("%"+kwords+"%", pageable);
		
		//Cach  2;
		Page<Product> page = dao.findAllByProductnameLike("%"+kwords+"%", pageable);
		
		model.addAttribute("page",page);
		return "product/page";
	}
	
}
