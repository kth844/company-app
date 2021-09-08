package dev.tranhuu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.tranhuu.daos.EmployeeDao;
import dev.tranhuu.daos.EmployeeMap;
import dev.tranhuu.exceptions.EmployeeAlreadyExistsException;
import dev.tranhuu.models.Employee;
import dev.tranhuu.models.Role;

public class EmployeeDaoTest {

	private EmployeeDao ed = new EmployeeMap();
	private final Employee admin = new Employee.Builder("Enrollment_Admin", "password")
			.manager(null)
			.id(0)
			.role(Role.ENROLLMENT_ADMIN)
			.build();
	
	@BeforeEach
	void setup() {;
		ed = new EmployeeMap();
	}
	
	@Test
	void createEmployeeValid() throws EmployeeAlreadyExistsException {
		Employee testEmp = new Employee.Builder("test1", "test1").build();
		
		Employee expected = new Employee.Builder("test1", "test1").manager(admin).id(1).build();
		Employee actual = ed.createEmployee(testEmp);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void createEmployeeInvalid() {
		Employee testEmp = new Employee.Builder("Enrollment_Admin", "test1").build();
		
		assertThrows(EmployeeAlreadyExistsException.class, () -> ed.createEmployee(testEmp));
	}
}
