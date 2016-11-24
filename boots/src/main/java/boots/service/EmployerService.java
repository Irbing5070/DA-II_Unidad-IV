package boots.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import boots.dao.EmployerRepository;
import boots.model.Employer;

@Service @Transactional
public class EmployerService {

	private final EmployerRepository employersRepository;

	public EmployerService(EmployerRepository employersRepository) {
		super();
		this.employersRepository = employersRepository;
	}
	
	public List<Employer> findAll(){
		List<Employer> employers = new ArrayList<Employer>();
		for (Employer employer : employersRepository.findAll()){
			employers.add(employer);
		}
		return employers;	
		
	}
	
	public void save(Employer employer){
		employersRepository.save(employer);
	}
	
	public void delete(int id){
		employersRepository.delete(id);
	}
	
	public Employer findOne (int id){
		return employersRepository.findOne(id);
	}
}
