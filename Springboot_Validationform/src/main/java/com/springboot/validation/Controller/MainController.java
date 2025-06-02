package com.springboot.validation.Controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.validation.entity.Entity;

@Controller
public class MainController {

	
	@GetMapping("/form")
	public String form(Model m) {
		
		m.addAttribute("logindata", new Entity());
		return "index";
	}
	
	@PostMapping("/process")
	public String processform(@RequestBody @Valid @ModelAttribute("logindata") Entity value,BindingResult result) {
		if (result.hasErrors()) {
			System.out.println(result);
			return "index";

		}
		
		System.out.println(result);
		return "Success";
	}
}
