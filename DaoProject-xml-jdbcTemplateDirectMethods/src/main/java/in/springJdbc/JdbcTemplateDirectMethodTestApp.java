package in.springJdbc;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.springJdbc.service.EmployeeServiceImpl;
import in.springJdbc.service.IEmployeeManagementService;


public class JdbcTemplateDirectMethodTestApp 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("in/springJdbc/cfg/ApplicationContext.xml");
    	IEmployeeManagementService service = context.getBean(EmployeeServiceImpl.class);
    	int count = service.fetchEmpsCount();
    	System.out.println("Total count of Employees :: " +count);
    	
    	String name = service.getEmployeeByNo(3);
    	System.out.println("Name of the employee is :: " + name);
    	
    	Map<String, Object> record = service.getEmpdetailsById(5);
    	System.out.println("Employee record :: " +record);
    	
    	List<Map<String,Object>> list = service.getEmpByJob("Sales", "Manager");
    	list.forEach(System.out::println);
//    	
//    	int rowsAffected = service.insertEmp("Hithesh", "Consultant", 89700, 21123, 8);
//    	System.out.println("Record Inserted Successfully :: "+ rowsAffected);
//    	
    	int rowsAffected2 = service.addBonusToEmpbyJob("Sales", 4500);
    	System.out.println("Bonus added Succesfully......" + rowsAffected2);
    	((AbstractApplicationContext) context).close();
    }
}
