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
import boots.service.EmployerService;

@Controller
public class EmployerController {

	
	@Autowired
	private EmployerService employerService;
	
	@GetMapping ("/all-employers")
	public String allEmployers(HttpServletRequest request){
		request.setAttribute("employers", employerService.findAll());
		request.setAttribute("mode","MODE_EMPLOYERS");
		return "employer";
	}
	
	@GetMapping ("/new-employer")
	public String newEmployer(HttpServletRequest request){
		request.setAttribute("mode","MODE_NEW");
		return "employer";
	}
	
	@GetMapping ("/update-employer")
	public String updateEmployer(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("employer", employerService.findOne(id));
		request.setAttribute("mode","MODE_UPDATE");
		return "employer";
	}
	
	@GetMapping ("/delete-employer")
	public String deleteEmployer(@RequestParam int id, HttpServletRequest request){
		employerService.delete(id);
		request.setAttribute("employers", employerService.findAll());
		request.setAttribute("mode","MODE_EMPLOYERS");
		return "employer";
	}
	
	@PostMapping("/save-employer")
	public String saveEmployer(@ModelAttribute Employer employer, BindingResult bindingResult, HttpServletRequest request){
		employerService.save(employer);
		request.setAttribute("employers", employerService.findAll());
		request.setAttribute("mode","MODE_EMPLOYERS");
		return "employer";
	}
	
}
