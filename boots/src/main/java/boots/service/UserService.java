package boots.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import boots.dao.UserRepository;
import boots.model.User;

@Service @Transactional
public class UserService {

	private final UserRepository usersRepository;

	public UserService(UserRepository usersRepository) {
		super();
		this.usersRepository = usersRepository;
	}
	
	public List<User> findAll(){
		List<User> users = new ArrayList<User>();
		for (User user : usersRepository.findAll()){
			users.add(user);
		}
		return users;	
		
	}
	
	public void save(User user){
		usersRepository.save(user);
	}
	
	public void delete(int id){
		usersRepository.delete(id);
	}
	
	public User findOne (int id){
		return usersRepository.findOne(id);
	}	
}