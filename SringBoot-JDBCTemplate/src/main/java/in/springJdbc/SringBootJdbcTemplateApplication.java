package in.springJdbc;

import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.springJdbc.service.EmployeeServiceImpl;
import in.springJdbc.service.IEmployeeManagementService;

@SpringBootApplication
public class SringBootJdbcTemplateApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SringBootJdbcTemplateApplication.class, args);
		IEmployeeManagementService service = context.getBean(EmployeeServiceImpl.class);
		List<Map<String, Object>> list =service.getEmpByJob("Sales", "Clerk");
		list.forEach(System.out::println);
		
		((ConfigurableApplicationContext) context).close();
	}

}
