package boots.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boots.model.User;
import boots.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping ("/all-users")
	public String allUsers(HttpServletRequest request){
		request.setAttribute("users", userService.findAll());
		request.setAttribute("mode","MODE_USERS");
		return "user";
	}
	
	@GetMapping ("/new-user")
	public String newUser(HttpServletRequest request){
		request.setAttribute("mode","MODE_NEW");
		return "user";
	}
	
	@GetMapping ("/update-user")
	public String updateUser(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("user", userService.findOne(id));
		request.setAttribute("mode","MODE_UPDATE");
		return "user";
	}
	
	@GetMapping ("/delete-user")
	public String deleteUser(@RequestParam int id, HttpServletRequest request){
		userService.delete(id);
		request.setAttribute("users", userService.findAll());
		request.setAttribute("mode","MODE_USERS");
		return "user";
	}
	
	@PostMapping("/save-user")
	public String saveUser(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request){
		userService.save(user);
		request.setAttribute("users", userService.findAll());
		request.setAttribute("mode","MODE_USERS");
		return "user";
	}
	
}
