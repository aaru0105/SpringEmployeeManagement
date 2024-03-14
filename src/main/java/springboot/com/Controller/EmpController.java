package springboot.com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import springboot.com.Entity.Employee;
import springboot.com.Services.EmpService;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService  service;
	
	@GetMapping("/")
	public String home(Model m)
	{
		List<Employee> emp= service.getAllEmp();
		
		m.addAttribute("emp",emp);
		
		return "index";
		
	}
	
	@GetMapping("/addemp")
	public String addEmpform()
	{	
		return "add_Emp";
		
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e,HttpSession session)
	{
		System.out.print(e);
		service.add_Emp(e);
		session.setAttribute("msg", "EMPLOYEE ADDED SUCCESSFULLY!!!");
		return "redirect:/";
		
	}
	@GetMapping("/edit/{id}")
	public String editform(@PathVariable int id,Model m)
	{
		Employee e=service.getEmpById(id);
		
		m.addAttribute("emp",e);
		return "edit";	
	}
	
	@PostMapping("/update")
	public String updateform(@ModelAttribute  Employee e,HttpSession session)
	{
		service.add_Emp(e);
		session.setAttribute("msg","DATA UPDATED SUCCESSFULLY!!");
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id , HttpSession session)
	{
		service.deleteEmp(id);
		session.setAttribute("msg","DATA DELETED SUCCESSFULLY!!");
		return "redirect:/";
		
	}
}
