package in.jdbcProject.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.jdbcProject.dto.Student;
import in.jdbcProject.util.JdbcUtil;

public class StudentDaoImpl implements IStudentDao {

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	@Override
	public Student searchStudent(Integer sid) {
		String sqlSelectQuery = "select sid,name,age,address from Student where sid = ?";
		Student student = null;
		try {
			con = JdbcUtil.getJdbcConnection();

			if (con != null) {
				pstmt = con.prepareStatement(sqlSelectQuery);
			}
			if (pstmt != null)
				pstmt.setInt(1, sid);

			if (pstmt != null) {
				rs = pstmt.executeQuery();
			}
			if (rs != null) {
				if (rs.next()) {
					// Copying the resultSet data to dto,pojo
					student = new Student();
					student.setSid(rs.getInt(1));
					student.setSname(rs.getString(2));
					student.setSage(rs.getInt(3));
					student.setSaddress(rs.getString(4));

					return student;
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return student;
	}

}
