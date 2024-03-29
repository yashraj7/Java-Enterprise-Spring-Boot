package in.jdbcProject.daofactory;

import in.jdbcProject.persistence.IStudentDao;
import in.jdbcProject.persistence.StudentDaoImpl;

public class StudentDaoFactory {

	private StudentDaoFactory() {
	}

	private static IStudentDao studentDao = null;

	public static IStudentDao getStudentDao() {
		if (studentDao == null)
			studentDao = new StudentDaoImpl();
		
		return studentDao;
	}

}
