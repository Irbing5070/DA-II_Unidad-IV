package boots.dao;

import org.springframework.data.repository.CrudRepository;
import boots.model.Employer;

public interface EmployerRepository extends CrudRepository<Employer, Integer> {

}