package boots.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import boots.service.EmployerService;
import boots.service.TaskService;
import boots.service.UserService;

@RestController
public class Controller {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/hello")
	public String hello(){
		return "Hello World Forever";
	}
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/hi")
	public String hi(){
		return "Hi New World";
	}
	
	@Autowired
	private EmployerService employerService;
	
	@GetMapping("/hey")
	public String hey(){
		return "Hey New World";
	}
	
/*	
	@GetMapping("/all-tasks")
	public String allTasks(){
		return taskService.findAll().toString();
	}
	
	@GetMapping("/save")
	public String save(@RequestParam String name, @RequestParam String desc){
		Task task = new Task(name, desc, new Date(), false);
		taskService.save(task);
		return "Task Saved!";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam int id){
		taskService.delete(id);
		return "Task Deleted!";
	}
*/
}