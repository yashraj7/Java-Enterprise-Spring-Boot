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
	public String addStudent(String sname, Integer sage, String saddress) {
		String sqlInsertQuery = "Insert into Student (`name`,`age`,`address`) values(?,?,?)";
		try {
			con = JdbcUtil.getJdbcConnection();

			if (con != null) {
				pstmt = con.prepareStatement(sqlInsertQuery);

				if (pstmt != null) {
					pstmt.setString(1, sname);
					pstmt.setInt(2, sage);
					pstmt.setString(3, saddress);
				}
				int rowsAffected = pstmt.executeUpdate();
				if (rowsAffected >= 1)
					return "success";

			}
		} catch (SQLException | IOException e1) {
			e1.printStackTrace();
		}

		return "Insertion fail";
	}

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

	@Override
	public String updateStudent(Student std) {
		String sqlUpdateQuery = "update student set name = ? , age = ? , address = ? where sid = ?";
		try {
			con = JdbcUtil.getJdbcConnection();

			if (con != null) {
				pstmt = con.prepareStatement(sqlUpdateQuery);
			}
			if (pstmt != null) {
				pstmt.setString(1, std.getSname());
				pstmt.setInt(2, std.getSage());
				pstmt.setString(3, std.getSaddress());
				pstmt.setInt(4, std.getSid());
				
				int rowAffected = pstmt.executeUpdate();

				if (rowAffected >= 1)
					return "success";

				else
					return "Updation Failed";
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public String deleteStudent(Integer sid) {
		String sqlInsertQuery = "delete from student where sid = ? ";
		try {
			con = JdbcUtil.getJdbcConnection();

			if (con != null) {
				pstmt = con.prepareStatement(sqlInsertQuery);

				if (pstmt != null) {
					pstmt.setInt(1, sid);

					int rowsAffected = pstmt.executeUpdate();

					if (rowsAffected == 1)
						return "success";
					else
						return "Not found";
				}

			}
		} catch (SQLException | IOException e1) {
			e1.printStackTrace();
		}

		return "Deletion fail";
	}

}
