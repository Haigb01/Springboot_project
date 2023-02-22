package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Model.Category;
import com.example.demo.Repository.CategoryRepository;

@Controller
@RequestMapping("category")
public class CategoryController {
	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping("index")
	public String newOrEdit(Model model) {
		Category category = new Category();

		model.addAttribute("category", category);

		List<Category> categories = categoryRepository.findAll();

		model.addAttribute("categories", categories);

		return "category/view";
	}

	@RequestMapping("edit/{categoryid}")
	public String edit(Model model, @PathVariable("categoryid") String categoryid) {

		Category category = categoryRepository.findById(categoryid).get();
		model.addAttribute("category", category);
		
		List<Category> categories = categoryRepository.findAll();
		model.addAttribute("categories", categories);

		return "category/view";
	}

	@RequestMapping("create")
	public String create(Category category) {
		categoryRepository.save(category);

		return "redirect:/category/index";
	}
	
	
	@RequestMapping("delete/{categoryid}")
	public String delete( @PathVariable("categoryid") String categoryid) {

		categoryRepository.deleteById(categoryid);

		return "redirect:/category/index";
	}
	
	
	@RequestMapping("update")
	public String update(Category category) {
		categoryRepository.save(category);
		return "redirect:/category/edit/"+category.getCategoryid();
	}

}
