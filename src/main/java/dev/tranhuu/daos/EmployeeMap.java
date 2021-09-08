package dev.tranhuu.daos;

import java.util.HashMap;
import java.util.Map;

import dev.tranhuu.exceptions.EmployeeAlreadyExistsException;
import dev.tranhuu.models.Employee;
import dev.tranhuu.models.Role;

public class EmployeeMap implements EmployeeDao{

	private Map<Integer, Employee> employees;

	public EmployeeMap() {
		Employee admin = new Employee.Builder("Enrollment_Admin", "password").manager(null).id(0)
				.role(Role.ENROLLMENT_ADMIN).build();

		employees = new HashMap<>();
		employees.put(admin.getId(), admin);
	}

	@Override
	public Employee createEmployee(Employee e) throws EmployeeAlreadyExistsException {
		for(Integer id : employees.keySet()) {
			if(employees.get(id).getUsername().equals(e.getUsername())) {
				throw new EmployeeAlreadyExistsException();
			}
		}
		
		e.setId(employees.size());
		e.setManager(employees.get(0));
		employees.put(e.getId(), e);
		
		return e;
	}

	
}
