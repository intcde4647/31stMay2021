import java.util.List;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.model.Employee;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EmployeeDao pd=new EmployeeDaoImpl();
		List<Employee>employees=pd.readFromFile();
		pd.writeToDatabase(employees);

	}

}
