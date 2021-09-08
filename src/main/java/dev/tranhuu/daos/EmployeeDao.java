package dev.tranhuu.daos;

import dev.tranhuu.exceptions.EmployeeAlreadyExistsException;
import dev.tranhuu.models.Employee;

public interface EmployeeDao {

	Employee createEmployee(Employee e) throws EmployeeAlreadyExistsException;
	
}
