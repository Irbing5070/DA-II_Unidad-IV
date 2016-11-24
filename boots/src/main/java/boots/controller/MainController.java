package boots.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boots.model.Employer;
import boots.model.Task;
import boots.model.User;
import boots.service.EmployerService;
import boots.service.TaskService;
import boots.service.UserService;

@Controller
public class MainController {

	@GetMapping("/")
	public String home(HttpServletRequest request){
		 request.setAttribute("mode", "MODE_HOME");
		return "index";
	}
	
	@GetMapping("/task")
	public String task(HttpServletRequest request){
		 request.setAttribute("mode", "MODE_TASK");
		return "task";
	}
	
	@GetMapping("/user")
	public String user(HttpServletRequest request){
		 request.setAttribute("mode", "MODE_USER");
		return "user";
	}
	
	@GetMapping("/employer")
	public String employer(HttpServletRequest request){
		 request.setAttribute("mode", "MODE_EMPLOYER");
		return "employer";
	}
}