package in.jdbcProject.service;

import in.jdbcProject.daofactory.StudentDaoFactory;
import in.jdbcProject.dto.Student;
import in.jdbcProject.persistence.IStudentDao;
import in.jdbcProject.servicefactory.StudentServiceFactory;

public class StudentServiceImpl implements IStudentService {
	// In service layer we write sending email and msg etc etc by using 3rd party apps.
	IStudentDao stdDao;


	@Override
	public Student searchStudent(Integer sid) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.searchStudent(sid);
	}


}
