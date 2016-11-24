package boots.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import boots.dao.TaskRepository;
import boots.model.Task;

@Service @Transactional
public class TaskService {

	private final TaskRepository tasksRepository;

	public TaskService(TaskRepository tasksRepository) {
		super();
		this.tasksRepository = tasksRepository;
	}
	
	public List<Task> findAll(){
		List<Task> tasks = new ArrayList<Task>();
		for (Task task : tasksRepository.findAll()){
			tasks.add(task);
		}
		return tasks;	
		
	}
	
	public void save(Task task){
		tasksRepository.save(task);
	}
	
	public void delete(int id){
		tasksRepository.delete(id);
	}
	
	public Task findOne (int id){
		return tasksRepository.findOne(id);
	}
	
}
