package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.Product;
import com.example.demo.Model.Report;
import com.example.demo.Repository.ProductRepository;

@RequestMapping("report")
@Controller
public class ReportController {

	@Autowired
	ProductRepository dao;
	
	@RequestMapping("inventory-by-category")
	public String inventory(Model model) {
		List<Report> items = dao.getInventoryByCategory();
		model.addAttribute("items",items);
		return "report/inventory-by-category";
	}
	
}
