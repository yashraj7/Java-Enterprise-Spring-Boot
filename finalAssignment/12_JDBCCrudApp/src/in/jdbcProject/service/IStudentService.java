package in.jdbcProject.service;

import in.jdbcProject.dto.Student;

public interface IStudentService {
	public String addStudent(String sname, Integer sage, String saddress);

	public Student searchStudent(Integer sid);

	public String updateStudent(Student std);

	public String deleteStudent(Integer sid);
}
