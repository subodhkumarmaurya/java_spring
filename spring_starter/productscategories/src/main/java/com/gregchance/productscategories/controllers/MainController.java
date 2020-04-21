package com.gregchance.productscategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gregchance.productscategories.models.Cat;
import com.gregchance.productscategories.models.Product;
import com.gregchance.productscategories.repositories.CatRepo;
import com.gregchance.productscategories.repositories.ProductRepo;

@Controller
public class MainController {

	private final ProductRepo prepo;
	private final CatRepo crepo;
	
	public MainController(ProductRepo prepo, CatRepo crepo) {
		this.prepo = prepo;
		this.crepo = crepo;
	}
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("products", prepo.findAll());
		model.addAttribute("cats", crepo.findAll());
		return "index.jsp";
	}
	
	@GetMapping("/products/new")
	public String createProduct(Model model) {
		model.addAttribute("product", new Product());
		return "createproduct.jsp";
	}
	@PostMapping("/products/new")
	public String doCP(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "createproduct.jsp";
		}
		prepo.save(product);
		return "redirect:/";
	}
	@GetMapping("/products/{product_id}")
	public String showProduct(@PathVariable("product_id") Long id, Model model) {
		model.addAttribute("product", prepo.findById(id).orElse(null));
		model.addAttribute("cats", crepo.findAll());
		return "showproduct.jsp";
	}
	@PostMapping("addcat/{product_id}")
	public String addCat(@PathVariable("product_id") Long productID, @RequestParam("cat_id") Long catID) {
		Product product = prepo.findById(productID).orElse(null);
		Cat cat = crepo.findById(catID).orElse(null);
//		product.getCategories().add(cat);
		System.out.println(product.getCategories());
//		product.setCategories(product.getCategories());
//		prepo.save(product);
		return "redirect:/";
	}
	
	@GetMapping("cats/new")
	public String createCate(Model model) {
		model.addAttribute("cat", new Cat());
		return "createcat.jsp";
	}
	@PostMapping("/cats/new")
	public String doCC(@Valid @ModelAttribute("cat") Cat cat, BindingResult result) {
		if(result.hasErrors()) {
			return "createcat.jsp";
		}
		crepo.save(cat);
		return "redirect:/";
	}
	@GetMapping("cats/{cat_id}")
	public String showCat(@PathVariable("cat_id") Long id, Model model) {
		model.addAttribute("cat", crepo.findById(id).orElse(null));
		model.addAttribute("products", prepo.findAll());
		return "showcat.jsp";
	}
	@PostMapping("addproduct/{cat_id}")
	public String addProduct(@PathVariable("cat_id") Long catID, @RequestParam("product_id") Long productID) {
		Cat cat = crepo.findById(catID).orElse(null);
		Product product = prepo.findById(productID).orElse(null);
		cat.getProducts().add(product);
		crepo.save(cat);
		return "redirect:/";
	}
	
}
