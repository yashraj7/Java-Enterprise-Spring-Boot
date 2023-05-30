package in.jdbcProject.service;

import in.jdbcProject.daofactory.StudentDaoFactory;
import in.jdbcProject.dto.Student;
import in.jdbcProject.persistence.IStudentDao;
import in.jdbcProject.servicefactory.StudentServiceFactory;

public class StudentServiceImpl implements IStudentService {
	// In service layer we write sending email and msg etc etc by using 3rd party apps.
	IStudentDao stdDao;

	@Override
	public String addStudent(String sname, Integer sage, String saddress) {
		stdDao = StudentDaoFactory.getStudentDao();

		return stdDao.addStudent(sname, sage, saddress);
	}

	@Override
	public Student searchStudent(Integer sid) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.searchStudent(sid);
	}

	@Override
	public String updateStudent(Student std) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.updateStudent(std);
	}

	@Override
	public String deleteStudent(Integer sid) {
		stdDao = StudentDaoFactory.getStudentDao();

		return stdDao.deleteStudent(sid);
	}

}
