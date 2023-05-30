package in.jdbcProject.persistence;

import in.jdbcProject.dto.Student;

public interface IStudentDao {
	public String addStudent(String sname, Integer sage, String saddress);

	public Student searchStudent(Integer sid);

	public String updateStudent(Student std);

	public String deleteStudent(Integer sid);
}
