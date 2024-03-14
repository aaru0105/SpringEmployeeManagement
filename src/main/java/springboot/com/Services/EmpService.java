package springboot.com.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.com.Entity.Employee;
import springboot.com.Repository.EmpRepo;

@Service
public class EmpService {
	
	@Autowired	
	private EmpRepo repo;
	
	public void add_Emp(Employee e)
	{
		repo.save(e);
	}
	
	public  List<Employee> getAllEmp()
	{
		return repo.findAll();
		
	}
	
	public Employee getEmpById(int id)
	{
		Optional<Employee> e=repo.findById(id);
		if(e.isPresent())
		{
			return e.get();
			}
		return null;		
	}
	
	public void deleteEmp(int id)
	{
		repo.deleteById(id);
	}
}
