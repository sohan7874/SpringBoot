package com.springboot.JPA;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.springboot.JPA.Dao.UserRepo;
import com.springboot.JPA.Entities.User;

@SpringBootApplication
public class SpringbootWithDbApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootWithDbApplication.class, args);

		UserRepo userrepo = context.getBean(UserRepo.class);

		User u = new User();

		u.setName("sohan");
		u.setCity("rajkot");
		u.setEmail("sohan@gmail.com");

		// single user
	 
		/*
		
		User uu = userrepo.save(u);
		System.out.println(uu);
*/
		
		
		// mmultiple user

		/*
		User u1 = new User();

		u1.setName("ram");
		u1.setCity("ratanpar");
		u1.setEmail("ram@gmail.com");

		User u2 = new User();

		u2.setName("ramesh");
		u2.setCity("ratanpar");
		u2.setEmail("ramesh@gmail.com");

		User u3 = new User();

		u3.setName("ramaji");
		u3.setCity("ratanpar");
		u3.setEmail("ramaji@gmail.com");

		List<User> l1 = List.of(u1, u2, u3);
		userrepo.saveAll(l1);
*/
		
		
		
		
		
		
		
	//Update
		
	/*	
	Optional <User>op=	userrepo.findById(1);
		User user=op.get();
		user.setName("chaku");
		User result = userrepo.save(user);
		System.out.println(result);
		
	*/
		//delete
	//	userrepo.deleteById(11);
		
		
		/*
		 
		    // findByemail,findBycity this called as a  custom method 
		    
		    
		 User l1 =   userrepo.findByemail("sohan@gmail.com");
		System.out.println(l1.getCity());
		
	  List<User>l11 = userrepo.findBycity("ratanpar");
	  
	  l11.forEach(e->System.out.println(e));
	  
		*/
		
		
		
		
	}

}
