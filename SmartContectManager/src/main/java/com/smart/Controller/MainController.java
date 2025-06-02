package com.smart.Controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.Entity.User;
import com.smart.dao.Userrepo;
import com.smart.helper.Message;

@Controller
public class MainController {

	@Autowired
	private BCryptPasswordEncoder passwordencoder;
	@Autowired
	private Userrepo urepo;

	@GetMapping("/")
	public String home(Model m) {

		m.addAttribute("title", "Home-SmartContectManager");

		return "home";
	}

	@GetMapping("/signup")
	public String about(Model m) {

		m.addAttribute("title", "Registration-SmartContectManager");
		m.addAttribute("user", new User());
		return "signup";
	}

	// this handlerr for register process

	@PostMapping("/do_register")
	public String registeruser(@Valid @ModelAttribute("user") User user,BindingResult Bresult,

			@RequestParam(value = "aggrement", defaultValue = "false") boolean agreement, 
			Model model, HttpSession session)

	{

		try {

			if (Bresult.hasErrors()) {
				System.out.println(Bresult.toString());
				model.addAttribute("user", user);
				return "signup";
			}

			if (!agreement) {

				throw new Exception("u havwe not agree terms and condition");
			}

			if (urepo.existsByEmail(user.getEmail())) {
				session.setAttribute("message", new Message("Email already exists", "alert-danger"));
				model.addAttribute("user", user);
				return "signup";
			}

			if (urepo.existsByName(user.getName())) {
				session.setAttribute("message", new Message("Username already exists", "alert-danger"));
				model.addAttribute("user", user);
				return "signup";
			}

			user.setRole("ROLE_USER");
			user.setEnable(true);
			user.setImageurl("deffault.png");
			user.setPassword(passwordencoder.encode(user.getPassword()));
			
			User result = this.urepo.save(user);
			model.addAttribute("user", new User());

			session.setAttribute("message", new Message("successfully registration", "alert-success"));
			return "signup";
		} catch (Exception e) {

			e.printStackTrace();
			model.addAttribute("user", user);

			session.setAttribute("message", new Message("Something Went Wrong" + e.getMessage(), "alert-danger"));

			return "signup";
		}
	}
	
	
	
	//this handlerfor Custom Loginpage	
	
	@GetMapping("/signin")
	public String customlogin(Model model) {
		model.addAttribute("title", "Login Page");
		
		return "login";
	}
}
