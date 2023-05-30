package in.jdbcProject.persistence;

import in.jdbcProject.dto.Student;

public interface IStudentDao {

	public Student searchStudent(Integer sid);

}
