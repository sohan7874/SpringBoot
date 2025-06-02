package com.springboot.tymleaf.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MainController {

	@RequestMapping(value = "/about",method = RequestMethod.GET)
	public String  about( Model model) {
		
		model.addAttribute("name", "sohan");
		model.addAttribute("time", new Date().toString()); 
		return "about";
	}
	
	
	@RequestMapping(value = "/itration",method = RequestMethod.GET)
	public String  checked( Model model) {
		
		List<String> loops = List.of("dog", "cat","cow","sunny","buffelo");
		 model.addAttribute("loop",loops);
		return "itration";
	}
	
	
	@GetMapping("/loop")
	public String itration(Model m ) {
		
		m.addAttribute("Active", false);
		
		m.addAttribute("Gender", " male");
		
		
		return "loop";
	}
	
	@RequestMapping(value = "/base",method = RequestMethod.GET)
public String base( ) {
		
		
		
		return "aboutnew";
	}
	
	
	@GetMapping("fragment")
	public String footerdemo(Model m) {
		return "/Fragment/fragment";
	} 
}
