package com.ui.employee.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.google.gson.Gson;
import com.ui.employee.dao.EmployeeDAO;
import com.ui.employee.model.Employee;

@WebServlet("/employeeServlet")
public class EmployeeServlet extends HttpServlet{
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
	        handleRequest(req, resp);
	    }
	 
	 public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		 
	        JSONArray arrayObj = null;
	        List<Employee> empList = null;
	        try {
	 
	            /***** Fetching Employee Records From The Database *****/
	            empList = EmployeeDAO.getEmployeeListFromDb();
	            if(empList != null && empList.size() > 0) {              
	                System.out.println("Total Employee Records Fetch From Db Are?= " + empList.size());
	            } else {
	                System.out.println("No Employee Records Are Present In Db");
	            }
	 
	            arrayObj = new JSONArray(empList);
	            System.out.println(arrayObj);
	            String jObj = new Gson().toJson(arrayObj);
	            System.out.println(jObj);
	            /***** Preparing The Output Response *****/
	            resp.setContentType("text/html");
	            resp.setCharacterEncoding("UTF-8");
	            resp.getWriter().write(jObj);
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }
	
}
