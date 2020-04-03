package com.ui.employee.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.ui.employee.model.Employee;

public class EmployeeDAO {
	static Connection connection;
	static ResultSet rsObj = null;
	static Statement stmtObj = null;
	static PreparedStatement psstmtObj = null;

	private static Connection connectDb() {
		System.out.println("dfdf");
		String connUrl = "jdbc:mysql://localhost:3306/uipractice", userNAme = "root", password = "1234Rp";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(connUrl, userNAme, password);
		} catch (Exception exObj) {
			exObj.printStackTrace();
		}
		return connection;
	}

	public static List<Employee> getEmployeeListFromDb() {
		Employee emp = null;
		List<Employee> eList = new ArrayList<Employee>();
		try {
			stmtObj = connectDb().createStatement();

			String sql = "SELECT * FROM uipractice.EmployeeTbl";
			rsObj = stmtObj.executeQuery(sql);
			while (rsObj.next()) {
				emp = new Employee(rsObj.getInt("e_id"), rsObj.getString("e_name"), rsObj.getString("e_email"),
						rsObj.getString("e_gender"));
				eList.add(emp);
			}
		} catch (SQLException sqlExObj) {
			sqlExObj.printStackTrace();
		} finally {
			disconnectDb();
		}
		return eList;
	}

	public static List<Employee> addEmployee(Employee emp) {
		
		List<Employee> eList = new ArrayList<Employee>();
		try {
			stmtObj = connectDb().createStatement();

			String sql = "INSERT INTO uipractice.EmployeeTbl VALUES(?,?,?,?)";

			java.sql.PreparedStatement statement = connectDb().prepareStatement(sql);

			try {
				statement.setInt(1, emp.getEmpId());
				statement.setString(2, emp.getEmpName());
				statement.setString(3, emp.getEmpEmail());
				statement.setString(4, emp.getEmpGender());
				
				if(statement.executeUpdate()>0) 
					System.out.println("Added SuccessFully");
				else 
					System.out.println("Error in add Employee");
				
			} catch (SQLException | NullPointerException e) {
				e.printStackTrace();
			}
		} catch (SQLException sqlExObj) {
			sqlExObj.printStackTrace();
		} finally {
			disconnectDb();
		}
		return eList;
	}

	public static void disconnectDb() {
		try {
			connection.close();
		} catch (SQLException sqlExObj) {
			sqlExObj.printStackTrace();
		}
	}

}
