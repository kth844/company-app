package dev.tranhuu.daos;

public class DaoFactory {

	private static EmployeeDao ed;
	
	public static EmployeeDao getEmployeeDao() {
		
		if(ed == null) {
			ed = new EmployeeMap();
		}
		
		return ed;
	}
	
}
