package com.smart.Controller;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.smart.Entity.ContectDetail;
import com.smart.Entity.User;
import com.smart.dao.Userrepo;

@Controller
@RequestMapping("/user")
public class UserController {
@Autowired
	Userrepo  urepo;


@ModelAttribute
public void addcomandata(Model m,Principal pri) {
	String username=pri.getName();
	User user=urepo.getUserbyUsername(username);
	m.addAttribute("user", user);
	
}

	@RequestMapping("/user_deshboard")
	public String userpage(Model model, Principal pri) {
		model.addAttribute("title", "HomePage");
		return "/normal/user_deshboard";
	}
	
		//open add contect handler
	@RequestMapping("/add-contect")
	public String OpenContectForm(Model model) {
		model.addAttribute("title", "AddContects");
		model.addAttribute("contect", new ContectDetail());
		return "/normal/add-contect-form";
	}
	

	
	
	
	@PostMapping("/process-contect")
	public String processform(@ModelAttribute ContectDetail contect,
	        Principal principal) {

		
	 try {
		 
		 
		 String name = principal.getName();
		 User user =this.urepo.getUserbyUsername(name);
		 
		
			 contect.setImageurl("Default.png");
		 user.getContects().add(contect);
		 contect.setUser(user);
		 
		 
		 this.urepo.save(user);
		 
	 }catch (Exception e) {
System.out.println("Error"+e.getMessage());
	 }

	     return  "/normal/add-image-of-contect";	       
	}

	

	

	
}








/*
@PostMapping("/process-contect")
public ResponseEntity<?> handleFileUpload( @RequestParam("imageurl") MultipartFile file ) {
	  String fileName = file.getOriginalFilename();
	  
	System.out.println(fileName);
	  try {
		byte[] fileBytes = file.getInputStream().readAllBytes();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return ResponseEntity.ok("File uploaded successfully.");
	  
}
	 
		File savefile =new ClassPathResource("static/img").getFile();
		
	Path path=	Paths.get(savefile.getAbsolutePath()+File.separator+file.getOriginalFilename());
    Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
    
*/